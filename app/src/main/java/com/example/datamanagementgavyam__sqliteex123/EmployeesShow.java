package com.example.datamanagementgavyam__sqliteex123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EmployeesShow extends AppCompatActivity implements AdapterView.OnItemClickListener {
    SQLiteDatabase db;
    HelperDB hlp;
    Cursor crsr;

    ListView lvrecords;
    ArrayList<String> tbl = new ArrayList<>();
    ArrayAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_show);

        lvrecords = (ListView) findViewById(R.id.lvrecords);
        lvrecords.setOnItemClickListener(this);
        lvrecords.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        hlp = new HelperDB(this);

        crsr = db.query(Employees.TABLE_EMPLOYEES, null, null, null, null, null, null);
        int col1 = crsr.getColumnIndex(Employees.EMPLOYEE_FIRSTNAME);
        int col2 = crsr.getColumnIndex(Employees.EMPLOYEE_LASTNAME);
        int col3 = crsr.getColumnIndex(Employees.EMPLOYEE_ID);
        int col4 = crsr.getColumnIndex(Employees.EMPLOYEE_KEY_ID);
        int col5 = crsr.getColumnIndex(Employees.EMPLOYEE_COMPANY);
        int col6 = crsr.getColumnIndex(Employees.EMPLOYEE_PHONE);

        crsr.moveToFirst();
        while (!crsr.isAfterLast()) {
            String firstName = crsr.getString(col1);
            String lastName = crsr.getString(col2);
            int iD = crsr.getInt(col3);
            String card = crsr.getString(col4);
            String company = crsr.getString(col5);
            String phone = crsr.getString(col6);
            String tmp = "" + firstName + ", " + lastName + ", " + iD + ", " + card + ", " + company + ", " + phone ;
            tbl.add(tmp);
            crsr.moveToNext();
        }
        crsr.close();
        db.close();
        adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tbl);
        lvrecords.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    /**
     * OptionMenu:
     * Short description - Creation of OptionMenu.
     * @param menu
     * @return super.onCreateOptionsMenu(menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * OptionMenu:
     * Short description - Activating the OptionMenu.
     * @param item
     * @return super.onOptionsItemSelected(item)
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.meals){
            Intent si = new Intent(this,MealsShow.class);
            startActivity(si);
        }
        else if ((id==R.id.credits)){
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        }
        else if ((id==R.id.orders)){
            Intent si = new Intent(this,MainActivity.class);
            startActivity(si);
        }
        else if ((id==R.id.foodSupplier)){
            Intent si = new Intent(this,FoodSupplierShow.class);
            startActivity(si);
        }
        return super.onOptionsItemSelected(item);
    }
}