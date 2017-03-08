package danieeelfr.pocs.ciandt.embraco.poc01.entity;

import android.database.Cursor;

public class Professional {
    private int Id;
    private String Name;

    public Professional(final Cursor cursor)
    {
        this.Id = cursor.getInt(cursor.getColumnIndex("Id"));
        this.Name = cursor.getString(cursor.getColumnIndex("Name"));
    }

    public String getName(){
        return this.Name;
    }

    public void setName(String name){
        this.Name = name;
    }

    public int getId() {
        return this.Id;
    }
}