package com.example.asus.gestion_contact;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

public class Affichage extends AppCompatActivity implements AdapterView.OnItemClickListener,DialogInterface.OnClickListener {

    private SearchView ed_rech_aff;
    private ListView ed_list_aff;
    int ind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        ed_rech_aff = (SearchView) findViewById(R.id.ed_rech_aff);
        ed_list_aff=(ListView) findViewById(R.id.ed_liste_aff);

       // ArrayAdapter ad = new ArrayAdapter(
                //Affichage.this,
               // android.R.layout.simple_list_item_1,
               // Acceuil.data ) ;

        MonAdapter ad = new MonAdapter(Affichage.this,Acceuil.data);
        ed_list_aff.setAdapter(ad);

        ed_list_aff.setAdapter(ad);
        ed_list_aff.setOnItemClickListener(this);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         ind = position;

         AlertDialog.Builder alert = new AlertDialog.Builder(Affichage.this);
        alert.setTitle("Edition");
        alert.setMessage("selectioner une action");
        alert.setPositiveButton("Supprimer",this);
        alert.setNegativeButton("annuler",this);
        alert.setNeutralButton("modifier",this);
        alert.show();
        //alert.setCancelable(false);

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which == AlertDialog.BUTTON_POSITIVE){
            Acceuil.data.remove(ind);
            ed_list_aff.invalidateViews();

        }
        if(which == AlertDialog.BUTTON_NEGATIVE){


        }
        if(which == AlertDialog.BUTTON_NEUTRAL){
            Intent i = new Intent(Affichage.this,Modifier.class);
            i.putExtra("id", ind);
            startActivity(i);
        }

    }
}