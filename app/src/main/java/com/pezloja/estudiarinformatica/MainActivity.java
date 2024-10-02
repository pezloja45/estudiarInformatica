package com.pezloja.estudiarinformatica;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner sp_ciclo, sp_tipo, sp_poblacion;
    TextView str_resultado;
    Button btn_borrar;
    String ciclo, tipo, poblacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    sp_ciclo = findViewById(R.id.sp_ciclo);
    sp_poblacion = findViewById(R.id.sp_poblacion);
    sp_tipo = findViewById(R.id.sp_tipo);
    str_resultado = findViewById(R.id.str_resultado);
    btn_borrar = findViewById(R.id.btn_borrar);
    ciclo = "";
    tipo = "";
    poblacion = "";


        // Cargar los valores desde el string-array definido en resources
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sp_ciclo, android.R.layout.simple_spinner_item);
        // Especifica el layout que se utilizará cuando se desplieguen las opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Asigna el adaptador al Spinner
        sp_ciclo.setAdapter(adapter);// Cargar los valores desde el string-array definido en resources

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.sp_poblacion, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_poblacion.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.sp_tipo, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tipo.setAdapter(adapter3);



    sp_ciclo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            ciclo = sp_ciclo.getSelectedItem().toString();
            actualizarResultado();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });

        sp_poblacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                poblacion = sp_poblacion.getSelectedItem().toString();
                actualizarResultado();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tipo = sp_tipo.getSelectedItem().toString();
                actualizarResultado();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp_ciclo.setSelection(0);
                sp_poblacion.setSelection(0);
                sp_tipo.setSelection(0);
            }
        });

    }

    private void actualizarResultado() {
        str_resultado.setText(ciclo + " en " + poblacion + " de forma " + tipo);
    }

}