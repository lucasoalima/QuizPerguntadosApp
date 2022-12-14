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
//        list.add(new Modelclass("O que ?? o software?", "Conjunto de programas que permite o funcionamento e utiliza????o da m??quina." , "Conjunto de programas que permite o funcionamento e utiliza????o do navegador.",
//                "Conjunto de componentes que permitem o acesso ?? internet."));
//
//        list.add(new Modelclass("S??o caracter??sticas de um software livre, exceto:",
//                "Possui livre acesso ao c??digo-fonte", "O usu??rio pode executar o software, para qualquer uso", "N??o ?? permitido redistribuir c??pias"));
//
//        list.add(new Modelclass("S??o sistemas operacionais exceto:", "Windows", "Apple", "Ubuntu"));
//
//        list.add(new Modelclass("Sobre o gabinete do computador, assinale a alternativa incorreta", "Gabinete e CPU s??o sin??nimos", "Tamb??m ?? conhecido como case, caixa, chassis, carca??a ou torre.", "?? a ???caixa??? do computador, onde ficam seus elementos (hardware)."));
//
//        list.add(new Modelclass("O disco r??gido, do ingl??s hard disk, tamb??m conhecido como HD, serve como:", "Transporte de dados", "Programa de edi????o de textos", "Unidade de armanezamento permanente, guardando dados e programas."));
//
//        list.add(new Modelclass("???Random Access Memory??? ?? mais conhecida como:", "Mem??ria ROM", "Mem??ria externa", "Mem??ria RAM"));
//
//        list.add(new Modelclass("USB ?? abrevia????o de:", "Universal System Bus", "Universal Serial Bios", "Universal Serial Bus"));
//
//        list.add(new Modelclass("Sobre o pendrive ?? incorreto afirmar que:", "Ele precisa recarregar energia para manter os dados armazenados.", "?? usado atrav??s de uma porta USB.", "?? constitu??do por mem??ria flash"));
//
//        list.add(new Modelclass("Qual ?? o menor n??mero decimal?", "-128", "-127", "-112"));
//
//        list.add(new Modelclass("Como transformar n??meros bin??rios, 10101 por exemplo, para decimal?", "Primeiramente dividimos por 2 os n??meros at?? chegar no n??mero 1 e pegar os n??meros de baixo para cima", "N.D.A", "????????????m??nt??, ?? n??m??r?? 1 d?? b??t m?????? ????gn??f??????t??v?? t??m ?? ?????????????? 4 ?? f??z??m???? 1*2^4 ?? t??mb??m f??z??r n???? ??utr???? n??m??r????, ???????? d?? mult????l????????????, ????m??m???? ???? n??m??r???? ??t?? ??h??g??r ?? r????ult??d??"));
//
//        list.add(new Modelclass("Um ??lun?? ????t?? f??z??nd?? ??u?? l???????? d?? ????????, ????r??m ??l?? ??????n???? ????b?? f??z??r n??m??r???? d??????m?????? ????r?? b??n??r??????, ????t?????? ?? ????????d??????m??????, m???? ??l?? n???? ????b?? ????m?? tr??n??f??rm??r ?? ????gu??nt?? n??m??r??: 1DF2(b??????16) ????r?? n??m??r?? b??n??r????. ????m?? ????d??m???? tr??n??f??rm??r ?? n??m??r?? ????????d??????m??l ????r?? b??n??r????", "O aluno pega cada n??mero e saber como este n??mero ?? representado em bin??rio e juntar para formar o resultado", "Imposs??vel afirmar", "O aluno precisa pegar os n??mero de 1 at?? 2 e dividir por 2 para bin??rio"));
//
//        list.add(new Modelclass("Qual ?? o n??mero maior no decimal com sinal", "127", "129", "257"));
//
//        list.add(new Modelclass("Verdadeira ou Falsa. Em Arquitetura de Computa????o, O processador tem apenas 1 componente que se chama UC.", "V", "F", "Parcialmente"));
//
//        list.add(new Modelclass("Qual ?? a fun????o da ULA?", "Fazer apenas opera????es matem??ticas(+,-,/,*)", "Fazer apenas opera????es l??gicas que s??o: NOT, XOR, AND e OR", "Fazer opera????es matem??ticas(+,-,/,*) e l??gicas(NOT, XOR, AND e OR)"));
//
//        list.add(new Modelclass("Em nossa l??ngua 'Se' corresponde a que fun????o em Python?", "If", "Else", "Print"));
//
//        list.add(new Modelclass("A tradu????o da fun????o 'Print' em portugu??s?", "Classe", "Se", "Impress??o"));
//
//        list.add(new Modelclass("Qual o significado de 'Class' em portugu??s?", "Classe", "Titulo", "Entrada"));
//
//        list.add(new Modelclass("A tradu????o de 'Verdadeiro' em ingl??s seria?", "True", "While", "If"));
//
//        list.add(new Modelclass("A tradu????o de 'Enquanto' em ingl??s seria ?", "While", "Body", "Class"));
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