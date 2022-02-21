package com.example.datamanagementgavyam__sqliteex123;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FoodSupplier {
    public static final String TABLE_SUPPLIER = "Supplier";
    public static final String KEY_ID = "_id";
    public static final String SUPPLIER_NAME = "SupplierName";
    public static final String PRIMARY_PHONE = "PrimaryPhone";
    public static final String SECOND_PHONE = "SecondPhone";
    public static final String SUPPLIER_ACTIVE = "SupplierActive";
}