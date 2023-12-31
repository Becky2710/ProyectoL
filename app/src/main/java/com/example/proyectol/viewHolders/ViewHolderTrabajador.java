package com.example.proyectol.viewHolders;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;


import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectol.R;

public class ViewHolderTrabajador extends RecyclerView.ViewHolder {
    private TextView codigoTrabajador;
    private TextView nombreTrabajador;
    private TextView apellidoTrabajador;
    private TextView tipoTrabajador;
    private TextView salarioTrabajador;

    public ViewHolderTrabajador(@NonNull View itemView){
        super(itemView);
        this.codigoTrabajador = itemView.findViewById(R.id.txvCodigoT);
        this.nombreTrabajador = itemView.findViewById(R.id.txvNombreT);
        this.apellidoTrabajador = itemView.findViewById(R.id.txvApellido);
        this.tipoTrabajador = itemView.findViewById(R.id.txvTipo);
        this.salarioTrabajador = itemView.findViewById(R.id.txvSalario);

    }

    public TextView getCodigoTrabajador() {
        return codigoTrabajador;
    }

    public TextView getNombreTrabajador() {
        return nombreTrabajador;
    }

    public TextView getApellidoTrabajador() {
        return apellidoTrabajador;
    }

    public TextView getTipoTrabajador() {
        return tipoTrabajador;
    }

    public TextView getSalarioTrabajador() {
        return salarioTrabajador;
    }
}
