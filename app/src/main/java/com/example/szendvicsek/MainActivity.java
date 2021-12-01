package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button main_btnKereses, main_btnUj;
    private EditText main_editTxtAr;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        main_btnUj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ujFelvetele = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(ujFelvetele);
                finish();
            }
        });

        main_btnKereses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ertek = main_editTxtAr.getText().toString().trim();
                if (!ertek.isEmpty()) {
                    try {
                        Cursor adat = db.kereses(ertek);
                        StringBuilder sb = new StringBuilder();
                        if (adat.getCount() == 0) {
                            while (adat.moveToNext()) {
                                sb.append("Név: ").append(adat.getString(1));
                                sb.append(System.lineSeparator());
                                sb.append("Leiras: ").append(adat.getString(2));
                                sb.append(System.lineSeparator());
                                sb.append("Elkészítés: ").append(adat.getInt(3));
                                sb.append(System.lineSeparator());
                                sb.append("Ár: ").append(adat.getInt(4));
                                sb.append(System.lineSeparator());
                                sb.append(System.lineSeparator());
                            }
                        } else {
                            sb.append("Nincs ilyen olcsó szendvics: ").append(ertek);
                        }
                        Intent kereses = new Intent(MainActivity.this, SearchResultActivity.class);
                        String szendvics = sb.toString();
                        kereses.putExtra("szendvicsKulcs", szendvics);
                        startActivity(kereses);
                        finish();
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Számot adjon meg",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void init() {
        main_btnKereses = findViewById(R.id.main_btnKereses);
        main_btnUj = findViewById(R.id.main_btnUj);
        main_editTxtAr = findViewById(R.id.main_editTxtAr);
        db = new DBHelper(this);
    }
}