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

/**
 * @author Liem Buchuk
 * @since 15.10.19
 * On this activity the user needs to chose one continent out of 5, with the ability to change his choice.
 * The chosen one will pop as a Toast.
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] lands = {"Asia", "Europe", "Africa", "South America", "North America"};
    ListView lv;
    int y=-1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        /**
         * connenting an adaptar to the string array
         */
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, lands);
        lv.setAdapter(adp);



    }

    @Override
    /**
     * Showing a Toast with the chosen continent and saving the choice number in 'y'.
     */
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "" +lands[position],Toast.LENGTH_SHORT).show();
        y=position;
    }

    public void click(View view) {
        /**
         * when the Button is clicked,
         * if the user chose a continent this sends him to Main2Activity with the continent that he chose.
         * if the user did not choose any continent a Toast will be shown telling him to chose one.
         */
        if (y==-1){
            Toast toast2;
            toast2 =Toast.makeText(this, "please choose",Toast.LENGTH_SHORT);
            toast2.show();
        }
        else{
            Intent si = new Intent (this,Main2Activity.class);
            si.putExtra("position",y);
            startActivity(si);
        }
    }
}
