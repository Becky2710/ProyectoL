package com.example.proyectol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.proyectol.clases.Trabajador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAgregar, btnirMostrar, btnirAcercaDe;
    public static ArrayList<Trabajador> lstTrabajadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstTrabajadores = new ArrayList<Trabajador>();

        btnAgregar = findViewById(R.id.btnAgregar);
        btnirMostrar = findViewById(R.id.btnMostrar);
        btnirAcercaDe = findViewById(R.id.btnAcercaDe);

        btnAgregar.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ElegirTipoTrabajadorActivity.class));
        });

        btnirMostrar.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,MostrarListaActivity.class ));
        });

        btnirAcercaDe.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AcercaDeActivity.class));
        });
    }
}