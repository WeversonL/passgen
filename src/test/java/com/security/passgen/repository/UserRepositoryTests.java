package com.security.passgen.repository;

import com.security.passgen.BuildObjects;
import com.security.passgen.model.dao.AccountDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class UserRepositoryTests {

    private UserRepository userRepository;

    @Before
    public void setup() {

        userRepository = mock(UserRepository.class);
        List<AccountDAO> accountDAOList = new ArrayList<>();
        AccountDAO accountDAO = BuildObjects.buildAccountDAO();
        accountDAOList.add(accountDAO);
        when(userRepository.findAll()).thenReturn(accountDAOList);
        when(userRepository.findAllByServiceName(anyString())).thenReturn(accountDAOList);
        when(userRepository.save(any(AccountDAO.class)))
                .thenAnswer(i -> i.getArguments()[0]);
    }

    @Test
    public void testUserRepositoryFindAll() {
        List<AccountDAO> all = userRepository.findAll();
        Assert.assertNotNull(all);
    }

    @Test
    public void testUserRepositoryFindByServiceName() {
        String serviceName = "amazon";
        List<AccountDAO> all = userRepository.findAllByServiceName(serviceName);
        Assert.assertNotNull(all);
    }

    @Test
    public void testUserRepositorySave() {
        AccountDAO accountDAO = BuildObjects.buildAccountDAO();
        AccountDAO save = userRepository.save(accountDAO);
        Assert.assertNotNull(save);
    }

}
