package com.example.perguntados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.BuildConfig;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.text.MessageFormat;

public class WonActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView resultText;
    int correto, errado;
    LinearLayout btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        correto = getIntent().getIntExtra("correto", 0);
        errado = getIntent().getIntExtra("errado", 0);


        resultText = findViewById(R.id.resultText);
        circularProgressBar=findViewById(R.id.circularProgressBar);
        btnShare = findViewById(R.id.btnShare);

        circularProgressBar.setProgress(correto);
        resultText.setText(correto+"/20");

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nEu pontuei " + correto + "de 20, tente você também";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

    }
}