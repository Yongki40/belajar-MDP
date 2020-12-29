package com.belajar.fragment_v3;

import android.os.Parcel;
import android.os.Parcelable;

public class DataTrans implements Parcelable {
    String nama,jenis;
    int nilai;

    public DataTrans(String nama, String jenis, int nilai) {
        this.nama = nama;
        this.jenis = jenis;
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return nama +" - "+ nilai;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.jenis);
        dest.writeInt(this.nilai);
    }

    protected DataTrans(Parcel in) {
        this.nama = in.readString();
        this.jenis = in.readString();
        this.nilai = in.readInt();
    }

    public static final Parcelable.Creator<DataTrans> CREATOR = new Parcelable.Creator<DataTrans>() {
        @Override
        public DataTrans createFromParcel(Parcel source) {
            return new DataTrans(source);
        }

        @Override
        public DataTrans[] newArray(int size) {
            return new DataTrans[size];
        }
    };
}
