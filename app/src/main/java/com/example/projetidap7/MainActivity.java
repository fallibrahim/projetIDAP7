package com.example.projetidap7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nom, quantite, prix, famille;
    Button idBouton;
    BDhelper bDhelper = new BDhelper(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom =(EditText)findViewById(R.id.idNomP);
        quantite =(EditText)findViewById(R.id.idQuantiteP);
        prix =(EditText)findViewById(R.id.idPrixP);
        famille =(EditText)findViewById(R.id.idfamilleP);
        idBouton =findViewById(R.id.idBouton);
        idBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Modele m = new Modele(nom.getText().toString(),quantite.getText().toString(),Double.parseDouble(prix.getText().toString()),famille.getText().toString());
                bDhelper.insertProduct(m);
                Intent intent = new Intent(MainActivity.this,ProdList.class);
                startActivity(intent);
            }
        });
    }
}