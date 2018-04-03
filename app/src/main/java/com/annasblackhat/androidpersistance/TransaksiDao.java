package com.annasblackhat.androidpersistance;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TransaksiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void simpanTransaksi(TransaksiEntity transaksiEntity);

    @Insert
    void simpanBanyakTransaksi(List<TransaksiEntity> transaksiEntityList);

    @Update
    void ubahTransaksi(TransaksiEntity transaksiEntity);

    @Delete
    void hapusTransaksi(TransaksiEntity transaksiEntity);

    @Query("DELETE FROM transaksi WHERE harga > :max")
    void hapusByHarga(int max);

    @Query("SELECT * FROM transaksi")
    List<TransaksiEntity> getTransactions();

    @Query("SELECT * FROM transaksi")
    LiveData<List<TransaksiEntity>> getTransactionsLive();

    @Query("SELECT * FROM transaksi WHERE noNota = :noNota")
    List<TransaksiEntity> getTransactionsById(int noNota);
}
