package com.example.loginsesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String usuario = "juan";
    public static final String contraseña = "pablo123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean validateCredentials(String pusuario, String pcontraseña) {

        if (pusuario.equals (usuario) && pcontraseña.equals(contraseña)){
            return true;
        } else {
            return false;
        }
    }

    public void transfer(){
        Intent intent = new Intent(this, sesionSuccess.class);
        startActivity(intent);
    }

    public void signIn(View v){
        EditText valUser = (EditText)findViewById(R.id.inpUser);
        EditText valPass = (EditText)findViewById(R.id.inpPass);

        String valUserStr = valUser.getText().toString();
        String valPassStr = valPass.getText().toString();
        boolean valSuccess1 = validateCredentials(valUserStr+"", valPassStr+"");
        System.out.println(valSuccess1);

        if (valSuccess1 == true) {
            transfer();
        } else {
            Toast.makeText(this, "Error: These credentials do not match our records", Toast.LENGTH_LONG).show();
        }
    }
}