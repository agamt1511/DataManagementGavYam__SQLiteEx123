package com.example.datamanagementgavyam__sqliteex123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MealsAdd extends AppCompatActivity {
    EditText appetizer, main_course, extra, desert, beverage;
    String meal1_ap, meal2_mc, meal3_ex, meal4_de, meal5_be;
    SQLiteDatabase db;
    HelperDB hlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_add);

        appetizer = (EditText) findViewById(R.id.appetizer);
        main_course = (EditText) findViewById(R.id.main_course);
        extra = (EditText) findViewById(R.id.extra);
        desert = (EditText) findViewById(R.id.desert);
        beverage = (EditText) findViewById(R.id.beverage);

        hlp = new HelperDB(this);
    }

    public void add(View view) {
        if ((TextUtils.isEmpty(appetizer.getText().toString()))
                || (TextUtils.isEmpty(main_course.getText().toString()))
                || (TextUtils.isEmpty(extra.getText().toString()))
                || (TextUtils.isEmpty(desert.getText().toString()))
                || (TextUtils.isEmpty(beverage.getText().toString()))){
            Toast.makeText(this, "You did not enter any text", Toast.LENGTH_LONG).show();
        }
        else{
            meal1_ap = appetizer.getText().toString();
            meal2_mc = main_course.getText().toString();
            meal3_ex = extra.getText().toString();
            meal4_de = desert.getText().toString();
            meal5_be = beverage.getText().toString();

            ContentValues cv = new ContentValues();

            cv.put(Meals.APPETIZER,meal1_ap);
            cv.put(Meals.MAIN_COURSE,meal2_mc);
            cv.put(Meals.EXTRA,meal3_ex);
            cv.put(Meals.DESSERT,meal4_de);
            cv.put(Meals.BEVERAGE,meal5_be);

            db = hlp.getWritableDatabase();
            db.insert(Meals.TABLE_MEALS, null, cv);
            db.close();

            Toast.makeText(this, "The data was added successfully", Toast.LENGTH_LONG).show();

            Intent si = new Intent(this,MealsShow.class);
            startActivity(si);
        }
    }
}