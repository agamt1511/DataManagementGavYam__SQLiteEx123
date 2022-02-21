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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FoodSupplierShow extends AppCompatActivity implements AdapterView.OnItemClickListener {
    SQLiteDatabase db;
    HelperDB hlp;
    Cursor crsr;

    ListView lvrecords;
    ArrayList<String> tbl = new ArrayList<>();
    ArrayAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_supplier_show);

        lvrecords = (ListView) findViewById(R.id.lvrecords);
        lvrecords.setOnItemClickListener(this);
        lvrecords.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        hlp = new HelperDB(this);

        crsr = db.query(FoodSupplier.TABLE_SUPPLIER, null, null, null, null, null, null);

        int col1 = crsr.getColumnIndex(FoodSupplier.SUPPLIER_NAME);
        int col2 = crsr.getColumnIndex(FoodSupplier.PRIMARY_PHONE);
        int col3 = crsr.getColumnIndex(FoodSupplier.SECOND_PHONE);
        int col4 = crsr.getColumnIndex(FoodSupplier.KEY_ID);

        crsr.moveToFirst();
        while (!crsr.isAfterLast()) {
            String name = crsr.getString(col1);
            String fPhone = crsr.getString(col2);
            String sPhone = crsr.getString(col3);
            int key = crsr.getInt(col4);
            String tmp = "" + name + ", " + fPhone + ", " + sPhone + ", " + key;
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
        Toast.makeText(this, "The data was added successfully", Toast.LENGTH_LONG).show();
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
        else if ((id==R.id.credits)){
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        }
        return super.onOptionsItemSelected(item);
    }
}