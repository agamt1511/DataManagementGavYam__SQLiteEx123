package com.example.datamanagementgavyam__sqliteex123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
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
}