package com.example.mekymaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView a,b,c,usuario,mekyp;
    Drawable Back;
    String id, email, name, password, role, winrate, token;
    int ppm, mp;
    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        a= findViewById(R.id.textViewP);
        b= findViewById(R.id.textViewP4);
        c= findViewById(R.id.textViewP5);
        usuario = findViewById(R.id.textView3);
        mekyp = findViewById(R.id.textView4);
        Back=a.getBackground();
        datos = getIntent().getExtras();
        id = datos.getString("id");
        email = datos.getString("email");
        name = datos.getString("name");
        password = datos.getString("password");
        role = datos.getString("role");
        ppm = datos.getInt("ppm");
        winrate = datos.getString("winrate");
        mp = datos.getInt("mp");
        token = datos.getString("token");

        usuario.setText(name);
        mekyp.setText(String.valueOf("Mekypoints: "+mp));
    }
    public void ajustes(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Ajustes fragmentAjustes = new Ajustes();
        Bundle datosAjustes  = new Bundle();
        datosAjustes.putInt("mp", mp);
        datosAjustes.putString("name", name);
        datosAjustes.putString("email", email);
        datosAjustes.putString("id", id);
        fragmentAjustes.setArguments(datosAjustes);
        transaction.setReorderingAllowed(true);

// Replace whatever is in the fragment_container view with this fragment
        transaction.replace(R.id.contenedor, fragmentAjustes);

// Commit the transaction
        transaction.commit();
        c.setBackground(Back);
        a.setBackground(null);
        b.setBackground(null);
    }
    public void progreso(View view){
        // Create new fragment and transaction
        Progreso fragmentProgreso = new Progreso();
        Bundle datosProgreso = new Bundle();
        datosProgreso.putInt("ppm",ppm);
        datosProgreso.putString("winrate",winrate);
        datosProgreso.putInt("mp",mp);
        fragmentProgreso.setArguments(datosProgreso);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setReorderingAllowed(true);

// Replace whatever is in the fragment_container view with this fragment
        transaction.replace(R.id.contenedor, fragmentProgreso);

// Commit the transaction
        transaction.commit();
        a.setBackground(Back);
        c.setBackground(null);
        b.setBackground(null);
    }
    public void ranking(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);

// Replace whatever is in the fragment_container view with this fragment
        transaction.replace(R.id.contenedor, Ranking.newInstance("",""));

// Commit the transaction
        transaction.commit();
        b.setBackground(Back);
        a.setBackground(null);
        c.setBackground(null);
    }
}