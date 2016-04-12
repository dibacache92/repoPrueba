package com.example.altera01.holausuario;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private Button btnAceptar;
    private EditText txtApellido;
    private EditText txtEdad;
    private TextView lblError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        btnAceptar = (Button)findViewById(R.id.btnAceptar);
        txtApellido = (EditText)findViewById(R.id.txtApellido);
        txtEdad = (EditText)findViewById(R.id.txtEdad);
        lblError = (TextView)findViewById(R.id.lblError);
/*
        btnAceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,SaludoActivity.class);

                Bundle b = new Bundle();
                b.putString("NOMBRE",txtNombre.getText().toString());

                intent.putExtras(b);

                startActivity(intent);
            }

        });*/

    }

    public void aceptarBoton(View view) {
        Intent intent = new Intent(MainActivity.this,SaludoActivity.class);
        Bundle b = new Bundle();
        lblError.setText("");

        if(txtNombre.getText().toString().length()==0){
            lblError.setText("Nombre obligatorio");
            return;
        }else if(txtApellido.getText().toString().length()==0){
            lblError.setText("Apellido obligatorio");
            return;
        }else if(txtEdad.getText().toString().length()==0){
            lblError.setText("Favor ingrese edad valida");
            return;
        } else {
            b.putString("NOMBRE", txtNombre.getText().toString());
            b.putString("APELLIDO", txtApellido.getText().toString());
            b.putInt("EDAD", Integer.parseInt(txtEdad.getText().toString()));
            intent.putExtras(b);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
