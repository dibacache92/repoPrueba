package com.example.altera01.holausuario;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SaludoActivity extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtApellido;
    private TextView txtEdad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        txtNombre = (TextView)findViewById(R.id.txtNombre);
        txtApellido = (TextView)findViewById(R.id.txtApellido);
        txtEdad =  (TextView)findViewById(R.id.txtEdad);
        Bundle b = this.getIntent().getExtras();


        txtNombre.setText(b.getString("NOMBRE"));
        txtApellido.setText(b.getString("APELLIDO"));
        txtEdad.setText(String.valueOf(b.getInt("EDAD")));

    }

}
