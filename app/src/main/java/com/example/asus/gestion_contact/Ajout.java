package com.example.asus.gestion_contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ajout extends AppCompatActivity implements View.OnClickListener {
    private Button btnval_aj;
    private Button btnqte_aj;
    private EditText ed_nom_aj;
    private EditText ed_prenom_aj;
    private EditText ed_tel_aj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        btnval_aj = (Button) findViewById(R.id.btn_val_ajout);
        btnqte_aj = (Button) findViewById(R.id.btn_qte_ajout);
        ed_nom_aj=(EditText) findViewById(R.id.ed_nom_ajout);
        ed_prenom_aj=(EditText) findViewById(R.id.ed_prenom_ajout);
        ed_tel_aj=(EditText) findViewById(R.id.ed_tel_ajout);

        btnval_aj.setOnClickListener(this);
        btnqte_aj.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btnqte_aj){
            this.finish();
        }else{
            Contact c = new Contact(ed_nom_aj.getText().toString(),ed_prenom_aj.getText().toString(),ed_tel_aj.getText().toString());
             Acceuil.data.add(c);
            Toast.makeText(this, "Nb Contact ="+Acceuil.data.size(), Toast.LENGTH_LONG).show();

        }
    }
}
