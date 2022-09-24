package com.example.projetidap7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailProduit extends AppCompatActivity {

    EditText nom,quantite,prix,famille;
    Button modif, sup;
    String id;
    BDhelper bDhelper = new BDhelper(DetailProduit.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produit);

        nom =(EditText)findViewById(R.id.detailNom);
        quantite =(EditText)findViewById(R.id.detailQ);
        prix =(EditText)findViewById(R.id.detailPrix);
        famille =(EditText)findViewById(R.id.detailF);
        modif =(Button)findViewById(R.id.modif);
        sup =(Button)findViewById(R.id.sup);

        id =getIntent().getStringExtra("id");
        Modele m = bDhelper.getOneData(Integer.parseInt(id));
        nom.setText(m.getNom());
        quantite.setText(m.getQuantite());
        prix.setText(String.valueOf(m.getPrix()));
        famille.setText(m.getFamille());
        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Modele modele = new Modele(Integer.parseInt(id),nom.getText().toString(),
                        quantite.getText().toString(),
                        Double.parseDouble(prix.getText().toString()),famille.getText().toString());
                bDhelper.updateData(modele);
                Intent intent = new Intent(DetailProduit.this,ProdList.class);
                startActivity(intent);
            }
        });
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bDhelper.deleteData(Integer.parseInt(id));
                Intent intent = new Intent(DetailProduit.this,ProdList.class);
                startActivity(intent);
            }
        });

    }
}