package com.meraghu.apnahealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBookActivity extends AppCompatActivity {

    EditText edname,edaddress,edcontact,edpincode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edname=findViewById(R.id.editTextBMBfullname);
        edaddress=findViewById(R.id.editTextBMBAddress);
        edcontact=findViewById(R.id.editTextBMBContact);
        edpincode=findViewById(R.id.editTextBMBPinCode);
        btnBooking=findViewById(R.id.buttonBMBbooking);

        Intent intent=getIntent();
        String[] price= intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date= intent.getStringExtra("date");



        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();

                Database db=new Database(getApplicationContext(),"APNA Healthcare",null,1);
                db.addOrder(username,edname.getText().toString(), edaddress.getText().toString(), edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()), date.toString(), "",Float.parseFloat(price[1].toString()),"medicine");

                db.removeCart(username,"medicine");
                Toast.makeText(getApplicationContext(), "Your booking is Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedicineBookActivity.this,HomeActivity.class));

            }
        });
    }
}