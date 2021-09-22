package edu.westga.cs3110.unicoder.model;

import java.util.Locale;

/**
 * Codepoint class
 * @version: Fall 2021 - System Architecture
 * @author zmadden
 */
public class Codepoint {

    private String hexString;

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
        var result = "";

        return result;
    }

    /**
     * Will encode the hexstring to UTF-16 as 8-digit, 6-digit, 4-digit, or 2-digit  hexadecimal string, without spaces or '0x' prefix
     */
    public String getUTF8Encoding() {
        var result = "";

        if (this.isUTF8SingleByte()){

        }
        else if (this.isUTF8DoubleByte()){

        }
        else if (this.isUTF8TripleByte()) {

        }
        else if (this.isQuadByteEncoding()){

        }

        return result;
    }

    //TODO make these private when done, and remove the TestHelpers class in the test package.
    public boolean isUTF8SingleByte() {
        var intValueOfHexString = Integer.parseInt(this.hexString, 16);

        return intValueOfHexString >= 0 && intValueOfHexString <= 127;
    }

    public boolean isUTF8DoubleByte() {
        var intValueOfHexString = Integer.parseInt(this.hexString, 16);

        return intValueOfHexString >= 128 && intValueOfHexString <= 2047;
    }

    public boolean isUTF8TripleByte() {
        var intValueOfHexString = Integer.parseInt(this.hexString, 16);

        return intValueOfHexString >= 2048 && intValueOfHexString <= 65535;
    }

    public boolean isQuadByteEncoding() {
        var intValueOfHexString = Integer.parseInt(this.hexString, 16);

        return intValueOfHexString >= 65536 && intValueOfHexString <= 1114111;
    }

    private String padUTF32WithZeroes() {
        var stringLength = this.hexString.length();
        var numZeroesToPadWith = 8 - stringLength;

        for (int i = 1; i <= numZeroesToPadWith;  i++) {
            this.hexString = "0" + this.hexString;
        }

        return this.hexString;
    }
}
