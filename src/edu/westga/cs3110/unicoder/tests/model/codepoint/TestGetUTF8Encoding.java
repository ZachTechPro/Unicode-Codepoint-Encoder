package edu.westga.cs3110.unicoder.tests.model.codepoint;

import edu.westga.cs3110.unicoder.model.Codepoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGetUTF8Encoding {

    @Test
    public void testSingleByteUTF8() {
        var hexString = "007F";
        Codepoint codepoint = new Codepoint(hexString);
        var expectedValue = "7f";
        var actualValue = codepoint.toUTF8();

        assertEquals(expectedValue, actualValue);
    }
}
