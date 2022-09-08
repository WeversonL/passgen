package com.security.passgen.service.impl;

import com.security.passgen.exception.CredentialsException;
import com.security.passgen.model.dao.AccountDAO;
import com.security.passgen.model.dto.AccountDTO;
import com.security.passgen.repository.UserRepository;
import com.security.passgen.service.GetSavedAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.security.passgen.adapter.Conversors.toAccountDTOList;

@Service
public class GetSavedAccountServiceImpl implements GetSavedAccountService {

    private final UserRepository userRepository;

    @Autowired
    public GetSavedAccountServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<AccountDTO> getAccountByServiceName(String serviceName) {
        try {
            List<AccountDAO> accounts = userRepository.findAllByServiceName(serviceName);
            return toAccountDTOList(accounts);
        } catch (Exception e) {
            throw new CredentialsException("Database search error");
        }
    }

    @Override
    public List<AccountDTO> getAccounts() {
        try {
            List<AccountDAO> accounts = userRepository.findAll();
            return toAccountDTOList(accounts);
        } catch (Exception e) {
            throw new CredentialsException("Database search error");
        }
    }

}
