package com.example.gou;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InicioSesion extends AppCompatActivity {
    private EditText et_usuario, et_contraseñaIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        et_usuario = (EditText) findViewById(R.id.txt_usuario);
        et_contraseñaIS = (EditText) findViewById(R.id.txt_contraseñaIS);
    }

    public void Ingresar (View view){
        Adminbd administrar = new Adminbd(this, "administracion",null, 1);
        SQLiteDatabase BaseDeDatos = administrar.getWritableDatabase();

        String usuario = et_usuario.getText() .toString();
        String apellido = et_contraseñaIS.getText() .toString();
    }
}
