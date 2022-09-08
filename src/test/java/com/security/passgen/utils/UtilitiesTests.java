package com.security.passgen.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UtilitiesTests {

    private String notEncoded;

    @Before
    public void setup() {
        notEncoded = "amazon";
    }

    @Test
    public void base64encode() {
        String encoded = Utilities.base64encode(notEncoded);
        Assert.assertNotEquals(notEncoded, encoded);
    }

    @Test
    public void base64decode() {
        String notEncoded = "amazon";
        String encoded = Utilities.base64encode(notEncoded);
        String decoded = Utilities.base64decode(encoded);
        Assert.assertNotEquals(encoded, notEncoded);
        Assert.assertEquals(decoded, notEncoded);
    }

}
