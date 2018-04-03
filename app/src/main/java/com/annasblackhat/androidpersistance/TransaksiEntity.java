package com.annasblackhat.androidpersistance;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

@Entity(tableName = "transaksi")
@TypeConverters(TypeAdapterPajak.class)
public class TransaksiEntity {

    @PrimaryKey(autoGenerate = true)
    private int noNota;

    @ColumnInfo(name = "nama_produk")
    private String produk;

    private int harga;
    private String kategori;
    private List<Pajak> pajak;

    public TransaksiEntity(String produk, int harga) {
        this.produk = produk;
        this.harga = harga;
    }

    public List<Pajak> getPajak() {
        return pajak;
    }

    public void setPajak(List<Pajak> pajak) {
        this.pajak = pajak;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setNoNota(int noNota) {
        this.noNota = noNota;
    }

    public int getNoNota() {
        return noNota;
    }

    public String getProduk() {
        return produk;
    }

    public int getHarga() {
        return harga;
    }
}
