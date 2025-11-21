package com.gamersler.appprueba2.mainfr;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gamersler.appprueba2.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.Arrays;

public class tarjetas1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tarjetas1 = inflater.inflate(R.layout.fragment_tarjetas1, container, false);

        ArrayList<ConstraintLayout> tarjetas = new ArrayList<>(Arrays.asList(
                tarjetas1.findViewById(R.id.tarjeta1),
                tarjetas1.findViewById(R.id.tarjeta2),
                tarjetas1.findViewById(R.id.tarjeta3),
                tarjetas1.findViewById(R.id.tarjeta4),
                tarjetas1.findViewById(R.id.tarjeta5)
        ));
        for (ConstraintLayout tarjetaa: tarjetas){
            tarjetaa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mostrarError();
                }
            });
        }
        return tarjetas1;
    }
    public void mostrarError(){
        new AlertDialog.Builder(getContext())
                .setTitle("¡Hola!")
                .setMessage("camarón con cola")
                .setPositiveButton("Holaa", (dialog, which) -> Toast.makeText(getContext(), "Hola bro", Toast.LENGTH_SHORT).show())
                .setNegativeButton("cabrón", ((dialog, which) -> Toast.makeText(getContext(), "Diablo", Toast.LENGTH_SHORT))).show();
    }
}
