package com.example.perguntados;

import java.io.Serializable;

public class Modelclass implements Serializable {

    String Questao;
    String opcaoA;
    String opcaoB;
    String opcaoC;
    String resposta;

    public Modelclass(){

    }

    public Modelclass(String questao, String opcaoA, String opcaoB, String opcaoC, String resposta){
        Questao = questao;
        this.opcaoA = opcaoA;
        this.opcaoB = opcaoB;
        this.opcaoC = opcaoC;
        this.resposta = resposta;
    }
    public String getQuestao(){
        return Questao;
    }
    public void setQuestao(String questao){
        Questao = questao;
    }
    public String getOpcaoA(){
        return opcaoA;
    }
    public String getOpcaoB(){
        return opcaoB;
    }
    public String getOpcaoC(){
        return opcaoC;
    }
    public String getResposta(){
        return resposta;
    }
}
