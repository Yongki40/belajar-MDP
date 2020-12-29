package com.example.fragment;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String nama,jenis;
    int saldo;

    public User(String nama, String jenis, int saldo) {
        this.nama = nama;
        this.jenis = jenis;
        this.saldo = saldo;
    }

    protected User(Parcel in) {
        nama = in.readString();
        jenis = in.readString();
        saldo = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(jenis);
        dest.writeInt(saldo);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return nama + " - " +saldo;
    }
}
