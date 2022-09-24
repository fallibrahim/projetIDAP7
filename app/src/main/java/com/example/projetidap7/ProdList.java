package com.example.projetidap7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProdList extends AppCompatActivity {
    ListView listView;
    Button btn_ajout;
    BDhelper bDhelper = new BDhelper(ProdList.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_list);
        listView =(ListView)findViewById(R.id.prodList);
        btn_ajout =(Button)findViewById(R.id.btn_ajout);
        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProdList.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Cursor cursor = bDhelper.getAllData();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayListId = new ArrayList<>();
      if(cursor.getCount() > 0)
      {
          while(cursor.moveToNext())
          {
            arrayList.add(cursor.getString(1));
            arrayListId.add(String.valueOf(cursor.getString(0)));
          }
      }
      else{
          Toast.makeText(ProdList.this,"liste produit vide",Toast.LENGTH_LONG).show();
      }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
      listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentAct = new Intent(ProdList.this,DetailProduit.class);
                intentAct.putExtra("id", arrayListId.get(i));
                startActivity(intentAct);
            }
        });

    }
}