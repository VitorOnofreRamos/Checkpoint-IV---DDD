package org.example.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.LocalDateTimeTypeAdapter;

import java.time.LocalDateTime;

public abstract class _BaseEntity {
    public int id;

    public _BaseEntity(){}

    public _BaseEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toJson(){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter()).create();
        /*Gson gson = new GsonBuilder().setPrettyPrinting().create();*/

        return gson.toJson(this);
    }

    @Override
    public String toString() {
        return "_BaseEntity{" +
                "id=" + id +
                '}';
    }
}