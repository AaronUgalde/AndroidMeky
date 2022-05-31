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

public class MainActivity extends AppCompatActivity {
    EditText a,b;
    String id, correo, name, contraseña, role, winrate, token;
    int ppm, mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.correo);
        b=findViewById(R.id.contraseña);
    }
    public void crearcuenta(View view){
        Intent intent= new Intent(MainActivity.this, RegistrarCuenta.class);
        startActivity(intent);
    }
    public void iniciarsesion(View view){

        iniciarSesion(a.getText().toString(), b.getText().toString());

    }

    public void iniciarSesion (String email, String password) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            //input your API parameters
            object.put("email",email);
            object.put("password",password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Enter the correct url for your api service site
        String url = "https://mekymaa.onrender.com/auth";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            token = response.getString("token");
                            id = response.getJSONObject("user").getString("_id");
                            correo = email;
                            name = response.getJSONObject("user").getString("name");
                            contraseña = password;
                            role = response.getJSONObject("user").getString("user");
                            ppm = response.getJSONObject("user").getInt("ppm");
                            winrate = response.getJSONObject("user").getString("winrate");
                            mp = response.getJSONObject("user").getInt("mp");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(MainActivity.this, "RESULTADO = " + mp, Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(MainActivity.this, Principal.class);
                        intent.putExtra("token", token);
                        intent.putExtra("id", id);
                        intent.putExtra("email", correo);
                        intent.putExtra("name", name);
                        intent.putExtra("password", contraseña);
                        intent.putExtra("role", role);
                        intent.putExtra("ppm", ppm);
                        intent.putExtra("winrate", winrate);
                        intent.putExtra("mp", mp);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "correo o contraseña incorrectos uwu" , Toast.LENGTH_LONG).show();
            }
        }){
            
        };
        requestQueue.add(jsonObjectRequest);
    }
    /*
    public void a(View view){
        if (a.getText().toString().equals("      Correo")){
            a.setText("");
        }
    }
    public void b(View view){
        if (b.getText().toString().equals("      Contraseña")){
            b.setText("");
        }
    }*/

}