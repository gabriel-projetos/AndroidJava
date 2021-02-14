package com.example.app.model;

public class QuestionarioPergunta {
    public int CodigoPergunta;
    public String Pergunta;
    public String Resposta;
    public String QuestionImage;

    @Override
    public String toString() {
        return "QuestionarioPergunta{" +
                "CodigoPergunta=" + CodigoPergunta +
                ", Pergunta='" + Pergunta + '\'' +
                ", Resposta='" + Resposta + '\'' +
                ", QuestionImage='" + QuestionImage + '\'' +
                '}';
    }
}
