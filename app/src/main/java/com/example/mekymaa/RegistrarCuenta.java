package com.example.mekymaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrarCuenta extends AppCompatActivity {
    EditText nombre,correo,contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);
        nombre=findViewById(R.id.nombre);
        correo=findViewById(R.id.correo);
        contraseña=findViewById(R.id.contraseña);
    }
    public void regresar(View view){
        Intent intent= new Intent(RegistrarCuenta.this, MainActivity.class);
        startActivity(intent);
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
    public void registrar(View view){
        registrarUsuario(nombre.getText().toString(), correo.getText().toString(), contraseña.getText().toString());
        Intent intent= new Intent(RegistrarCuenta.this, MainActivity.class);
        startActivity(intent);
    }

    public void registrarUsuario(String name, String email, String password) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            //input your API parameters
            object.put("name",name);
            object.put("email",email);
            object.put("password",password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Enter the correct url for your api service site
        String url = "https://mekymaa.onrender.com/user";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(RegistrarCuenta.this, "RESULTADO = " + response.toString(), Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegistrarCuenta.this, "error uwu" , Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}