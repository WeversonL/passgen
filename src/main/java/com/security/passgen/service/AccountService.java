package com.security.passgen.service;

import com.security.passgen.model.Account;

public interface AccountService {
    void getAccounts();

    void getAccountByService(String serviceName);

    void saveAccount(Account account);

    String generatePassword(String length);
}
