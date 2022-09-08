package com.security.passgen.adapter;

import com.security.passgen.BuildObjects;
import com.security.passgen.model.Account;
import com.security.passgen.model.dao.AccountDAO;
import com.security.passgen.model.dto.AccountDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ConversorsTests {

    private List<AccountDAO> accountDAOList;
    private AccountDAO accountDAO;
    private Account account;

    @Before
    public void setup() {
        accountDAOList = new ArrayList<>();
        accountDAO = BuildObjects.buildAccountDAO();
        account = BuildObjects.buildAccount();
    }

    @Test
    public void toAccountDTOListConversion() {
        accountDAOList.add(accountDAO);
        List<AccountDTO> accountDTOS = Conversors.toAccountDTOList(accountDAOList);
        Assert.assertNotNull(accountDTOS);
    }

    @Test
    public void toAccountDTOConversion() {
        AccountDTO accountDTO = Conversors.toAccountDTO(accountDAO);
        Assert.assertNotNull(accountDTO);
    }

    @Test
    public void toAccountDAOConversion() {
        AccountDAO accountDAO = Conversors.toAccountDAO(account);
        Assert.assertNotNull(accountDAO);
    }

}
