package com.example.perguntados;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomAdapter(generateData()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private List<String> generateData() {
        List<String> data = new ArrayList<>();
            data.add(String.valueOf(1) + "Lucas Soares de Lima");
            data.add(String.valueOf(2) + "Bruno Miguel Groth");
            data.add(String.valueOf(3) + "Mayara Fernandes");
            data.add(String.valueOf(4) + "Rodrigo Azevedo");
            data.add(String.valueOf(4) + "Gabriel Skalecki Cardon");

        return data;
    }

}
