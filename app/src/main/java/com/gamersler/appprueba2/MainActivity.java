package com.gamersler.appprueba2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.gamersler.appprueba2.databinding.ActivityMainBinding;
import com.gamersler.appprueba2.ui.frmanager.Paginador;

public class MainActivity extends AppCompatActivity {
    Button mainButton;
    TextView mainTV;
    int contador;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Paginador paginador = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = binding.CactusViewPager;
        viewPager.setAdapter(paginador);

//        TextView textMain = findViewById(R.id.TextMain);
//        Bundle bundle = getIntent().getExtras();
//        String saludo = bundle.getString("nombre");
//        textMain.setText("Hello " + saludo);
    }
}