package com.example.listvieww;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    TextView tv1,tv2;
    ListView lv;
    String[][]st1={{"Israel","India","China","Yemen","Jordan","Kuwait","Thailand"},{"Italy","France","Spain","United Kingdom","Germany","Poland","Belgium"},{"Morocco","Algeria","Libya","Chad","Egypt","Kenia","Sudan"},{"Brazil","Bolivia","Paraguay","Argentina","Colombia","Ecuador","Peru"},{"Canada","Mexico","Barbados","Costa Rica","Bahamas","Jamaica","California"}};
    String[][]st2={{"Jerusalem","New Deli","Beijing","Sana'a","Amman","Kuwait City","Bangkok","Rome","Paris","Madrid","London","Berlin","WarSaw","Brussels","Rabat","Algiers","Tripoli","N'Djamena","Cairo","Nairobi","Khartoum","Brasilia","La Paz","Asuncion","Buenos Aires","Bogota","Quito","Lima","Ottawa","Mexico City","Bridgetown","San Jose","Nassau","Kingston","Sacramento"},
            {"8,891,800","1,349,217,956","1,409,517,397","28,250,420","10,428,241","4,621,638","66,188,503","60,359,546","67,022,000","46,733,038","67,545,757","82,979,100","38,433,600","11,420,163","36,029,138","42,200,000","7,200,000","15,228,584","94,798,827","49,364,325","41,592,539","210,147,125","11,428,245","7,152,703","44,938,712","48,258,494","16,624,858","33,105,273","36,708,083","126,577,691","285,719","4,905,769","395,361","2,890,299","39,557,045"}};
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1=(TextView)findViewById(R.id.capi);
        tv2=(TextView)findViewById(R.id.popu);
        lv=(ListView)findViewById(R.id.lv);
        Intent si=getIntent();
        x=si.getIntExtra("position",2);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,st1[x]);

        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);
        lv.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tv1.setText("Capital City: " + st2[0][x * 7 + position]);
        tv2.setText("Population: " + st2[1][x * 7 + position]);
    }


    public void bt2(View view) {
        finish();
    }
}
