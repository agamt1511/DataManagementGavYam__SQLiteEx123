package com.example.datamanagementgavyam__sqliteex123;

import static com.example.datamanagementgavyam__sqliteex123.Orders.TABLE_ORDERS;

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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    SQLiteDatabase db;
    HelperDB hlp;
    Cursor crsr;

    ListView lvrecords;
    ArrayList<String> tbl = new ArrayList<>();
    ArrayAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvrecords = (ListView) findViewById(R.id.lvrecords);
        lvrecords.setOnItemClickListener(this);
        lvrecords.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        hlp = new HelperDB(this);

        crsr = db.query(TABLE_ORDERS, null, null, null, null, null, null);
        int col1 = crsr.getColumnIndex(Orders.ORDER_MEAL);
        int col2 = crsr.getColumnIndex(Orders.ORDER_EMPLOYEE);
        int col3 = crsr.getColumnIndex(Orders.ORDER_SUPPLIER);
        int col4 = crsr.getColumnIndex(Orders.DATE);
        int col5 = crsr.getColumnIndex(Orders.TIME);

        crsr.moveToFirst();
        while (!crsr.isAfterLast()) {
            String meal = crsr.getString(col1);
            String employee = crsr.getString(col2);
            String supplier = crsr.getString(col3);
            String date = crsr.getString(col4);
            String time = crsr.getString(col5);
            String tmp = "" + meal + ", " + employee + ", " + supplier + ", " + date + ", " + time ;
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
        Intent si = new Intent(this,FoodSupplierShow.class);
        startActivity(si);
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
        else if ((id==R.id.employees)){
            Intent si = new Intent(this,EmployeesShow.class);
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

    public void add(View view) {
        Intent si = new Intent(this,OrdersAdd.class);
        startActivity(si);
    }
}