package com.example.admin.mathman.model;

/**
 * Created by ADMIN on 15/05/2017.
 */

public class Registre {

String login;
String password;
String birthday;
String school;
String hero;
int score;

    String totalscore;
String adventure1,adventure2,adventure3,adventure4,adventure5,adventure6,adventure7,adventure8,adventure9,adventure10;
String adventure11,adventure12,adventure13,adventure14,adventure15,adventure16,adventure17,adventure18,adventure19,adventure20;
String adventure21,adventure22,adventure23,adventure24,adventure25,adventure26,adventure27,adventure28,adventure29,adventure30;
String adventure31,adventure32,adventure33,adventure34,adventure35,adventure36,adventure37,adventure38;
    String quiz1,quiz2,quiz3,quiz4,quiz5,quiz6;


    public Registre() {

    }


    public Registre(String login, String password, String birthday, String school, String hero, int score) {
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.school = school;
        this.hero = hero;
        this.score = score;
    }
}
