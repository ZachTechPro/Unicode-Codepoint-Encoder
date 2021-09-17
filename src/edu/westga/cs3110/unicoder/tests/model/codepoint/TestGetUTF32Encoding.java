package edu.westga.cs3110.unicoder.tests.model.codepoint;
import edu.westga.cs3110.unicoder.model.Codepoint;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class to ensure that the correct hexadecimal format is returned
 * when using 32-bit encoding
 *
 * @version: Fall 2021
 * @author zmadden
 */
public class TestGetUTF32Encoding {

    @Test
    public void testValidInput() {

        Codepoint codepoint = new Codepoint("10FFFA");
        var expectedValue = "0010FFFA";
        var actualValue = codepoint.getUTF32Encoding();

        assertEquals(expectedValue, actualValue);
    }
}
