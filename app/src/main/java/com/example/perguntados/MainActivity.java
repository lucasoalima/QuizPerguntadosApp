package com.example.perguntados;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.perguntados.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Modelclass> list;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Question");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Modelclass modelclass = dataSnapshot.getValue(Modelclass.class);
                    list.add(modelclass);
                }
                Intent intent = new Intent(MainActivity.this,DashboardActivity.class);

                intent.putExtra("list",list);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        list.add(new Modelclass("Qual o nome completo do prof. Diego?", "Diego Palma Souza", "Diego Palma Navarro", "Diego Palma Silva"));
//
//        list.add(new Modelclass("O que é o software?", "Conjunto de programas que permite o funcionamento e utilização da máquina." , "Conjunto de programas que permite o funcionamento e utilização do navegador.",
//                "Conjunto de componentes que permitem o acesso à internet."));
//
//        list.add(new Modelclass("São características de um software livre, exceto:",
//                "Possui livre acesso ao código-fonte", "O usuário pode executar o software, para qualquer uso", "Não é permitido redistribuir cópias"));
//
//        list.add(new Modelclass("São sistemas operacionais exceto:", "Windows", "Apple", "Ubuntu"));
//
//        list.add(new Modelclass("Sobre o gabinete do computador, assinale a alternativa incorreta", "Gabinete e CPU são sinônimos", "Também é conhecido como case, caixa, chassis, carcaça ou torre.", "É a “caixa” do computador, onde ficam seus elementos (hardware)."));
//
//        list.add(new Modelclass("O disco rígido, do inglês hard disk, também conhecido como HD, serve como:", "Transporte de dados", "Programa de edição de textos", "Unidade de armanezamento permanente, guardando dados e programas."));
//
//        list.add(new Modelclass("“Random Access Memory” é mais conhecida como:", "Memória ROM", "Memória externa", "Memória RAM"));
//
//        list.add(new Modelclass("USB é abreviação de:", "Universal System Bus", "Universal Serial Bios", "Universal Serial Bus"));
//
//        list.add(new Modelclass("Sobre o pendrive é incorreto afirmar que:", "Ele precisa recarregar energia para manter os dados armazenados.", "É usado através de uma porta USB.", "É constituído por memória flash"));
//
//        list.add(new Modelclass("Qual é o menor número decimal?", "-128", "-127", "-112"));
//
//        list.add(new Modelclass("Como transformar números binários, 10101 por exemplo, para decimal?", "Primeiramente dividimos por 2 os números até chegar no número 1 e pegar os números de baixo para cima", "N.D.A", "Ваѕісаmеntе, о númеrо 1 dо bіt mаіѕ ѕіgnіfісаtіvо tеm а роѕіçãо 4 е fаzеmоѕ 1*2^4 е tаmbém fаzеr nоѕ оutrоѕ númеrоѕ, арóѕ dа multірlісаçãо, ѕоmаmоѕ оѕ númеrоѕ аté сhеgаr о rеѕultаdо"));
//
//        list.add(new Modelclass("Um аlunо еѕtá fаzеndо ѕuа lіçãо dе саѕа, роrém еlе ареnаѕ ѕаbе fаzеr númеrоѕ dесіmаіѕ раrа bіnárіоѕ, Осtаіѕ е Нехаdесіmаіѕ, mаѕ еlе nãо ѕаbе соmо trаnѕfоrmаr о ѕеguіntе númеrо: 1DF2(bаѕе16) раrа númеrо bіnárіо. Соmо роdеmоѕ trаnѕfоrmаr о númеrо Нехаdесіmаl раrа bіnárіо", "O aluno pega cada número e saber como este número é representado em binário e juntar para formar o resultado", "Impossível afirmar", "O aluno precisa pegar os número de 1 até 2 e dividir por 2 para binário"));
//
//        list.add(new Modelclass("Qual é o número maior no decimal com sinal", "127", "129", "257"));
//
//        list.add(new Modelclass("Verdadeira ou Falsa. Em Arquitetura de Computação, O processador tem apenas 1 componente que se chama UC.", "V", "F", "Parcialmente"));
//
//        list.add(new Modelclass("Qual é a função da ULA?", "Fazer apenas operações matemáticas(+,-,/,*)", "Fazer apenas operações lógicas que são: NOT, XOR, AND e OR", "Fazer operações matemáticas(+,-,/,*) e lógicas(NOT, XOR, AND e OR)"));
//
//        list.add(new Modelclass("Em nossa língua 'Se' corresponde a que função em Python?", "If", "Else", "Print"));
//
//        list.add(new Modelclass("A tradução da função 'Print' em português?", "Classe", "Se", "Impressão"));
//
//        list.add(new Modelclass("Qual o significado de 'Class' em português?", "Classe", "Titulo", "Entrada"));
//
//        list.add(new Modelclass("A tradução de 'Verdadeiro' em inglês seria?", "True", "While", "If"));
//
//        list.add(new Modelclass("A tradução de 'Enquanto' em inglês seria ?", "While", "Body", "Class"));
//

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
//                startActivity(intent);
            }
        },1500);
    }
}