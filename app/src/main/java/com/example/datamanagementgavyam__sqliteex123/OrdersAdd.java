package com.example.datamanagementgavyam__sqliteex123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class OrdersAdd extends AppCompatActivity implements AdapterView.OnItemClickListener {
    SQLiteDatabase db;
    HelperDB hlp;
    Cursor crsr;

    Spinner employee, meal, foodSupplier;
    EditText time, date;
    ArrayList<String> tbl = new ArrayList<>();
    ArrayAdapter adp1, adp2, adp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_add);

        employee = (Spinner) findViewById(R.id.employee);
        meal = (Spinner) findViewById(R.id.meal);
        foodSupplier = (Spinner) findViewById(R.id.foodSupplier);
        time = (EditText) findViewById(R.id.time);
        date = (EditText) findViewById(R.id.date);

        employee.setOnItemClickListener(this);
        meal.setOnItemClickListener(this);
        foodSupplier.setOnItemClickListener(this);

        hlp = new HelperDB(this);

        crsr = db.query(FoodSupplier.TABLE_SUPPLIER, null, null, null, null, null, null);

        int col1 = crsr.getColumnIndex(Employees.EMPLOYEE_ID);
        int col2 = crsr.getColumnIndex(FoodSupplier.SUPPLIER_NAME);
        int col3 = crsr.getColumnIndex(Meals.MAIN_COURSE);

        crsr.moveToFirst();
        while (!crsr.isAfterLast()) {
            String employee = crsr.getString(col1);
            String tmp = "" + employee;
            tbl.add(tmp);
            crsr.moveToNext();
        }
        crsr.close();
        db.close();
        adp1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tbl);
        employee.setAdapter(adp1);

        crsr.moveToFirst();
        while (!crsr.isAfterLast()) {
            String supplier = crsr.getString(col2);
            String tmp = "" + supplier;
            tbl.add(tmp);
            crsr.moveToNext();
        }
        crsr.close();
        db.close();
        adp2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tbl);
        meal.setAdapter(adp2);

        crsr.moveToFirst();
        while (!crsr.isAfterLast()) {
            String meal = crsr.getString(col3);
            String tmp = "" + meal;
            tbl.add(tmp);
            crsr.moveToNext();
        }
        crsr.close();
        db.close();
        adp3 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tbl);
        foodSupplier.setAdapter(adp3);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public void add(View view) {
        Intent si = new Intent(this,MainActivity.class);
        startActivity(si);
    }
}