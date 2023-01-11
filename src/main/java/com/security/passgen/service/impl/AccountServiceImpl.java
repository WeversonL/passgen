package com.security.passgen.service.impl;

import com.security.passgen.exception.CredentialsException;
import com.security.passgen.model.Account;
import com.security.passgen.model.dto.AccountDTO;
import com.security.passgen.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

import static com.security.passgen.utils.Statics.*;
import static com.security.passgen.utils.Utilities.clearScreen;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final SaveAccountServiceImpl saveAccountService;
    private final GetSavedAccountServiceImpl getSavedAccountService;
    private final GeneratePasswordImpl generatePassword;

    @Override
    public void getAccounts() {
        try {
            List<AccountDTO> accounts = getSavedAccountService.getAccounts();
            showAccounts(accounts);
        } catch (CredentialsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAccountByService(String serviceName) {
        try {
            List<AccountDTO> accounts = getSavedAccountService.getAccountByServiceName(serviceName);
            showAccounts(accounts);
        } catch (CredentialsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveAccount(Account account) {
        clearScreen();
        try {
            System.out.println(saveAccountService.saveAccount(account));
        } catch (CredentialsException e) {
            System.out.println(e.getMessage());
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
                System.out.println(DASHED);
                System.out.println(violation.getMessage());
            }
        }
    }

    @Override
    public String generatePassword(String length) {
        clearScreen();
        if (isBlank(length)) {
            System.out.println(LENGTH_REQUIRED);
            throw new CredentialsException(LENGTH_REQUIRED);
        } else if (!length.matches("\\d+")) {
            System.out.println(LENGTH_EXCEPTION);
            throw new CredentialsException(LENGTH_EXCEPTION);
        }
        return generatePassword.generatePassword(Integer.parseInt(length));
    }

    private void showAccounts(List<AccountDTO> accounts) {
        clearScreen();
        if (accounts.isEmpty()) {
            System.out.println("You don't have saved accounts");
            return;
        }
        accounts.forEach(System.out::println);
    }

}
