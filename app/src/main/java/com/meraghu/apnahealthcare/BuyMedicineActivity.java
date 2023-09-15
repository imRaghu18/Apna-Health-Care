package com.meraghu.apnahealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages={
            {"Azithromycin-500Mg Tablet","","","","300"},
            {"Vitamin-B Complex Capsules","","","","200"},
            {"pentoz-40Mg","","","","80"},
            {"Amoxyn-500Mg","","","","80"},
            {"Brufen-400Mg","","","","30"},
            {"Strepsils Medicated Lozenges for Sore Throat","","","","90"},
            {"Arcetrin-10Mg Tablet","","","","20"},
            {"Aclofen-100 mg","","","","40"},
            {"AVS10 Tablet","","","","50"}

    };

    private String[] packages_details={
      "It is used to bind to the 50S ribosomal subunit of bacteria and interfere with their protein synthesis",
          "Building and keeping the bones & teeth Strong\n"+
          "Reducing Fatingue/Stress and muscular Pains\n"+
          "Boosting immunity and increasing resistance against infection",
            " proton pump inhibitors (PPIs), which block acid production by the stomach",
            "Inhibits bacterial cell wall synthesis by binding to one or more of the penicillin-binding proteins (PBPs)",
            "Nonsteroidal anti-inflammatory drugs (NSAIDs) work by reversibly inhibiting cyclo-oxygenase (COX) enzymes, thereby inhibiting prostaglandin synthesis",
            "Relieaves the symptoms of a bacterial throat infection and soothes the recovery process\n"+
                    "provides a warm and comforting feeling during the sore throat",
            "This drug is a selective peripheral H1 receptor antagonist\n"+
                    "it inhibits the allergic symptoms produced by histamines like cold, rhinorrhea, sneezing, urticaria etc",

            "blocking the production of prostaglandins, which are hormone-like substances released at the site where the pain is felt",
" inhibits 3-hydroxy-3-methylglutaryl-coenzyme A (HMG-CoA) reductase\n"+
        "By preventing the conversion of HMG-CoA to mevalonate, statin medications decrease cholesterol production in the liver.\n" +
            "Atorvastatin also increases the number of LDL receptors on the surface of hepatic cells. "



    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoTOCart,btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        lst=findViewById(R.id.listviewBM);
        btnGoTOCart=findViewById(R.id.buttonBMGoCart);
        btnBack=findViewById(R.id.buttonBMBack);

        btnGoTOCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,GoCartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);

        }
        sa=new SimpleAdapter (this,list, R.layout.multi_lines, new String[]{"line1","line2","line3","line4","line5"}, new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",packages_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }

    });
    }
}