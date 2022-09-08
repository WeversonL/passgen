package com.security.passgen;

import com.security.passgen.model.Account;
import com.security.passgen.model.dao.AccountDAO;
import com.security.passgen.model.dto.AccountDTO;

public class BuildObjects {

    public static Account buildAccount() {
        return Account.builder()
                .serviceName("amazon")
                .serviceURL("amazon.com")
                .userName("amazonuser")
                .userPassword("amazonpass")
                .build();
    }

    public static AccountDAO buildAccountDAO() {
        return AccountDAO.builder()
                .id(1L)
                .serviceName("amazon")
                .serviceURL("amazon.com")
                .userName("amazonuser")
                .userPassword("amazonpass")
                .build();
    }

    public static AccountDTO buildAccountDTO() {
        return AccountDTO.builder()
                .id(1L)
                .serviceName("amazon")
                .serviceURL("amazon.com")
                .userName("amazonuser")
                .userPassword("amazonpass")
                .build();
    }

}
