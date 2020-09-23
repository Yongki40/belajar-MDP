package com.belajar.bodymassv_3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    private String nama,gender;
    private int tahun;
    private float tinggi,berat;

    public User(String nama, String gender, int tahun, float tinggi, float berat) {
        this.nama = nama;
        this.gender = gender;
        this.tahun = tahun;
        this.tinggi = tinggi;
        this.berat = berat;
    }

    public float countBMI(){
        float tinggi = this.tinggi /100;
        return berat / (tinggi * tinggi);
    }

    public String statusBmi(){
        if(countBMI() < 18.5){
            return "Kekurangan Berat Badan";
        }
        else if(countBMI() > 18.5 && countBMI() < 24.9){
            return "Normal";
        }
        else if(countBMI() > 25.0 && countBMI() < 29.9){
            return "Kelebihan Berat Badan";
        }
        else{
            return "Obesitas";
        }

    }

    public String tahunKabisat(){
        return tahun / 4 == 0 ? "Kabisat" : "Bukan Kabisat";
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s",nama,gender,tinggi,berat,tahun);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public void setTinggi(float tinggi) {
        this.tinggi = tinggi;
    }

    public float getBerat() {
        return berat;
    }

    public void setBerat(float berat) {
        this.berat = berat;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    protected User(Parcel in) {
        nama = in.readString();
        gender = in.readString();
        tahun = in.readInt();
        tinggi = in.readFloat();
        berat = in.readFloat();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(gender);
        parcel.writeInt(tahun);
        parcel.writeFloat(tinggi);
        parcel.writeFloat(berat);
    }
}
