package edu.westga.cs3110.unicoder.tests.model.codepoint;

import edu.westga.cs3110.unicoder.model.Codepoint;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test Class to ensure that an exception is thrown when passing null as input to the constructor.
 *
 * @version Fall 2021
 * @author zmadden
 */
public class TestConstructor {

    @Test
    public void testThrowsExceptionOnNullInput() {
        assertThrows(NullPointerException.class, () -> {
            Codepoint badParamCodepoint = new Codepoint(null);
        });
    }
}
