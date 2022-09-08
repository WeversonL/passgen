package com.security.passgen.service;

import com.security.passgen.model.Account;
import com.security.passgen.model.dto.AccountDTO;

import javax.validation.Valid;

public interface SaveAccountService {
    AccountDTO saveAccount(@Valid Account account);
}
