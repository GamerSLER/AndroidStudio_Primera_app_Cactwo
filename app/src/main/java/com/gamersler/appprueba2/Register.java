package com.gamersler.appprueba2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextInputLayout r_nombres_til = findViewById(R.id.RnombresTIL);
        TextInputLayout r_correo_til = findViewById(R.id.RcorreoTIL);
        TextInputLayout r_password_til = findViewById(R.id.RPasswordTIL);
        TextInputLayout r_confirmpassword_til = findViewById(R.id.RConfirmPasswordTIL);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Button button = findViewById(R.id.Rbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean cont = true;
                boolean nombreVerificado = emptyVerify(r_nombres_til);
                boolean correoVerificado = emptyVerify(r_correo_til) && emailVerify(r_correo_til);
                boolean passwordVerificado = passwordsVerify(r_password_til, r_confirmpassword_til);

                cont = nombreVerificado && correoVerificado && passwordVerificado;

                if (cont) {
                    editor.putString("nombre", String.valueOf(r_nombres_til.getEditText().getText()));
                    editor.putString("correo", String.valueOf(r_correo_til.getEditText().getText()));
                    editor.putString("password", String.valueOf(r_password_til.getEditText().getText()));
                    editor.apply();
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }
            }
        });
    }
    public static boolean emptyVerify(TextInputLayout textInputLayout){
        boolean retrn;
        String text = String.valueOf(textInputLayout.getEditText().getText());
        if (text.isEmpty()){
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("Este campo no puede ser vacio.");
            retrn = false;
        } else {
            textInputLayout.setErrorEnabled(false);
            retrn = true;
        }
        return retrn;
    }

    public static boolean emailVerify(TextInputLayout textInputLayout){
        boolean retrn;
        String email = String.valueOf(textInputLayout.getEditText().getText());
        if (!email.endsWith("@gmail.com")){
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("El correo introducido es incorrecto.");
            retrn = false;
        } else {
            textInputLayout.setErrorEnabled(false);
            retrn = true;
        }
        return retrn;
    }

    public static boolean passwordsVerify(TextInputLayout textInputLayout, TextInputLayout textInputLayout2){
        boolean retrn;
        String password = String.valueOf(textInputLayout.getEditText().getText());
        String checkPassword = String.valueOf(textInputLayout2.getEditText().getText());

        if (password.isEmpty()){
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("Este campo no puede ser vacio");
            retrn = false;
        } else if (!password.equals(checkPassword)){
            textInputLayout2.setErrorEnabled(true);
            textInputLayout.setErrorEnabled(true);
            textInputLayout2.setError("Las contraseña no coincide.");
            retrn = false;
        } else {
            textInputLayout.setErrorEnabled(false);
            textInputLayout2.setErrorEnabled(false);
            retrn = true;
        }

        if (checkPassword.isEmpty()){
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("Este campo no puede ser vacio");
            retrn = false;
        } else if (!password.equals(checkPassword)){
            textInputLayout2.setErrorEnabled(true);
            textInputLayout.setErrorEnabled(true);
            textInputLayout2.setError("Las contraseña no coincide.");
            retrn = false;
        } else {
            textInputLayout.setErrorEnabled(false);
            textInputLayout2.setErrorEnabled(false);
            retrn = true;
        }
        return retrn;
    }
}