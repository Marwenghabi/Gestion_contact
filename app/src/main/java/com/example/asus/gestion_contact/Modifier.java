package com.example.asus.gestion_contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modifier extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_tel_mod;
    private EditText ed_prenom_mod;
    private EditText ed_nom_mod;
    private Button btnqte_mod;
    private Button btnmodf_mod;
    int ind;
    public Contact s;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);

        //ind = (int) getIntent().getExtras().getInt("id");



        //s=Acceuil.data.get(ind);



        btnmodf_mod = (Button) findViewById(R.id.btn_modf_mod);
        btnqte_mod = (Button) findViewById(R.id.btn_qte_mod);
        ed_nom_mod=(EditText) findViewById(R.id.ed_nom_mod);
        ed_prenom_mod=(EditText) findViewById(R.id.ed_prenom_mod);
        ed_tel_mod=(EditText) findViewById(R.id.ed_tel_mod);

        ed_nom_mod.setText("maro");
        ed_tel_mod.setText("54555");
        ed_prenom_mod.setText("ghabi");

        btnmodf_mod.setOnClickListener(this);
        btnqte_mod.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        if(v == btnqte_mod){
            this.finish();
        }else{


        }

    }
}
