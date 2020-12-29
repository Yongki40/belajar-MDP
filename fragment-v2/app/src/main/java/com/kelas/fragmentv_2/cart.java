package com.kelas.fragmentv_2;

import android.os.Parcel;
import android.os.Parcelable;

public class cart implements Parcelable {
    String nama,jenis;
    int harga;

    @Override
    public String toString() {
        return nama +" - "+harga ;
    }

    public cart(String nama, String jenis, int harga) {
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.jenis);
        dest.writeInt(this.harga);
    }

    protected cart(Parcel in) {
        this.nama = in.readString();
        this.jenis = in.readString();
        this.harga = in.readInt();
    }

    public static final Parcelable.Creator<cart> CREATOR = new Parcelable.Creator<cart>() {
        @Override
        public cart createFromParcel(Parcel source) {
            return new cart(source);
        }

        @Override
        public cart[] newArray(int size) {
            return new cart[size];
        }
    };
}
