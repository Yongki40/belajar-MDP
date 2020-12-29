package com.belajar.menu;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Property implements Parcelable {
    private String alamat;
    private int harga,luas;

    public Property(String alamat, int harga, int luas) {
        this.alamat = alamat;
        this.harga = harga;
        this.luas = luas;
    }

    @NonNull
    @Override
    public String toString() {
        return alamat+"\n HARGA: "+harga+"JT \n LUAS BANGUNAN: "+luas+" M2";
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getLuas() {
        return luas;
    }

    public void setLuas(int luas) {
        this.luas = luas;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.alamat);
        dest.writeInt(this.harga);
        dest.writeInt(this.luas);
    }

    protected Property(Parcel in) {
        this.alamat = in.readString();
        this.harga = in.readInt();
        this.luas = in.readInt();
    }

    public static final Parcelable.Creator<Property> CREATOR = new Parcelable.Creator<Property>() {
        @Override
        public Property createFromParcel(Parcel source) {
            return new Property(source);
        }

        @Override
        public Property[] newArray(int size) {
            return new Property[size];
        }
    };
}
