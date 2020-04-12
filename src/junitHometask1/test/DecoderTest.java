package junitHometask1.test;

import junitHometask1.Decoder;
import junitHometask1.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)

public class DecoderTest {

    private String expected;
    private String value;
    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {{"AAAAaaaBBBBBB\\12", "4A3a6B\\\\\\1\\2"}, {"AaaaBB2", "1A3a2B\\2"}, {"AAAAaaaBBBBBB\\12", "4A3a6B\\\\\\1\\2"}});
    }

    public DecoderTest(String expected, String value) {
        this.expected = expected;
        this.value = value;
    }

    private Decoder decoder = new Decoder();

    @Test (expected = ValidationException.class)
    public void testValidate() {
        decoder.validate("4A3a6B\\\\1\\2");
    }

    @Test
    public void testConvert() {
        assertEquals(expected, decoder.convert(value));
    }
}