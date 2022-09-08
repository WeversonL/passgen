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

import static com.security.passgen.utils.Statics.DASHED;
import static com.security.passgen.utils.Utilities.clearScreen;
import static java.util.Objects.isNull;

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
            validateResponse(accounts);
        } catch (CredentialsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAccountByService(String serviceName) {
        try {
            List<AccountDTO> accounts = getSavedAccountService.getAccountByServiceName(serviceName);
            validateResponse(accounts);
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
        if (isNull(length)) {
            System.out.println("The \"length\" value must be sent");
            throw new IllegalArgumentException();
        } else if (!length.matches("\\d+")) {
            System.out.println("The \"length\" value must contain only positive numeric values");
            throw new IllegalArgumentException();
        }
        return generatePassword.generatePassword(Integer.parseInt(length));
    }

    private void validateResponse(List<AccountDTO> accounts) {
        clearScreen();
        if (accounts.isEmpty()) {
            System.out.println("You don't have saved accounts");
            return;
        }
        for (AccountDTO account : accounts) {
            System.out.println(account);
        }
    }

}
