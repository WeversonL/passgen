package com.security.passgen.service;

import com.security.passgen.service.impl.AccountServiceImpl;
import com.security.passgen.service.impl.GeneratePasswordImpl;
import com.security.passgen.service.impl.GetSavedAccountServiceImpl;
import com.security.passgen.service.impl.SaveAccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @Mock
    private SaveAccountServiceImpl saveAccountService;

    @Mock
    private GetSavedAccountServiceImpl getSavedAccountService;

    @Mock
    private GeneratePasswordImpl generatePassword;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    public void checkCallsToMethodGetAccounts() {
        accountService.getAccounts();
        verify(getSavedAccountService, times(1)).getAccounts();
    }

    @Test
    public void checkCallsToMethodGetAccountByService() {
        accountService.getAccountByService("amazon");
        verify(getSavedAccountService, times(1)).getAccountByServiceName("amazon");
    }

    @Test
    public void checkCallsToMethodSaveAccount() {
        accountService.saveAccount(any());
        verify(saveAccountService, times(1)).saveAccount(any());
    }

    @Test
    public void checkCallsToMethodGeneratePassword() {
        accountService.generatePassword("1");
        verify(generatePassword, times(1)).generatePassword(1);
    }

}
