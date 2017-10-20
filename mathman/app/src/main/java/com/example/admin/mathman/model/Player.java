package com.example.admin.mathman.model;

/**
 * Created by esprit on 10/24/2015.
 */
public class Player {
    
    private int id;
    private String type;
    private int score;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player(int id, String type, int score) {
        this.id = id;
        this.type = type;
        this.score = score;
    }
    public Player(){

    }
}
