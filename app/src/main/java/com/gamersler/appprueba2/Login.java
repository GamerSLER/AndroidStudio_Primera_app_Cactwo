package com.gamersler.appprueba2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.SignButton);
        TextView register_tv = findViewById(R.id.RegisterTV);
        TextInputLayout correoTIL = findViewById(R.id.LLoginTIL);
        TextInputLayout passTIL = findViewById(R.id.LContrasenaTIL);


        register_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correoIngresado = String.valueOf(correoTIL.getEditText().getText());
                String passIngresada = String.valueOf(passTIL.getEditText().getText());

                if (correoIngresado.isEmpty()) {
                    correoTIL.setError("Introduce un correo");
                    return;
                } else correoTIL.setError(null);

                if (passIngresada.isEmpty()) {
                    passTIL.setError("Introduce una contraseña");
                    return;
                } else passTIL.setError(null);

                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(Login.this);

                String correoGuardado = sharedPreferences.getString("correo", "");
                String passGuardada = sharedPreferences.getString("password", "");

                if (correoIngresado.equals(correoGuardado) &&
                        passIngresada.equals(passGuardada)) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    passTIL.setError("Correo o contraseña incorrectos");
                }
            }
        });
    }
}
