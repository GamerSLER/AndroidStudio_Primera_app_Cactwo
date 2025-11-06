package com.gamersler.appprueba2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SplashScreen extends AppCompatActivity {

    ImageView splashLogo;
    TextView splashText;
    ImageView splashFondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Animation aparicion = AnimationUtils.loadAnimation(this, R.anim.aparecer);

//        splashLogo = findViewById(R.id.LogoIconIV);
//        splashLogo.startAnimation(aparicion);

//        splashText = findViewById(R.id.nameAppTV);
//        splashText.startAnimation(aparicion);

        splashFondo = findViewById(R.id.FondoVSC);
//        splashFondo.startAnimation(aparicion);

        Glide.with(this)
                .load("https://imgs.search.brave.com/q_KHVyG_KYE9f6tjyMw_VztKddzWZwFvj8JxhmmUJGA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWcu/ZnJlZXBpay5jb20v/cHJlbWl1bS1waG90/by9zZWFtbGVzcy10/ZXh0dXJlLWNhY3R1/cy1sZWFmLXN0cnVj/dHVyZS1hcy1iYWNr/Z3JvdW5kLXdhbGxw/YXBlcl8xNTUwMjct/MTE2Mi5qcGc_c2Vt/dD1haXNfaHlicmlk/Jnc9NzQw")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .centerCrop()
                .into(splashFondo);

        launchNextActivity();
    }
    public void launchNextActivity(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Login.class);
                startActivity(intent);
            }
        },2000);
    }
}