package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class InsertActivity extends AppCompatActivity {
    private EditText insert_editTxtNev, insert_editTxtLeiras, insert_editTxtElkeszites, insert_editTxtAr;
    private Button insert_btnFelvetel, insert_btnVissza;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        init();

        insert_btnFelvetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nev = insert_editTxtNev.getText().toString().trim();
                String leiras = insert_editTxtLeiras.getText().toString().trim();
                String elkeszites = insert_editTxtElkeszites.getText().toString().trim();
                String ar = insert_editTxtAr.getText().toString().trim();
                if (nev.isEmpty() || elkeszites.isEmpty() || ar.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Név, elkészítés, és az ár mező kitöltése kötelező",
                            Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int arInt = Integer.parseInt(ar);
                        int elkeszitesInt = Integer.parseInt(elkeszites);
                        if (arInt <= 0 || elkeszitesInt <= 0) {
                            Toast.makeText(getApplicationContext(),
                                    "Az elkészítés ideje és az ár nem lehet 0 vagy negatív szám",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            if (db.ujFelvetel(nev, leiras, elkeszitesInt, arInt)){
                                Toast.makeText(getApplicationContext(), "Sikeres felvétel",
                                        Toast.LENGTH_SHORT).show();
                            } else{
                                Toast.makeText(getApplicationContext(), "Sikeretelen felvétel",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(),
                                "Az elkészítésnek és az árnak számnak kell lennie",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        insert_btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
    }

    private void init() {
        insert_editTxtNev = findViewById(R.id.insert_editTxtNev);
        insert_editTxtLeiras = findViewById(R.id.insert_editTxtLeiras);
        insert_editTxtElkeszites = findViewById(R.id.insert_editTxtElkeszites);
        insert_editTxtAr = findViewById(R.id.insert_editTxtAr);
        insert_btnFelvetel = findViewById(R.id.insert_btnFelvetel);
        insert_btnVissza = findViewById(R.id.insert_btnVissza);
        db = new DBHelper(this);
    }
}