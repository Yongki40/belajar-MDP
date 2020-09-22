package com.belajar.intent;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    private String nrp,nama,angkatan,email,password,jurusan;

    public Mahasiswa(String nrp, String nama, String angkatan, String email, String password, String jurusan) {
        this.nrp = nrp;
        this.nama = nama;
        this.angkatan = angkatan;
        this.email = email;
        this.password = password;
        this.jurusan = jurusan;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public static Creator<Mahasiswa> getCREATOR() {
        return CREATOR;
    }

    public Mahasiswa(String nrp, String nama, String password) {
        this.nrp = nrp;
        this.nama = nama;
        this.password = password;
    }

    protected Mahasiswa(Parcel in) {
        nrp = in.readString();
        nama = in.readString();
        angkatan = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nrp);
        parcel.writeString(nama);
        parcel.writeString(angkatan);
        parcel.writeString(email);
        parcel.writeString(password);
    }
}
