package com.example.listvieww;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String [] lands= {"Asia","Europe","Africa","Antartica","Australia","South America","North America"};
    ListView lv;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.lv);

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String> (this.layout.support_simple_spinner_dropdown_item, lands);
        lv.setAdapter(adp);

    }

    @Override
    public void onItemClick (AdapterView<?> parent), View view, int position, long id){
        st=lands[position];
    }

