package com.security.passgen.exception;

public class CredentialsException extends RuntimeException {
    private static final long serialVersionUID = 3317567634657923122L;

    public CredentialsException(String msg) {
        super(msg);
    }
}
