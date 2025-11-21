package com.gamersler.appprueba2.ui.frmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.gamersler.appprueba2.mainfr.Cactus;
import com.gamersler.appprueba2.mainfr.Estepicursor;
import com.gamersler.appprueba2.mainfr.tarjetas1;
import com.gamersler.appprueba2.mainfr.tarjetas2;

public class Paginador extends FragmentPagerAdapter {
    private final Context mContext;
    public Paginador(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new tarjetas1();
            case 1:
                return new tarjetas2();
            case 2:
                return new Cactus();
            case 3:
                return new Estepicursor();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
