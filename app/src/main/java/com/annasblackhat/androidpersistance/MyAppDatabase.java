package com.annasblackhat.androidpersistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {TransaksiEntity.class}, version = 2)
public abstract class MyAppDatabase extends RoomDatabase {

    abstract TransaksiDao getTransaksiDao();

}
