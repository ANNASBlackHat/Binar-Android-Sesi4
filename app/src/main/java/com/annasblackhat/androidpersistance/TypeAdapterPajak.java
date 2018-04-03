package com.annasblackhat.androidpersistance;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TypeAdapterPajak {

    @TypeConverter
    public String toString(List<Pajak> pajakList){
        return new Gson().toJson(pajakList);
    }

    @TypeConverter
    public List<Pajak> toList(String data){
        Type type = new TypeToken<List<Pajak>>(){}.getType();
        return new Gson().fromJson(data, type);
    }
}
