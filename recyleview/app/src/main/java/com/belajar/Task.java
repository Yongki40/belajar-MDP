package com.belajar;

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {
    String nama,status,kategori;
    int img;
    boolean isDone;

    public Task(String nama, String status, String kategori) {
        this.nama = nama;
        this.status = status;
        this.kategori = kategori;
        isDone = false;
        if(kategori.equalsIgnoreCase("belajar")){
            img = R.drawable.book_normal;
        }
        else if(kategori.equalsIgnoreCase("makanan")){
            img = R.drawable.food_normal;
        }
        else{
            img = R.drawable.sports;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.status);
        dest.writeString(this.kategori);
        dest.writeInt(this.img);
        dest.writeByte(this.isDone ? (byte) 1 : (byte) 0);
    }

    protected Task(Parcel in) {
        this.nama = in.readString();
        this.status = in.readString();
        this.kategori = in.readString();
        this.img = in.readInt();
        this.isDone = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
