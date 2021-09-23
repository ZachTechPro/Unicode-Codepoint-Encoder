package edu.westga.cs3110.unicoder.tests.model.codepoint;

import edu.westga.cs3110.unicoder.model.Codepoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGetUTF26Encoding {

    @Test
    public void testSingleByteUTF16() {
        var hexString = "D7FF";
        Codepoint codepoint = new Codepoint(hexString);
        var expectedValue = "d7ff";
        var actualValue = codepoint.toUTF16();

        assertEquals(expectedValue, actualValue);
    }
}
