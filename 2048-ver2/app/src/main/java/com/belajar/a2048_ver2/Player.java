package com.belajar.a2048_ver2;

public class Player {
    private int score;
    private int start;
    private int angka;


    public Player() {
        this.score = 0;
        this.start =-1;
        this.angka =-1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getAngka() {
        return angka;
    }

    public void setAngka(int angka) {
        this.angka = angka;
    }
}
