package com.latihan.tugas1;

public class Pin {
    private String simbol;
    private String color;
    private int last_visit;

    public Pin(String simbol, String color, int last_visit) {
        this.simbol = simbol;
        this.color = color;
        this.last_visit = last_visit;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLast_visit() {
        return last_visit;
    }

    public void setLast_visit(int last_visit) {
        this.last_visit = last_visit;
    }
}
