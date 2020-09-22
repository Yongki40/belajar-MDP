package com.belajar.bodymass;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    private String username,password,gender,tahunKabisat;
    private int tahun;
    private float bmi,tinggi,berat;;

    public User(String username, String password, String gender, String tahunKabisat, int tahun, float tinggi, float berat, float bmi) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.tahunKabisat = tahunKabisat;
        this.tahun = tahun;
        this.tinggi = tinggi;
        this.berat = berat;
        this.bmi = bmi;
    }

    protected User(Parcel in) {
        username = in.readString();
        password = in.readString();
        gender = in.readString();
        tahunKabisat = in.readString();
        tahun = in.readInt();
        tinggi = in.readInt();
        berat = in.readInt();
        bmi = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTahunKabisat() {
        return tahunKabisat;
    }

    public void setTahunKabisat(String tahunKabisat) {
        this.tahunKabisat = tahunKabisat;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public float getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public float getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    @NonNull
    @Override
    public String toString() {
        return username+" "+gender+" "+berat+" "+" "+tahun;
    }

    public String statusBmi(){
        if(this.bmi < 18.5){
            return "Kekurangan Berat Badan";
        }
        else if(this.bmi > 18.5 && this.bmi < 24.9 ){
            return "Normal ";
        }
        else if(this.bmi > 25.0 && this.bmi < 29.9 ){
            return "Kelebihan Berat Badan";
        }
        else if(this.bmi > 30 ){
            return "Obesitas";
        }

        return "";
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(gender);
        parcel.writeString(tahunKabisat);
        parcel.writeInt(tahun);
        parcel.writeInt((int) tinggi);
        parcel.writeInt((int) berat);
        parcel.writeInt((int) bmi);
    }
}
