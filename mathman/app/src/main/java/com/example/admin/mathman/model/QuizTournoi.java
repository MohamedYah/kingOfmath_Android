package com.example.admin.mathman.model;

/**
 * Created by ADMIN on 20/05/2017.
 */

public class QuizTournoi {

    public String id1;
    public String id2;

    public String question;
    public String Anser1;
    public String Anser2;
    public String Anser3;
    public String Anser4;

    public String CorrectAnser;

    public String next1;
    public  String next2;

    public String scoreplayer1;
    public String scoreplayer2;




    public QuizTournoi() {
    }


    public QuizTournoi(String id1, String id2, String question, String anser1, String anser2, String anser3, String anser4, String correctAnser, String next1, String next2, String scoreplayer1, String scoreplayer2) {
        this.id1 = id1;
        this.id2 = id2;
        this.question = question;
        Anser1 = anser1;
        Anser2 = anser2;
        Anser3 = anser3;
        Anser4 = anser4;
        CorrectAnser = correctAnser;
        this.next1 = next1;
        this.next2 = next2;
        this.scoreplayer1 = scoreplayer1;
        this.scoreplayer2 = scoreplayer2;
    }
}
