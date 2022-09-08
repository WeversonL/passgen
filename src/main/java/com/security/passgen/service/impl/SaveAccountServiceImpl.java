package com.security.passgen.service.impl;

import com.security.passgen.exception.CredentialsException;
import com.security.passgen.model.Account;
import com.security.passgen.model.dao.AccountDAO;
import com.security.passgen.model.dto.AccountDTO;
import com.security.passgen.repository.UserRepository;
import com.security.passgen.service.SaveAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import static com.security.passgen.adapter.Conversors.toAccountDAO;
import static com.security.passgen.adapter.Conversors.toAccountDTO;
import static com.security.passgen.utils.Utilities.base64encode;

@Service
@Validated
public class SaveAccountServiceImpl implements SaveAccountService {

    private final UserRepository userRepository;

    @Autowired
    public SaveAccountServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AccountDTO saveAccount(@Valid Account account) {
        try {
            account.setUserPassword(base64encode(account.getUserPassword()));
            AccountDAO saved = userRepository.save(toAccountDAO(account));
            return toAccountDTO(saved);
        } catch (Exception e) {
            throw new CredentialsException("There was an error entering the data");
        }
    }
}
