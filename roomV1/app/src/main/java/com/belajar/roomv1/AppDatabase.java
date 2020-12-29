package com.belajar.roomv1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NilaiPrak.class},version = 1) //jika mau lebih dari 1 database bisa di koma
public abstract class AppDatabase extends RoomDatabase {
    public abstract NilaiPrakDAO nilaiPrak();
    private static AppDatabase INSTANCE;


    public static AppDatabase getAppDatabase(Context context){
        //cek ada database atau tidak
        if(INSTANCE == null){
            //jika belum ada dibuild dulu
            INSTANCE = Room.databaseBuilder(context,AppDatabase.class,"NilaiPrak").build();
        }
        return INSTANCE;
    }
}
