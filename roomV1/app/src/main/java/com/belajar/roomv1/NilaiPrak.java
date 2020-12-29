package com.belajar.roomv1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "NilaiPrak")
public class NilaiPrak implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "minggu")
    private String minggu;

    @ColumnInfo(name = "absen")
    private int absen;

    @ColumnInfo(name = "tes")
    private int tes;

    @ColumnInfo(name = "materi")
    private int materi;

    @ColumnInfo(name = "tugas")
    private int tugas;

    @ColumnInfo(name = "total")
    private int total;

    public NilaiPrak(String minggu) {
        this.minggu = minggu;
    }

    public String getMinggu() {
        return minggu;
    }

    public void setMinggu(String minggu) {
        this.minggu = minggu;
    }

    public int getAbsen() {
        return absen;
    }

    public void setAbsen(int absen) {
        this.absen = absen;
    }

    public int getTes() {
        return tes;
    }

    public void setTes(int tes) {
        this.tes = tes;
    }

    public int getMateri() {
        return materi;
    }

    public void setMateri(int materi) {
        this.materi = materi;
    }

    public int getTugas() {
        return tugas;
    }

    public void setTugas(int tugas) {
        this.tugas = tugas;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal(){
        return absen + tes + materi + tugas + total;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.minggu);
        dest.writeInt(this.absen);
        dest.writeInt(this.tes);
        dest.writeInt(this.materi);
        dest.writeInt(this.tugas);
        dest.writeInt(this.total);
    }

    protected NilaiPrak(Parcel in) {
        this.minggu = in.readString();
        this.absen = in.readInt();
        this.tes = in.readInt();
        this.materi = in.readInt();
        this.tugas = in.readInt();
        this.total = in.readInt();
    }

    public static final Parcelable.Creator<NilaiPrak> CREATOR = new Parcelable.Creator<NilaiPrak>() {
        @Override
        public NilaiPrak createFromParcel(Parcel source) {
            return new NilaiPrak(source);
        }

        @Override
        public NilaiPrak[] newArray(int size) {
            return new NilaiPrak[size];
        }
    };
}
