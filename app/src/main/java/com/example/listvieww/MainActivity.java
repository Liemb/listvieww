package com.example.listvieww;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] lands = {"Asia", "Europe", "Africa", "South America", "North America"};
    ListView lv;
    int y=60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, lands);
        lv.setAdapter(adp);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "" +lands[position],Toast.LENGTH_SHORT).show();
        y=position;
    }

    public void click(View view) {
        if (y!=60){
            Intent si = new Intent (this,Main2Activity.class);
            si.putExtra("position",y);
            startActivity(si);
        }
    }
}
