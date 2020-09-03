package com.example.quiz;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.t1);
        String[] values={"JAVA","C++","PYTHON","CSS","RANDOM"};
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, values);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v,int Position,long id)
    {
        super.onListItemClick(l,v,Position,id);
        String itemvalues=(String)l.getItemAtPosition(Position);
        if(Position ==0)
        {
            Intent i=new Intent(MainActivity.this,Java.class);
            startActivity(i);
        }
        if(Position ==1)
        {
            Intent i=new Intent(MainActivity.this,C.class);
            startActivity(i);
        }
        if(Position ==2)
        {
            Intent i=new Intent(MainActivity.this,Python.class);
            startActivity(i);
        }
        if(Position ==3)
        {
            Intent i=new Intent(MainActivity.this, Css.class);
            startActivity(i);
        }
        if(Position ==4)
        {
            Intent i=new Intent(MainActivity.this, Random.class);
            startActivity(i);
        }
        Toast.makeText(this,itemvalues,Toast.LENGTH_LONG).show();
    }

}