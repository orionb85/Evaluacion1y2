package com.example.evaluacion1y2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView creaNombre, creaPass;
    private Contacto contactoNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creaNombre =findViewById(R.id.creaNombre);
        creaPass =findViewById(R.id.creaPass);
    }

    public void CrearUsuario(View view){
        String nombre = creaNombre.getText().toString();
        String pass=creaPass.getText().toString();

        if(nombre.equals("") || pass.equals("")){
            Toast.makeText(MainActivity.this, "Debe completar Usuario y clave", Toast.LENGTH_SHORT).show();
        }else {

            contactoNuevo = new Contacto(creaNombre.getText().toString(),creaPass.getText().toString());
            Intent intent=new Intent(this,Reservar.class);
            intent.putExtra("contacto",contactoNuevo);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Usuario Correcto", Toast.LENGTH_SHORT).show();
        }
    }

}