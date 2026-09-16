package com.example.application;

import androidx.annotation.Nullable;

import java.util.regex.Pattern;

final class AuthInputValidator {
    static final int MIN_PASSWORD_LENGTH = 6;
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",
            Pattern.CASE_INSENSITIVE
    );


    @Nullable
    static String validateName(String name) {
        if (name.trim().length() < 2) {
            return "Informe seu nome.";
        }
        return null;
    }

    @Nullable
    static String validateEmail(String email) {
        if (email.trim().isEmpty() || !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            return "Informe um e-mail válido.";
        }
        return null;
    }
    @Nullable
    static String validatePassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            return "A senha deve ter pelo menos 6 caracteres.";
        }
        return null;
    }
}
