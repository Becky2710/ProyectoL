package com.example.proyectol;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import com.example.proyectol.clases.Trabajador;
import com.example.proyectol.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public static ArrayList<Trabajador> lstTrabajadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setTitle("Menu");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Bar)));
        }
        lstTrabajadores = new ArrayList<Trabajador>();


        binding.btnAgregar.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ElegirTipoTrabajadorActivity.class));
        });

        binding.btnMostrar.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,MostrarListaActivity.class ));
        });

        binding.btnAcercaDe.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AcercaDeActivity.class));
        });
    }
}