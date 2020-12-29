package com.kelas.fragment_kelas;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    int nrp;
    String name,gender,major;

    public Mahasiswa(int nrp, String name, String gender, String major) {
        this.nrp = nrp;
        this.name = name;
        this.gender = gender;
        this.major = major;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.nrp);
        dest.writeString(this.name);
        dest.writeString(this.gender);
        dest.writeString(this.major);
    }

    protected Mahasiswa(Parcel in) {
        this.nrp = in.readInt();
        this.name = in.readString();
        this.gender = in.readString();
        this.major = in.readString();
    }

    public static final Parcelable.Creator<Mahasiswa> CREATOR = new Parcelable.Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel source) {
            return new Mahasiswa(source);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };
}
