package com.example.prueba01recuperacion;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.prueba01recuperacion.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ScrollView scr_1;
    private Spinner sp_1;

    String [] names = {"Diego","Sebastian", "Victor"};
    int [] edad = {20 , 24, 5 };
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        scr_1=(ScrollView) binding.scr1;
        sp_1=(Spinner) binding.sp1;



        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this.getContext(), R.layout.spinner_mod, names);
        sp_1.setAdapter(adapter);


        return binding.getRoot();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.btnCerezas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Cerezas", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnPlatano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Platano", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnFrambuesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Frambuesas", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnFresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Fresa", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer();
            }
        });

        binding.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = sp_1.getSelectedItem().toString();
                int pos = sp_1.getSelectedItemPosition();

                switch (nombre){
                    case "Diego":
                        Toast.makeText(getActivity(), "El estudiante "+ names[pos]+ " tiene " +edad[pos] +" Años", Toast.LENGTH_SHORT).show();
                        break;
                    case "Sebastian":
                        Toast.makeText(getActivity(), "El estudiante "+ names[pos]+ " tiene " +edad[pos] +" Años", Toast.LENGTH_SHORT).show();
                        break;
                    case "Victor":
                        Toast.makeText(getActivity(), "El estudiante "+ names[pos]+ " tiene " +edad[pos] +" Años", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public void mediaplayer(){

        MediaPlayer mp = MediaPlayer.create(this.getContext(), R.raw.sound_long);
        mp.start();
    }

    /**
     * Función para capturar la imagen seleccionada
     * @param view
     */
    public void selected(View view) {
//        Se recomendia generar una lógica de prgoramación para validar que fruta se selecciono y mostrar en un Toast el Nombre de la fruta seleccionada.
    }

}