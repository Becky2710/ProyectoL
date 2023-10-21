package com.example.proyectol;
import static com.example.proyectol.MainActivity.lstTrabajadores;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectol.adapters.TrabajadorAdapter;
import com.example.proyectol.databinding.ActivityMostrarListaBinding;


public class MostrarListaActivity extends AppCompatActivity {
   private ActivityMostrarListaBinding binding;
    private TrabajadorAdapter trabajadorAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMostrarListaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setTitle("Lista Trabajadores");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Bar)));
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Toast.makeText(this, "DATOS: " + lstTrabajadores,
                Toast.LENGTH_SHORT).show();
        // Configurando adaptador
        trabajadorAdapter = new TrabajadorAdapter(lstTrabajadores);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.rcvTrabajadores);
        recyclerView.setAdapter(trabajadorAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

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