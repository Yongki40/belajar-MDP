package com.belajar.pertemuan2;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    private String nama;
    private String nrp;
    private String password;
    private String jurusan;
    private String angkatan;
    private String email;

    public Mahasiswa(String nama, String nrp, String password, String jurusan, String angkatan, String email) {
        this.nama = nama;
        this.nrp = nrp;
        this.password = password;
        this.jurusan = jurusan;
        this.angkatan = angkatan;
        this.email = email;
    }

    protected Mahasiswa(Parcel in) {
        nama = in.readString();
        nrp = in.readString();
        password = in.readString();
        jurusan = in.readString();
        angkatan = in.readString();
        email = in.readString();
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(nrp);
        parcel.writeString(password);
        parcel.writeString(jurusan);
        parcel.writeString(angkatan);
        parcel.writeString(email);
    }
}
