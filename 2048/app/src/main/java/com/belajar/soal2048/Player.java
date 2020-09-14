package com.belajar.soal2048;

public class Player {
    private int score;
    private int start,angka1;

    public Player() {
        this.score = 0;
        this.start = -1;
        this.angka1 = -1;
    }


    public int getAngka1() {
        return angka1;
    }

    public void setAngka1(int angka1) {
        this.angka1 = angka1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        int total = getScore() + score;
        this.score = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
