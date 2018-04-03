package com.annasblackhat.androidpersistance;

public class Pajak {
    private int id;
    private int jumlah;
    private String namaPajak;

    public Pajak(int id, int jumlah, String namaPajak) {
        this.id = id;
        this.jumlah = jumlah;
        this.namaPajak = namaPajak;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getNamaPajak() {
        return namaPajak;
    }

    public void setNamaPajak(String namaPajak) {
        this.namaPajak = namaPajak;
    }
}
