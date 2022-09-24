package com.example.projetidap7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BDhelper extends SQLiteOpenHelper {
    private final Context context;

    public BDhelper(@Nullable Context context) {
        super(context, "Khelcomscs.db" , null, 3);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE produits(_id INTEGER PRIMARY KEY  AUTOINCREMENT, nom TEXT, quantite TEXT,prix REAL,famille TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS produits");
        onCreate(sqLiteDatabase);
    }
    public void insertProduct(Modele m)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nom",m.getNom());
        cv.put("quantite",m.getQuantite());
        cv.put("prix",m.getPrix());
        cv.put("famille",m.getFamille());
        long resultat = sqLiteDatabase.insert("produits",null,cv);

        if (resultat <= 0)
        {
            Toast.makeText(context, "Echec de l'insertion!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context, "Insertion avec success!", Toast.LENGTH_LONG).show();
        }
        sqLiteDatabase.close();

    }


    public void updateData(Modele m)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();
        cv.put("nom",m.getNom());
        cv.put("quantite",m.getQuantite());
        cv.put("prix",m.getPrix());
        cv.put("famille",m.getFamille());
       long resultat =   sqLiteDatabase.update("produits",cv,"_id=?",new String[]{String.valueOf(m.getId())});

        if (resultat <= 0)
        {
            Toast.makeText(context, "Echec de mise à jour ! ",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context, "mise à jour avec success ! ",Toast.LENGTH_LONG).show();
        }

        sqLiteDatabase.close();
    }
    public void deleteData(int id)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
       long resultat = sqLiteDatabase.delete("produits","_id=?",new String[]{String.valueOf(id)});

        if (resultat <= 0)
        {
            Toast.makeText(context, "Echec de suppression ! ",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context, "suppression avec success ! ",Toast.LENGTH_LONG).show();
        }
        sqLiteDatabase.close();
    }
    public Cursor getAllData()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM produits",null);
        return c;
    }
    public Modele getOneData(int id)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.query("produits",new String[]{"_id","nom","quantite","prix","famille"},"_id=?",new String[]{String.valueOf(id)},null, null, null);
        c.moveToFirst();
        Modele m  = new Modele(c.getInt(0),c.getString(1),c.getString(2),c.getDouble(3),c.getString(4));
      return m;
    }
}
