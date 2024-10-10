package com.jah.escenario3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SwitchCompat swCambiar;
    Spinner spLista;
    RadioGroup rgContenido;
    RadioButton rbContenido1, rbContenido2, rbContenido3;
    ArrayAdapter<CharSequence> adaptador;
    Integer numeroLista = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        swCambiar = findViewById(R.id.swCambiar);
        spLista = findViewById(R.id.spLista);
        rgContenido = findViewById(R.id.rgContenido);
        rbContenido1 = findViewById(R.id.rbContenido1);
        rbContenido2 = findViewById(R.id.rbContenido2);
        rbContenido3 = findViewById(R.id.rbContenido3);

        adaptador = ArrayAdapter.createFromResource(this, R.array.listaND, android.R.layout.simple_spinner_dropdown_item);
        spLista.setAdapter(adaptador);

        swCambiar.setOnCheckedChangeListener((compoundButton, checkedId) -> cambiarContenido(checkedId));

        spLista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int indice, long l) {
                mostrarContenido(indice, numeroLista);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    private void mostrarContenido(int indice, int numeroLista) {

        if(indice == 0){
            if(numeroLista == 0){
                rbContenido1.setText(R.string.rbContenidoNombres1);
                rbContenido2.setText(R.string.rbContenidoNombres2);
                rbContenido3.setText(R.string.rbContenidoNombres3);

            }else{
                rbContenido1.setText(R.string.rbContenidoCiudades1);
                rbContenido2.setText(R.string.rbContenidoCiudades2);
                rbContenido3.setText(R.string.rbContenidoCiudades3);
            }

        }else{
            if(numeroLista == 0){
                rbContenido1.setText(R.string.rbContenidoDeportes1);
                rbContenido2.setText(R.string.rbContenidoDeportes2);
                rbContenido2.setText(R.string.rbContenidoDeportes3);

            }else{
                rbContenido1.setText(R.string.rbContenidoRios1);
                rbContenido2.setText(R.string.rbContenidoRios2);
                rbContenido2.setText(R.string.rbContenidoRios3);

            }

        }
    }

    private void cambiarContenido(boolean checkedId) {

        if(checkedId){
            adaptador = ArrayAdapter.createFromResource(this, R.array.listaCR, android.R.layout.simple_spinner_dropdown_item);
            numeroLista = 1;
        }else{
            adaptador = ArrayAdapter.createFromResource(this, R.array.listaND, android.R.layout.simple_spinner_dropdown_item);
            numeroLista = 0;
        }
        spLista.setAdapter(adaptador);

    }
}