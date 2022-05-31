package com.example.mekymaa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Progreso extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView ppm,winrate,mp;
    public Progreso() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_progreso, container, false);
        ppm = vista.findViewById(R.id.ppm);
        winrate = vista.findViewById(R.id.winrate);
        mp = vista.findViewById(R.id.mp);
        ppm.setText(String.valueOf(getArguments().getInt("ppm")));
        //winrate.setText(getArguments().getString("winrate"));
        //mp.setText(String.valueOf(getArguments().getString("mp")));
        return vista;
    }
}