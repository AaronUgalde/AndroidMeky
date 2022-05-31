package com.example.mekymaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class modificarDatos extends AppCompatActivity {
    EditText a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_datos);
        a=findViewById(R.id.nombre);
        b=findViewById(R.id.correo);
        c=findViewById(R.id.contraseña);
    }
    public void regresar(View view){
        Intent intent= new Intent(modificarDatos.this, Principal.class);
        startActivity(intent);
        onDestroy();
    }
    public void cambiar(View view){
        //aqui deben poner el codigo papus---

        //---
        Intent intent= new Intent(modificarDatos.this, MainActivity.class);
        startActivity(intent);
        onDestroy();
    }
    /*
    public void a(View view){
        if (a.getText().toString().equals("      Nombre")){
            a.setText("");
        }
    }
    public void b(View view){
        if (b.getText().toString().equals("      Correo")){
            b.setText("");
        }
    }
    public void c(View view){
        if (c.getText().toString().equals("      Contraseña")){
            c.setText("");
        }
    }*/

}