package com.security.passgen.repository;

import com.security.passgen.BuildObjects;
import com.security.passgen.model.dao.AccountDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {
        List<AccountDAO> accountDAOList = new ArrayList<>();
        AccountDAO accountDAO = BuildObjects.buildAccountDAO();
        accountDAOList.add(accountDAO);
        when(userRepository.findAll()).thenReturn(accountDAOList);
    }

    @Test
    public void testUserRepository() {
        System.out.println("error");
        List<AccountDAO> all = userRepository.findAll();
        Assert.assertNotNull(all);
    }

}
