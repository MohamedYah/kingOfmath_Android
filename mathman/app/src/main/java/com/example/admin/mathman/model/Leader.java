package com.example.admin.mathman.model;

/**
 * Created by ADMIN on 02/01/2016.
 */
public class Leader {

    public String name;
    public String score;
    int Rang;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getRang() {
        return Rang;
    }

    public void setRang(int rang) {
        Rang = rang;
    }

    public Leader(String name, String score, int rang) {
        this.name = name;
        this.score = score;
        Rang = rang;
    }
}
