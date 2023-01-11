package com.security.passgen.service;

import com.security.passgen.BuildObjects;
import com.security.passgen.model.dao.AccountDAO;
import com.security.passgen.model.dto.AccountDTO;
import com.security.passgen.repository.UserRepository;
import com.security.passgen.service.impl.GetSavedAccountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetSavedAccountServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private GetSavedAccountServiceImpl getSavedAccountService;

    @Before
    public void setup() {
        List<AccountDAO> accountList = new ArrayList<>();
        accountList.add(BuildObjects.buildAccountDAO());
        when(userRepository.findAll()).thenReturn(accountList);
        when(userRepository.findAllByServiceName(anyString())).thenReturn(accountList);
    }

    @Test
    public void getAccountsReturnListOfAccounts() {
        List<AccountDTO> accounts = getSavedAccountService.getAccounts();
        Assert.assertEquals(1, accounts.size());
    }

    @Test
    public void getAccountByServiceNameReturnListOfAccountsByServiceName() {
        List<AccountDTO> accounts = getSavedAccountService.getAccountByServiceName("amazon");
        Assert.assertEquals(1, accounts.size());
    }

}
