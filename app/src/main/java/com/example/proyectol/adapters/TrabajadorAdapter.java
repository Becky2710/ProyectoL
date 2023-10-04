package com.example.proyectol.adapters;
import static com.example.proyectol.MainActivity.lstTrabajadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectol.R;
import com.example.proyectol.clases.Trabajador;
import com.example.proyectol.viewHolders.ViewHolderTrabajador;

import java.util.ArrayList;

public class TrabajadorAdapter extends RecyclerView.Adapter<ViewHolderTrabajador> {
    private ArrayList<Trabajador> datos;

    public TrabajadorAdapter(ArrayList<Trabajador> datos){
        this.datos = datos;
    }
    @NonNull
    @Override
    public ViewHolderTrabajador onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trabajador, parent, false);
        return new ViewHolderTrabajador(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderTrabajador holder, int position){
        holder.getCodigoTrabajador().setText(datos.get(position).getCodigoPersona());
        holder.getNombreTrabajador().setText(datos.get(position).getNombrePersona());
        holder.getApellidoTrabajador().setText(datos.get(position).getApellidoPersona());
        if(datos.get(position).getTipoTrabajador() == 1){
            holder.getTipoTrabajador().setText("TH");
        }else{
            holder.getTipoTrabajador().setText("TH");
        }
        holder.getSalarioTrabajador().setText(String.valueOf(datos.get(position).getTotalPagar()));
    }
    @Override
    public int getItemCount(){
        return lstTrabajadores.size();
    }
}
