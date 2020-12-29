package com.belajar.roomv1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NilaiPrakDAO {
    @Query("select * from NilaiPrak")
    List<NilaiPrak> getAllNilai();


    @Query("DELETE FROM NilaiPrak")
    void nukeTable();

    @Insert
    void insert(NilaiPrak nilaiPrak);


    @Update
    void update(NilaiPrak nilaiPrak);

    @Delete
    void delete(NilaiPrak nilaiPrak);

}
