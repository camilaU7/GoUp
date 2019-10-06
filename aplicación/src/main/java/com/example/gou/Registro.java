package com.example.gou;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et_nombre, et_apellido, et_cedula, et_nacimi, et_celular, et_correo, et_contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //spinner//
        spinner1 = (Spinner)findViewById(R.id.spinner);

        String[] opciones ={"Tipo de documento","Cedula","Tarjeta de identidad","cedula extranjera"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);

        //cajas de texto//
        et_nombre = (EditText) findViewById(R.id.txt_nombre);
        et_apellido = (EditText) findViewById(R.id.txt_apellido);
        et_cedula = (EditText) findViewById(R.id.txt_cedula);
        et_nacimi = (EditText) findViewById(R.id.efecha);
        et_celular = (EditText) findViewById(R.id.txt_celular);
        et_correo = (EditText) findViewById(R.id.txt_correo);
        et_contraseña = (EditText) findViewById(R.id.txt_contraseña);
    }
    public void Guardar (View view){
        Adminbd administrar = new Adminbd(this, "administracion",null, 1);
        SQLiteDatabase BaseDeDatos = administrar.getWritableDatabase();

        String nombre = et_nombre.getText() .toString();
        String apellido = et_apellido.getText() .toString();
        String cedula = et_cedula.getText() .toString();
        String fec_nacimi = et_nacimi.getText() .toString();
        String celular = et_celular.getText() .toString();
        String correo = et_correo.getText() .toString();
        String contraseña = et_contraseña.getText() .toString();

        if (!nombre.isEmpty() && !apellido.isEmpty() && !cedula.isEmpty() && !fec_nacimi.isEmpty() && !celular.isEmpty() && !correo.isEmpty()) {

            ContentValues registro = new ContentValues();
            registro.put("nombres", nombre);

        } else{
            Toast.makeText(this, "Todos los campos son obligatorio", Toast.LENGTH_SHORT) .show();

        }

        //validacion correo
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        String email = correo;

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            Toast.makeText(this, "Todos los campos son obligatorio", Toast.LENGTH_LONG) .show();
        } else {
            Toast.makeText(this, "El correo es invalido", Toast.LENGTH_LONG) .show();
        }

    }
}
