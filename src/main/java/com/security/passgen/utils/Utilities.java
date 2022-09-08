package com.security.passgen.utils;

import java.util.Base64;

public class Utilities {

    private Utilities() {
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String base64encode(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static String base64decode(String passwordEncoded) {
        byte[] decodedBytes = Base64.getDecoder().decode(passwordEncoded);
        return new String(decodedBytes);
    }

}
