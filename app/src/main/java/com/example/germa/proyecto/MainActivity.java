package com.example.germa.proyecto;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonRequest;
import com.example.germa.proyecto.OpenHelper.DBHelper;

import org.json.JSONArray;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {
    EditText etUsuario, etContraseña;
    Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DBHelper BD = new DBHelper(this);
        SQLiteDatabase BASE_DATOS = BD.getWritableDatabase();

        btnInicio = (Button) findViewById(R.id.btn_iniciar);

        btnInicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentReg= new Intent(MainActivity.this, Menu_Principal.class);
                       MainActivity.this.startActivity(intentReg);
                   }
        });
    }

}