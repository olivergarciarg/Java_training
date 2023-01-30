package com.oliver;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;

public class UtilitiesTest {

    private Utilities util;

    @org.junit.Before
    public void setup() {
        util = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() {
//        Utilities util = new Utilities();
        assertArrayEquals(new char[] {'e','l'}, util.everyNthChar(new char[] {'h','e','l','l','o'},2));
        assertArrayEquals(new char[] {'h','e','l','l','o'}, util.everyNthChar(new char[] {'h','e','l','l','o'},8));
    }

    @org.junit.Test
    public void removePairs() {
//        Utilities util = new Utilities();
        assertEquals("ABCDEF", util.removePairs("ABBCDEEF"));
        assertEquals("ABCBDEF", util.removePairs("ABBCBDEEF"));
        assertNull("is not null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @org.junit.Test
    public void converter() {
//        Utilities util = new Utilities();
        assertEquals(300, util.converter(10, 5));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_arithmeticException() throws Exception {
//        Utilities util = new Utilities();
        util.converter(10, 0);
    }

    @org.junit.Test
    public void nullIfOddLength() {
//        Utilities util = new Utilities();
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}