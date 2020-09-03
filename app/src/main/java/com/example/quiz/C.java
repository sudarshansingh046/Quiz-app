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

public class C extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    private ListView list;
    TextView t1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c);
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

        String[] question={"1)The binary equivalent of 50 is,","2)Which standard library function can return a pointer to the last occurrence of a character in a string?",
                "3)To print a float value which format specifier can be used?","4)How many main() function we can have in our project?","5)What is sizeof() in C?"};
        String[] a={"110010","stchar()","%f","1","Operator"};
        String[] b={"1010110","strrchr()","%lf","2","Function"};
        String[] c={"101","strchar() & stchar()","%Lf","No Limit"," Macro"};
        String[] d={"101.011.00.00","strrchar()","None of the above","Depends on Compiler","None of these"};
        String[] answer={"110010","strrchr()","%f","1","Operator"};
        Cq adapter=new Cq(C.this,question,a,b,c,d,answer);
        list.setAdapter(adapter);

    }
}