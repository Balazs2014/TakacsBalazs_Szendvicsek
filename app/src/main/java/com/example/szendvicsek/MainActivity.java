package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    }

    private void init() {
        main_btnKereses = findViewById(R.id.main_btnKereses);
        main_btnUj = findViewById(R.id.main_btnUj);
        main_editTxtAr = findViewById(R.id.main_editTxtAr);
        db = new DBHelper(this);
    }
}