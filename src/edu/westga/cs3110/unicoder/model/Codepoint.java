package edu.westga.cs3110.unicoder.model;

import java.util.Locale;

/**
 * Codepoint class
 * @version: Fall 2021 - System Architecture
 * @author zmadden
 */
public class Codepoint {

    private String hexString;
    private String byteCategory;
    private int intValueOfHexString;

    /**
     * Constructor
     * @param hexString -- the hexString to convert
     * @pre hexString != null
     * @post hexString@prev = hexString
     */
    public Codepoint(String hexString) {
        if (hexString.equals(null)) {
            throw new NullPointerException("Cannot pass Null as a parameter");
        }

        this.hexString = hexString.toLowerCase(Locale.ROOT);
        this.intValueOfHexString = Integer.parseInt(this.hexString, 16);
        this.byteCategory = "";
    }

    /**
     * Will encode the hexstring to UTF-32 as 8-digit hexadecimal string, without spaces or '0x' prefix
     */
    public String getUTF32Encoding() {
       return this.padUTF32WithZeroes();
    }

    /**
     * Will encode the hexstring to UTF-16 as 8-digit, or 4-digit, hexadecimal string, without spaces or '0x' prefix
     */
    public String getUTF16Encoding() {
        var result = (this.isInValidTwoByteUTF16Encoding()) ?
                this.hexString : this.encodoeUTF16AsQuadByte();

        return result;
    }

    /**
     * Will encode the hexstring to UTF-16 as 8-digit, 6-digit, 4-digit, or 2-digit  hexadecimal string, without spaces or '0x' prefix
     */
    public String getUTF8Encoding() {
        var result = "";


        // Reverse the bits and, shift them appropriately, and add the extra bits to it (those have to be in reverse order also)
        // Once that's done, then that section should be in reverse order, and then we reverse it back and have the answer in binary.
        // Finally, put it all back together in the correct order and turn it into a hex value, make it a string and return it.

        this.checkIsUTF8QuadByte();
        this.checkIsUTF8TripleByte();
        this.checkIsUTF8DoubleByte();
        this.checkIsUTF8SingleByte();

        switch (this.byteCategory) {
            case "SINGLE":  result = this.encodeAsSingleByte(); break;
            case "DOUBLE":  result = this.encodeAsDoubleByte(); break;
            case "TRIPLE":  result = this.encodeAsTripleByte(); break;
            case "QUAD":    result = this.encodeAsQuadByte(); break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.byteCategory);
        }

        return result;
    }

    private String encodeAsQuadByte() {
        return "quad";
    }

    private String encodeAsTripleByte() {
        return "triple";
    }

    private String encodeAsDoubleByte() {
        return "double";
    }

    private String encodeAsSingleByte() {
        var bottomEightBits = this.intValueOfHexString & 0b000000000000011111111;

        return Integer.toHexString(bottomEightBits);

    }

    //TODO make these private when done, and remove the TestHelpers class in the test package.

    private String encodoeUTF16AsQuadByte() {
        return "";
    }

    private boolean isInValidTwoByteUTF16Encoding() {

        return (this.intValueOfHexString >= 0 &&
                this.intValueOfHexString <= 55295 ||
                this.intValueOfHexString >= 57344 &&
                this.intValueOfHexString <= 65535);

    }

    public void checkIsUTF8SingleByte() {

        if (this.intValueOfHexString >= 0 && this.intValueOfHexString <= 127) {
            this.byteCategory = "SINGLE";
        }
    }

    public void checkIsUTF8DoubleByte() {

       if (this.intValueOfHexString >= 128 && this.intValueOfHexString <= 2047) {
           this.byteCategory = "DOUBLE";
       }
    }

    public void checkIsUTF8TripleByte() {

        if (intValueOfHexString >= 2048 && this.intValueOfHexString <= 65535) {
            this.byteCategory = "TRIPLE";
        }
    }

    public void checkIsUTF8QuadByte() {

        if(this.intValueOfHexString >= 65536 && this.intValueOfHexString <= 1114111) {
            this.byteCategory = "QUAD";
        }
    }

    private String padUTF32WithZeroes() {

        return String.format("%08x", this.intValueOfHexString);
    }
}
