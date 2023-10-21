package com.example.proyectol;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectol.databinding.ActivityElegirTipoTrabajadorBinding;

public class ElegirTipoTrabajadorActivity extends AppCompatActivity {
    private ActivityElegirTipoTrabajadorBinding binding;
    private Bundle bundle;
    private int idEleccion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityElegirTipoTrabajadorBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setTitle("Tipo Trabajador");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Bar)));
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        binding.RbTHora.setOnClickListener(v -> idEleccion = 1); // En caso de que el usuario elija Trabajador por hora
        binding.RbTTC.setOnClickListener(v -> idEleccion = 2); // En caso de que el usuario elija Trabajador tiempo completo

        binding.btnSiguiente.setOnClickListener(v -> {
            bundle = new Bundle();
            bundle.putInt("tipoEleccion", idEleccion);
            Intent intent = new Intent(this, AgregarTrabajadorActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
