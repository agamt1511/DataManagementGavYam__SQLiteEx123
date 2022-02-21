package com.example.datamanagementgavyam__sqliteex123;
import static com.example.datamanagementgavyam__sqliteex123.FoodSupplier.*;
import static com.example.datamanagementgavyam__sqliteex123.Employees.*;
import static com.example.datamanagementgavyam__sqliteex123.Meals.*;
import static com.example.datamanagementgavyam__sqliteex123.Orders.*;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbexam.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate, strDelete;

    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate="CREATE TABLE "+TABLE_SUPPLIER;
        strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+SUPPLIER_NAME+" TEXT,";
        strCreate+=" "+PRIMARY_PHONE+" TEXT,";
        strCreate+=" "+SECOND_PHONE+" TEXT,";
        strCreate+=" "+SUPPLIER_ACTIVE+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+TABLE_EMPLOYEES;
        strCreate+=" ("+EMPLOYEE_KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+EMPLOYEE_FIRSTNAME+" TEXT,";
        strCreate+=" "+EMPLOYEE_LASTNAME+" TEXT,";
        strCreate+=" "+EMPLOYEE_ID+" TEXT,";
        strCreate+=" "+EMPLOYEE_COMPANY+" TEXT,";
        strCreate+=" "+EMPLOYEE_PHONE+" TEXT,";
        strCreate+=" "+EMPLOYEE_ACTIVE+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+TABLE_MEALS;
        strCreate+=" ("+MEAL_KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+APPETIZER+" TEXT,";
        strCreate+=" "+MAIN_COURSE+" TEXT,";
        strCreate+=" "+EXTRA+" TEXT,";
        strCreate+=" "+DESSERT+" TEXT,";
        strCreate+=" "+BEVERAGE+" TEXT,";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+TABLE_ORDERS;
        strCreate+=" ("+ORDERS_KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+DATE+" TEXT,";
        strCreate+=" "+TIME+" TEXT,";
        strCreate+=" "+ORDER_EMPLOYEE+" TEXT,";
        strCreate+=" "+ORDER_MEAL+" TEXT,";
        strCreate+=" "+ORDER_SUPPLIER+" TEXT,";
        strCreate+=");";
        db.execSQL(strCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        strDelete="DROP TABLE IF EXISTS "+TABLE_SUPPLIER;
        db.execSQL(strDelete);

        strDelete="DROP TABLE IF EXISTS "+TABLE_EMPLOYEES;
        db.execSQL(strDelete);

        strDelete="DROP TABLE IF EXISTS "+TABLE_MEALS;
        db.execSQL(strDelete);

        strDelete="DROP TABLE IF EXISTS "+TABLE_ORDERS;
        db.execSQL(strDelete);

        onCreate(db);
    }
}
