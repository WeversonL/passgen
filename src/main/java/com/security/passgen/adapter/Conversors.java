package com.security.passgen.adapter;

import com.security.passgen.model.Account;
import com.security.passgen.model.dao.AccountDAO;
import com.security.passgen.model.dto.AccountDTO;

import java.util.List;
import java.util.stream.Collectors;

import static com.security.passgen.utils.Utilities.base64decode;

public class Conversors {

    private Conversors() {
    }

    public static List<AccountDTO> toAccountDTOList(List<AccountDAO> accountDAOList) {
        return accountDAOList.stream()
                .map(Conversors::toAccountDTO)
                .collect(Collectors.toList());
    }

    public static AccountDTO toAccountDTO(AccountDAO accountDAO) {
        return AccountDTO.builder()
                .id(accountDAO.getId())
                .serviceName(accountDAO.getServiceName())
                .serviceURL(accountDAO.getServiceURL())
                .userName(accountDAO.getUserName())
                .userPassword(base64decode(accountDAO.getUserPassword()))
                .build();
    }

    public static AccountDAO toAccountDAO(Account account) {
        return AccountDAO.builder()
                .serviceName(account.getServiceName())
                .serviceURL(account.getServiceURL())
                .userName(account.getUserName())
                .userPassword(account.getUserPassword())
                .build();
    }

}
