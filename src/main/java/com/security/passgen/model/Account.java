package com.security.passgen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @NotBlank(message = "The 'service' field is required")
    private String serviceName;

    private String serviceURL;

    @NotBlank(message = "The 'username' field is required")
    private String userName;

    @NotBlank(message = "The 'password' field is required")
    private String userPassword;

}
