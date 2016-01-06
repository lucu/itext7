package com.itextpdf.basics;

import org.junit.Assert;
import org.junit.Test;

public class UtilitiesTest {
    @Test
    public void testShortener() {
        byte[] src = new byte[] {1,2,3,4,5,6,7,8,9,10};
        byte[] dest = new byte[] {1,2,3,4,5};
        byte[] test = Utilities.shortenArray(src, 5);

        Assert.assertArrayEquals(dest, test);
    }
}