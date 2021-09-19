package edu.westga.cs3110.unicoder.tests.model.codepoint;

import edu.westga.cs3110.unicoder.model.Codepoint;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class to ensure that the correct hexadecimal format is returned
 * when using 32-bit encoding
 *
 *  @author zmadden
 *  @version: Fall 2021
 */
public class TestGetUTF32Encoding {

    @Test
    public void testValidInput() {
        var hexString = "10FFFA";
        Codepoint codepoint = new Codepoint(hexString);
        var expectedValue = "0010FFFA";
        var actualValue = codepoint.getUTF32Encoding();

        assertEquals(expectedValue, actualValue);
    }
}
