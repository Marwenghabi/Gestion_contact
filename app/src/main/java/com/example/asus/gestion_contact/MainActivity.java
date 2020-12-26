package com.example.asus.gestion_contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //déclaration
    private Button btnval_auth;
    private Button btnqte_auth;
    private EditText ed_nom_auth;
    private EditText ed_mp_auth;
    public String var;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//récupération des cpts
        btnval_auth = (Button) findViewById(R.id.btnval_auth);
        btnqte_auth = (Button) findViewById(R.id.btnqte_auth);
        ed_nom_auth=(EditText) findViewById(R.id.ed_nom_auth);
        ed_mp_auth=(EditText) findViewById(R.id.ed_mp_auth);
//ecouteur des évens
        btnval_auth.setOnClickListener(this);
        btnqte_auth.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==btnqte_auth) {
            this.finish(); }
        else{
            Toast.makeText(this, ed_nom_auth.getText().toString()+ed_mp_auth.getText().toString(), Toast.LENGTH_LONG).show();
            Intent i =new Intent(MainActivity.this,Acceuil.class);
            var = ed_nom_auth.getText().toString();

            i.putExtra("variable",var );
            startActivity(i);
        }

    }
}
        //méthode 2 :
       // Button btnval_auth = (Button) findViewById(R.id.btnval_auth);
       // btnval_auth.setOnClickListener(new View.OnClickListener() {
          //  @Override
          //  public void onClick(View v) {
              //  MainActivity.this.finish();

          //  }


       // });

        //méthode 1 :
        //public void quitter(View v){
        //    this.finish(); }




