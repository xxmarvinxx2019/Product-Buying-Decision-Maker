package com.example.prodcutbuyingdecisionmaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "decision_table";
    private static final String PERSONAL_DETAIL = "personal_detail";
    private static final String INTEREST_PRODUCT = "interest_product";

    DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1 = "CREATE TABLE "+PERSONAL_DETAIL+"(id INTEGER PRIMARY KEY,Fname TEXT NOT NULL,age INTEGER NOT NULL,occupation TEXT NOT NULL,savings INTEGER NOT NULL,salary INTEGER NOT NULL)";
        String table2 = "CREATE TABLE "+INTEREST_PRODUCT+"(id INTEGER PRIMARY KEY,product TEXT NOT NULL)";
        db.execSQL(table1);
        db.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +PERSONAL_DETAIL);
        db.execSQL("DROP TABLE IF EXISTS " +INTEREST_PRODUCT);
        onCreate(db);
    }
    public boolean insert(String fname,int age,String occupation,int savings,int salary){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Fname",fname);
        contentValues.put("age",age);
        contentValues.put("occupation",occupation);
        contentValues.put("savings",savings);
        contentValues.put("salary",salary);

        sqLiteDatabase.insert(PERSONAL_DETAIL,null,contentValues);
        return true;
    }
    public boolean insert1(String product){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("product",product);

        sqLiteDatabase.insert(INTEREST_PRODUCT,null,contentValues);
        return true;
    }
    public Cursor fetch() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+PERSONAL_DETAIL,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public boolean update(String id,String fname,int age,String occupation,int savings,int salary){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id",id);
        contentValues.put("Fname",fname);
        contentValues.put("age",age);
        contentValues.put("occupation",occupation);
        contentValues.put("savings",savings);
        contentValues.put("salary",salary);

        sqLiteDatabase.update(PERSONAL_DETAIL, contentValues, "id = ?",new String[] { id });
        return true;
    }
}
