package com.security.passgen.service;

import com.security.passgen.service.impl.GeneratePasswordImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GeneratePasswordTests {

    @InjectMocks
    private GeneratePasswordImpl generatePassword;

    @Test
    public void afterOneHundredAndEightyDayschecksIfThePasswordHasTheNumberOfCharacters() {
        int size = 28;
        String password = generatePassword.generatePassword(size);
        Assert.assertEquals(size, password.length());
    }

}
