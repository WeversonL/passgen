package com.security.passgen.service;

import com.security.passgen.BuildObjects;
import com.security.passgen.model.Account;
import com.security.passgen.model.dao.AccountDAO;
import com.security.passgen.model.dto.AccountDTO;
import com.security.passgen.repository.UserRepository;
import com.security.passgen.service.impl.SaveAccountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SaveAccountServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private SaveAccountServiceImpl saveAccountServiceImpl;

    private Account account;

    @Before
    public void setup() {
        account = BuildObjects.buildAccount();
        AccountDAO accountDAO = BuildObjects.buildAccountDAO();
        when(userRepository.save(any())).thenReturn(accountDAO);
    }

    @Test
    public void saveAccountByObjectAccountReturnAccountDTO() {
        AccountDTO accountDTO = saveAccountServiceImpl.saveAccount(account);
        Assert.assertNotNull(accountDTO);
    }

}
