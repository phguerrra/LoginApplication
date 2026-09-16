package com.example.application;

import android.content.Context;

import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

final class AuthErrorMessages {
    private AuthErrorMessages() {
    }

    static String from(Context context, Exception exception) {
        if (exception instanceof FirebaseAuthWeakPasswordException) {
            return "A senha é muito fraca.";
        }
        if (exception instanceof FirebaseAuthUserCollisionException) {
            return "Este e-mail já está cadastrado.";
        }
        if (exception instanceof FirebaseAuthInvalidCredentialsException) {
            return "E-mail ou senha inválidos.";
        }
        if (exception instanceof FirebaseNetworkException) {
            return "Sem conexão com o Firebase. Verifique sua internet.";
        }
        if (exception instanceof FirebaseTooManyRequestsException) {
            return "Muitas tentativas. Aguarde um pouco e tente novamente.";
        }
        return context.getString(R.string.generic_error);
    }
}
