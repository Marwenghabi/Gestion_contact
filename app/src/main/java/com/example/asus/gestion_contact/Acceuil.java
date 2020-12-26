package com.example.asus.gestion_contact;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Acceuil extends AppCompatActivity implements View.OnClickListener {
    private Button btn_ajout_acc;
    private Button btn_aff_acc;
    static ArrayList<Contact> data = new ArrayList<Contact>();
    private TextView tv_user;
    String div= Environment.getExternalStorageDirectory().getPath();
    File f = new File(div,"fichier.txt");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        if(ContextCompat.checkSelfPermission(Acceuil.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Acceuil.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }


        btn_ajout_acc = (Button) findViewById(R.id.btn_ajout_acc);
        btn_aff_acc = (Button) findViewById(R.id.btn_aff_acc);
        tv_user=(TextView) findViewById(R.id.tv_user);

        tv_user.setText((String) getIntent().getSerializableExtra("string"));



        btn_ajout_acc.setOnClickListener(this);
        btn_aff_acc.setOnClickListener(this);
    }

    private void upload() {
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String ligne = null;
            while((ligne = br.readLine())!=null){
                String[]t=ligne.split("#");
                data.add(new Contact(t[0],t[1],t[2]));
            }
            br.close();
            fr.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        if(v==btn_ajout_acc){
            Intent i =new Intent(Acceuil.this,Ajout.class);
            startActivity(i);
        }
        else{
            Intent i =new Intent(Acceuil.this,Affichage.class);
            startActivity(i);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        save();
        super.onDestroy();
    }

    private void save() {
        try{
            FileWriter fw = new FileWriter(f,false);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i =0;i<data.size();i++){
                bw.write(data.get(i).nom+"#"+data.get(i).prenom+"#"+data.get(i).telephone+"\n");
            }
            bw.close();
            fw.close();

        } catch (IOException e) {
            Log.e("msg",e.getMessage());
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==1){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permisson accordée", Toast.LENGTH_LONG).show();
            }else{Toast.makeText(this,"Permisson non accordée",Toast.LENGTH_LONG).show();}

        }
    }





}
