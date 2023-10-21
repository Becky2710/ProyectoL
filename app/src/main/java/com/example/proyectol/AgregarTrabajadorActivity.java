package com.example.proyectol;
import static com.example.proyectol.MainActivity.lstTrabajadores;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectol.clases.TrabajadorHora;
import com.example.proyectol.clases.TrabajadorTiempoCompleto;
import com.example.proyectol.databinding.ActivityAgregarTrabajadorBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class AgregarTrabajadorActivity extends AppCompatActivity {

    private ActivityAgregarTrabajadorBinding binding;
    private Bundle bundle;
    private int idEleccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAgregarTrabajadorBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setTitle("Agregar Trabajador");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Bar)));
        }

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoEleccion");

        if(idEleccion == 1){
            // Es Trabajador hora
            binding.edtSalarioT.setVisibility(View.GONE);


        }else{
            // Es tiempo completo
            binding.edtValorT.setVisibility(View.GONE);
            binding.edtHoraT.setVisibility(View.GONE);

        }

         binding.btnAgregar.setOnClickListener(v -> {
            if(idEleccion == 1){
                // Es Trabajador hora
                AgregarTrabajadorHora();

            }else{
                // Es tiempo completo
                AgregarTrabajadorTiempoCompleto();

            }

            // Una vez insertado el registro, se puede mostrar una alerta y sacar de la pila a la actvidad
            new AlertDialog.Builder(this).setMessage("Insertado con éxito")
                    .setPositiveButton("Ok", (dialog, which) -> finish()).show();

        });

    }

    private void AgregarTrabajadorTiempoCompleto() {
        if(binding.edtCodigo.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el codigo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtNombre.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtApellido.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el apellido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtEdad.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar la edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtSalario.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el salario", Toast.LENGTH_SHORT).show();
            return;
        }

        lstTrabajadores.add(
                new TrabajadorTiempoCompleto(
                        binding.edtCodigo.getText().toString(),binding.edtNombre.getText().toString(),
                        binding.edtApellido.getText().toString(), Float.valueOf(binding.edtSalario.getText().toString()))
        );
    }

    private void AgregarTrabajadorHora() {
        if(binding.edtCodigo.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el codigo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtNombre.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtApellido.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el apellido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtEdad.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar la edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtValor.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el valor de la hora", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtHora.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar las horas trabajadas", Toast.LENGTH_SHORT).show();
            return;
        }

        lstTrabajadores.add(
                new TrabajadorHora(
                        binding.edtCodigo.getText().toString(), binding.edtNombre.getText().toString(),
                        binding.edtApellido.getText().toString(), Integer.parseInt(binding.edtHora.getText().toString()),
                        Float.valueOf(binding.edtValor.getText().toString()))
        );
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
            finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
