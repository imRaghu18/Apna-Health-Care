package com.meraghu.apnahealthcare;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name:Dr.Amarnath Chaudhary","Hospital Adress: Janakpur","Exp:15yrs","Mobile No:9824802424","1500"},
                    {"Doctor Name:Dr. Rabindra Nath Shukla","Hospital Adress: Kathmandu","Exp:10yrs","Mobile No:9817277623","500"},
                    {"Doctor Name:Dr. Shakya Nirmal ","Hospital Adress: Kathmandu","Exp:10yrs","Mobile No:9878237623","700"},
                    {"Doctor Name:Dr. Gongal Rajesh Nath","Hospital Adress: Chitwan","Exp:2yrs","Mobile No:9812769823","600"},
                    {"Doctor Name:Dr.Karki","Hospital Adress: Pokhara","Exp:3yrs","Mobile No:9814823781","1000"}

            };
    private String[][] doctor_details2=
            {
                    {"Doctor Name:Dr.Anant Chaudhary","Hospital Adress: Janakpur","Exp:5yrs","Mobile No:9824611798","1000"},
                    {"Doctor Name:Dr. Ritesh Pandey","Hospital Adress: Janakpur","Exp:10yrs","Mobile No:9814823456","1000"},
                    {"Doctor Name:Sooraj Sharma","Hospital Adress: Janakpur","Exp:5yrs","Mobile No:9824835672","1500"},
                    {"Doctor Name:Dr.Balram Mishra","Hospital Adress:Janakpur","Exp:25yrs","Mobile No:9823512876","1500"},
                    {"Doctor Name:Dr.Jamun Singh","Hospital Adress:Janakpur","Exp:10yrs","Mobile No:9824812354","1500"}

            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name:Dr.Anit Kumar Sah","Hospital Adress:Janakpur","Exp:3yrs","Mobile No:9814823781","1000"},
                    {"Doctor Name:Dr.Anantika Chaudhary","Hospital Adress: Janakpur","Exp:5yrs","Mobile No:9804824043","1000"},
                    {"Doctor Name:Dr. Prakash Pandey","Hospital Adress: Kathmandu","Exp:10yrs","Mobile No:9823487256","1500"},
                    {"Doctor Name:Dr.Smriti Pandit ","Hospital Adress:Janakpur","Exp:5yrs","Mobile No:9878237623","700"},
                    {"Doctor Name:Dr.Roshan Sah","Hospital Adress:Janakpur","Exp:7yrs","Mobile No:9812769823","600"}


            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name:Dr.Ram Akhilesh Chaudhary","Hospital Adress: Janakpur","Exp:10yrs","Mobile No:9807991495","1500"},
                    {"Doctor Name:Dr.Mrigank Pratik","Hospital Adress: Janakpur","Exp:5yrs","Mobile No:9844276174","1500"},
                    {"Doctor Name:Dr.Sanjay Chaudhary","Hospital Adress: Janakpur","Exp:10yrs","Mobile No:9812045678","1500"},
                    {"Doctor Name:Dr.Rakesh Pandit ","Hospital Adress: Janakpur","Exp:13yrs","Mobile No:9865827892","700"},
                    {"Doctor Name:Dr.Rabin Pratab Sah","Hospital Adress:Janakpur","Exp:6yrs","Mobile No:9821541237","1000"}

            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name:Dr.Ram Nilesh Chaudhary","Hospital Adress: Janakpur","Exp:10yrs","Mobile No:9812018401","1500"},
                    {"Doctor Name:Dr.Shivam Jha","Hospital Adress: Janakpur","Exp:5yrs","Mobile No:9816882169","1500"},
                    {"Doctor Name:Dr.Amit Singh ","Hospital Adress: Janakpur","Exp:10yrs","Mobile No:9824867234","700"},
                    {"Doctor Name:Dr.Om Murti Anil","Hospital Adress: Kathmandu","Exp:5yrs","Mobile No:9824537825","12000"},
                    {"Doctor Name:Dr.Ajay Mishra","Hospital Adress: Janakpur","Exp:7yrs","Mobile No:9824679756","1000"}

            };

    TextView tv;
    Button btn;

    String[][] doctor_details={};
    HashMap<String,String>data;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;

        else if(title.compareTo("Pediatrician")==0)
            doctor_details=doctor_details2;

        else if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;

        else if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else

            doctor_details=doctor_details5;




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));

            }
        });
        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            data=new HashMap<>();
            data.put("line1", doctor_details[i][0]);
            data.put("line2",doctor_details[i][1]);
            data.put("line3",doctor_details[i][2]);
            data.put("line4",doctor_details[i][3]);
            data.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( data );


        }
        sa=new SimpleAdapter (this,list, R.layout.multi_lines, new String[]{"line1","line2","line3","line4","line5"}, new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

      ListView lst=findViewById(R.id.listviewDD);
      lst.setAdapter(sa);


             lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                      Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                      it.putExtra("text1",title);
                      it.putExtra("text2",doctor_details[i][0]);
                      it.putExtra("text3",doctor_details[i][1]);
                      it.putExtra("text4",doctor_details[i][3]);
                      it.putExtra("text5",doctor_details[i][4]);
                      startActivity(it);
                  }
              });
    }

}
