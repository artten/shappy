package com.example.shappy;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    private String Name;
    private String Sum;
    @PrimaryKey(autoGenerate = true)
    private int id;

    public Note(String name, String sum) {
        Name = name;
        Sum = sum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public String getSum() {
        return Sum;
    }

    public int getId() {
        return id;
    }


}
