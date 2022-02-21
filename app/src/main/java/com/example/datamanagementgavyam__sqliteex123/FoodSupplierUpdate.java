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

public class FoodSupplierUpdate extends AppCompatActivity {
    EditText ComName, PPhone, SPhone;
    String Company_Name, Primary_Phone, Second_Phone;
    SQLiteDatabase db;
    HelperDB hlp;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_supplier_update);

        ComName = (EditText) findViewById(R.id.ComName);
        PPhone = (EditText) findViewById(R.id.PPhone);
        SPhone = (EditText) findViewById(R.id.SPhone);

        hlp = new HelperDB(this);
        position = 1;
    }

    public void delete(View view) {
        db = hlp.getWritableDatabase();
        db.delete(FoodSupplier.TABLE_SUPPLIER, FoodSupplier.KEY_ID+"=?", new String[]{Integer.toString(position + 1)});
        db.close();
    }

    public void update(View view) {
        if (checking(view)){
            delete(view);

            ContentValues cv = new ContentValues();

            cv.put(FoodSupplier.SUPPLIER_NAME,Company_Name);
            cv.put(FoodSupplier.PRIMARY_PHONE,Primary_Phone);
            cv.put(FoodSupplier.SECOND_PHONE,Second_Phone);
            cv.put(FoodSupplier.SUPPLIER_ACTIVE,1);

            db = hlp.getWritableDatabase();
            db.insert(FoodSupplier.TABLE_SUPPLIER, null, cv);
            db.close();

            Toast.makeText(this, "The data was updated successfully", Toast.LENGTH_LONG).show();
            Intent si = new Intent(this,FoodSupplierShow.class);
            startActivity(si);
        }
    }

    public boolean checking (View view){
        if ((TextUtils.isEmpty(ComName.getText().toString()))
                || (TextUtils.isEmpty(PPhone.getText().toString()))
                || (TextUtils.isEmpty(SPhone.getText().toString()))){
            Toast.makeText(this, "You did not enter any text", Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            Company_Name = ComName.getText().toString();
            Primary_Phone = PPhone.getText().toString();
            Second_Phone = SPhone.getText().toString();

            int lengthPP = PPhone.length();
            int lengthSP = SPhone.length();
            if ((lengthPP != 10)&&(lengthSP != 10)){
                Toast.makeText(this, "You entered the wrong phone number", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }
}