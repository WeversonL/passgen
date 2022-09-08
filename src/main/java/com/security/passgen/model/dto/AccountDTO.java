package com.security.passgen.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.security.passgen.utils.Statics.DASHED;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Long id;
    private String serviceName;
    private String serviceURL;
    private String userName;
    private String userPassword;

    @Override
    public String toString() {
        return DASHED + "\n" +
                "ID: " + id +
                "\nSERVICE: " + serviceName +
                "\nURL:" + serviceURL +
                "\nUSERNAME: " + userName +
                "\nPASSWORD: " + userPassword;
    }

}
