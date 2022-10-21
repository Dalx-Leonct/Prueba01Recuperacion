package com.example.prueba01recuperacion;

import android.content.Intent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba01recuperacion.databinding.FragmentThirdBinding;


public class thirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    private EditText txt_code, txt_descripcion;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);


        txt_code = (EditText) binding.buttonCodigo;
        txt_descripcion = (EditText) binding.buttonDescripcion;


        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(thirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_SecondFragment);
            }
        });

        binding.buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registrar();

            }
        });

        binding.buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                delete();

            }
        });

    }

    public void registrar() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this.getActivity(), "administration", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        String codigo = txt_code.getText().toString();
        String descripcion = txt_descripcion.getText().toString();


        if (!codigo.isEmpty() && !descripcion.isEmpty()) {
            ContentValues register = new ContentValues();
            register.put("codigo", codigo);
            register.put("descripcion", descripcion);
            database.insert("producto", null, register);
            database.close();
            limpiarCampos();
            Toast.makeText(this.getActivity(), "Registro exitoso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.getActivity(), "Completar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }


    public void delete() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this.getActivity(), "administration", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();
        admin.getWritableDatabase();
        String codigo = txt_code.getText().toString();
        if (!codigo.isEmpty()) {
            int count = database.delete("producto", "codigo=" + codigo, null);
            if (count == 1) {
                database.close();
                limpiarCampos();
                Toast.makeText(this.getActivity(), "Eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this.getActivity(), "El producto no existe", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this.getActivity(), "Ingresar código", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarCampos() {
        txt_code.setText("");
        txt_descripcion.setText("");
    }


}