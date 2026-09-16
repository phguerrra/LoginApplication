package com.example.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AuthInputValidatorTest {
    @Test
    public void nameRequiresAtLeastTwoCharacters() {
        assertEquals("Informe seu nome.", AuthInputValidator.validateName("A"));
        assertNull(AuthInputValidator.validateName("Ana"));
    }

    @Test
    public void emailMustBeValid() {
        assertEquals("Informe um e-mail válido.", AuthInputValidator.validateEmail("invalido"));
        assertNull(AuthInputValidator.validateEmail("ana@exemplo.com"));
    }

    @Test
    public void passwordRequiresSixCharacters() {
        assertEquals("A senha deve ter pelo menos 6 caracteres.", AuthInputValidator.validatePassword("12345"));
        assertNull(AuthInputValidator.validatePassword("123456"));
    }
}
