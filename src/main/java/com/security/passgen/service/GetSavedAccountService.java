package com.security.passgen.service;

import com.security.passgen.model.dto.AccountDTO;

import java.util.List;

public interface GetSavedAccountService {
    List<AccountDTO> getAccountByServiceName(String serviceName);
    List<AccountDTO> getAccounts();
}
