package junitHometask1.test;

import junitHometask1.RLE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)

public class RLETest {
    private String expected;
    private String value;
    @Parameterized.Parameters
            public static Collection data() {
        return Arrays.asList(new Object[][] {{"4A3a6B\\\\\\1\\2", "AAAAaaaBBBBBB\\12"}, {"1A3a2B\\2", "AaaaBB2"}, {"1A3a2B\\\\\\\\\\2", "AaaaBB\\\\2"}});
    }

    public RLETest(String expected, String value) {
        this.expected = expected;
        this.value = value;
    }

    private RLE rle = new RLE();

    @Test
    public void testConvert() {
        assertEquals(expected, rle.convert(value));
    }
}