package com.annasblackhat.androidpersistance;

import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtProduk;
    private EditText edtHarga;
    private TextView txtResult;
    private MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtProduk = findViewById(R.id.edt_produk);
        edtHarga = findViewById(R.id.edt_harga);
        txtResult = findViewById(R.id.txt_result);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),
                MyAppDatabase.class,
                "my_app.db")
                .addMigrations(Migrations.MIGRATION_1_2)
                .build();

        findViewById(R.id.btn_simpan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanTransaksi();
            }
        });

        /*//user klik login, data sudah di validasi, login berhasil
        SharedPref sp = new SharedPref(this);
        sp.saveBoolean(true, SharedPref.KEY_IS_LOGIN);*/

        myAppDatabase.getTransaksiDao().getTransactionsLive().observe(this, new Observer<List<TransaksiEntity>>() {
            @Override
            public void onChanged(@Nullable List<TransaksiEntity> transactions) {
                String data = "";
                for (int i = 0; i < transactions.size(); i++) {
                    data += transactions.get(i).getProduk() + transactions.get(i).getHarga() + "\n";
                }
                txtResult.setText(data);
            }
        });
    }

    private void simpanTransaksi() {
        String produk = edtProduk.getText().toString();
        String harga = edtHarga.getText().toString();

        if(produk.isEmpty() || harga.isEmpty()){
            Toast.makeText(this, "produk atau harga harus di isi!", Toast.LENGTH_SHORT).show();
            return;
        }

        TransaksiEntity transaksiEntity = new TransaksiEntity(produk, Integer.valueOf(harga));

        List<Pajak> pajaks = new ArrayList<>(Arrays.asList(
                new Pajak(1, 500, "Tax 1"),
                new Pajak(2, 500, "Tax 2")
        ));
        transaksiEntity.setPajak(pajaks);

        new AsyncTask<TransaksiEntity, Void, String>(){
            @Override
            protected String doInBackground(TransaksiEntity... transaksiEntities) {
                myAppDatabase.getTransaksiDao().simpanTransaksi(transaksiEntities[0]);
                return null;
            }
        }.execute(transaksiEntity);

    }
}
