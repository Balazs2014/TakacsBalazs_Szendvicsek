package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    private EditText insert_editTxtNev, insert_editTxtLeiras, insert_editTxtElkeszites, insert_editTxtAr;
    private Button insert_btnFelvetel, insert_btnVissza;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        init();
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