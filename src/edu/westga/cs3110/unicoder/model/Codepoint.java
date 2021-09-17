package edu.westga.cs3110.unicoder.model;

import java.security.InvalidParameterException;

/**
 * Codepoint class
 * @version: Fall 2021 - System Architecture
 * @author zmadden
 */
public class Codepoint {

    private String hexString;

    public Codepoint(String hexString){
        if (hexString.equals(null)) {
            throw new NullPointerException("Cannot pass Null as a parameter");
        }
        this.hexString = hexString;
    }

    /**
     * Will encode the hexstring to UTF-32 as 8-digit hexadecimal string, without spaces or '0x' prefix
     */
    public String getUTF32Encoding() {
        String result = "00" + this.hexString;
        return result;
    }

    /**
     * Will encode the hexstring to UTF-16 as 8-digit, or 4-digit, hexadecimal string, without spaces or '0x' prefix
     */
    public String getUTF16Encoding() {
        String result = "";

        return result;
    }

    /**
     * Will encode the hexstring to UTF-16 as 8-digit, 6-digit, 4-digit, or 2-digit  hexadecimal string, without spaces or '0x' prefix
     */
    public String getUTF8Encoding() {
        String result = "";

        return result;
    }
}
