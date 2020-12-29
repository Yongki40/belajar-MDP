package com.belajar.menu;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String nama,password,jenis;
    private long nomor;

    public User(String nama, String password, String jenis, long nomor) {
        this.nama = nama;
        this.password = password;
        this.jenis = jenis;
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public long getNomor() {
        return nomor;
    }

    public void setNomor(long nomor) {
        this.nomor = nomor;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.password);
        dest.writeString(this.jenis);
        dest.writeLong(this.nomor);
    }

    protected User(Parcel in) {
        this.nama = in.readString();
        this.password = in.readString();
        this.jenis = in.readString();
        this.nomor = in.readLong();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
