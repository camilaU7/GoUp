package com.example.gou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    //metodo de los botones
    public void Inicio (View view) {
        Intent inicio = new Intent(this, InicioSesion.class);
        startActivity(inicio);

    }
    public void RegistroU (View vie){
        Intent registroU = new Intent(this, Registro.class);
        startActivity(registroU);
    }
}
