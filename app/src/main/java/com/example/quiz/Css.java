package com.example.quiz;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Css extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    private ListView list;
    TextView t1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.css);
        getIntent();
        t1=(TextView)findViewById(R.id.t1);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        r4=(RadioButton)findViewById(R.id.r4);
        list=findViewById(R.id.list);
    }
    public void startAlert(View view) {
        int i = 60;
        Intent intent = new Intent(this,
                MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 23432, intent,
                0);
        AlarmManager alarmManager = (AlarmManager)
                getSystemService(ALARM_SERVICE);
        assert alarmManager != null;
        alarmManager.set(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis()+ (i * 1000),
                pendingIntent);
        Toast.makeText(this, "Quiz end in " + i+
                "seconds",Toast.LENGTH_LONG).show();

        String[] question={"1)If we want define style for an unique element, then which css selector will we use ?","2)If we don't want to allow a floating div to the left side of an element, which css property will we use ?",
                "3)Suppose we want to arragnge five nos. of DIVs so that DIV4 is placed above DIV1. Now, which css property will we use to control the order of stack?","4)If we want to wrap a block of text around an image, which css property will we use ?",
                "5)If we want to show an Arrow as cursor, then which value we will use ?"};
        String[] a={"Id","margin","d-index","wrap","pointer"};
        String[] b={"Text","padding","z-index","push","default"};
        String[] c={"class","float","x-index","float"," arrow"};
        String[] d={"name","clear","s-index","align","arr"};
        String[] answer={"Id","clear","z-index","float","default"};
        Cssq adapter=new Cssq(Css.this,question,a,b,c,d,answer);
        list.setAdapter(adapter);

    }
}
