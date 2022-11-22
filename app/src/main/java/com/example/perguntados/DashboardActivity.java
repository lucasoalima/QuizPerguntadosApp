package com.example.perguntados;

import static com.example.perguntados.MainActivity.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue = 20;
    ProgressBar progressBar;

    List<Modelclass> allQuestionsList;
    Modelclass modelclass;
    int index = 0;
    TextView card_question, optionA, optionB, optionC;
    CardView cardOA, cardOB, cardOC;
    int corretoCount = 0;
    int erradoCount = 0;
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hooks();

        allQuestionsList=list;
        Collections.shuffle(allQuestionsList);
        modelclass=list.get(index);

        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));


        nextBtn.setClickable(false);


        setAllData();

        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                timerValue = timerValue-1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this, R.style.Dialoge);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);

                dialog.show();

                dialog.findViewById(R.id.btn_tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }.start();
    }

    private void setAllData() {
        card_question.setText(modelclass.getQuestao());
        optionA.setText(modelclass.getOpcaoA());
        optionB.setText(modelclass.getOpcaoB());
        optionC.setText(modelclass.getOpcaoC());


    }

    private void Hooks() {
        progressBar = findViewById(R.id.quiz_timer);
        card_question = findViewById(R.id.card_question);
        optionA = findViewById(R.id.card_option1);
        optionB = findViewById(R.id.card_option2);
        optionC = findViewById(R.id.card_option3);

        cardOA = findViewById(R.id.cardA);
        cardOB = findViewById(R.id.cardB);
        cardOC = findViewById(R.id.cardC);

        nextBtn = findViewById(R.id.nextBtn);
    }



    public void Correto(CardView cardView){

        cardView.setBackgroundColor(getResources().getColor(R.color.green));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corretoCount++;
                index++;
                modelclass=list.get(index);
                setAllData();
            }
        });

    }
    public void Errado(CardView cardOA){

        cardOA.setBackgroundColor(getResources().getColor(R.color.red));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                erradoCount++;
                if(index<list.size()-1){

                    index++;
                    modelclass = list.get(index);
                    setAllData();
                    resetColor();
                }else{
                    GameWon();
                }
            }
        });
        erradoCount++;
    }



    private void GameWon() {
        Intent intent = new Intent(DashboardActivity.this, WonActivity.class);
        intent.putExtra("correto", corretoCount);
        intent.putExtra("errado", erradoCount);
        startActivity(intent);

    }

    public void enableButton(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);

    }
    public void disableButton(){
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);

    }
    public void resetColor(){
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));

    }

    public void OptionAClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelclass.getOpcaoA().equals(modelclass.getResposta())){
            cardOA.setBackgroundColor(getResources().getColor(R.color.green));
            if(index < list.size() -1){
                Correto(cardOA);
            }
            else{
                GameWon();
            }
        }
        else{
            Errado(cardOA);
        }
    }

    public void OptionBClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelclass.getOpcaoB().equals(modelclass.getResposta())){
            cardOB.setBackgroundColor(getResources().getColor(R.color.green));
            if(index < list.size() -1){
               Correto(cardOB);
            }
            else{
                GameWon();
            }
        }
        else{
            Errado(cardOB);
        }
    }

    public void OptionCClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelclass.getOpcaoC().equals(modelclass.getResposta())){
            cardOC.setBackgroundColor(getResources().getColor(R.color.green));
            if(index < list.size() -1){
                Correto(cardOC);
            }
            else{
                GameWon();
            }
        }
        else{
            Errado(cardOC);
        }
    }
}