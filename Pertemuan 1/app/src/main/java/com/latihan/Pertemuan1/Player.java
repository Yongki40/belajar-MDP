package com.latihan.Pertemuan1;

public class Player {
    private String simbol;
    private String name;
    private int score;

    public Player(String simbol, String name) {
        this.simbol = simbol;
        this.name = name;
        this.score = 0;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
