package danieeelfr.pocs.ciandt.embraco.poc01.entity;

import android.database.Cursor;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceOrder {
    private int Id;
    private String Description;
    private Date ExecutionDate;

    public ServiceOrder(final JSONObject jsonObject)
    {
//        this.Id = cursor.getInt(cursor.getColumnIndex("Id"));
//        this.Description = cursor.getString(cursor.getColumnIndex("Name"));
//        // this.ExecutionDate = cursor.getString(cursor.getColumnIndex("ExecutionDate"));
//        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
//        // this.ExecutionDate = formatter.parse(cursor.getString(cursor.getColumnIndex("ExecutionDate")));
    }

    public String getDescription(){
        return this.Description;
    }

    public void setDescription(String description){
        this.Description = description;
    }

    public Date getExecutionDate(){
        return this.ExecutionDate;
    }

    public void setExecutionDate(Date executionDate){
        this.ExecutionDate = executionDate;
    }

    public int getId() {
        return this.Id;
    }
}
