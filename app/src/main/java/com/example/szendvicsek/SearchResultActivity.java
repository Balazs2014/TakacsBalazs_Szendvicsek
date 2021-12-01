package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {
    private Button searchResult_btnVissza;
    private TextView searchResult_txtViewSzendvicsek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        init();

        Bundle szendvicsek = getIntent().getExtras();
        if (szendvicsek != null) {
            String szendvics = szendvicsek.getString("szendvicsKulcs");
            searchResult_txtViewSzendvicsek.setText(szendvics);
        }

        searchResult_btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(SearchResultActivity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
    }

    private void init() {
        searchResult_btnVissza = findViewById(R.id.searchResult_btnVissza);
        searchResult_txtViewSzendvicsek = findViewById(R.id.searchResult_txtViewSzendvicsek);
    }
}