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

public class Java extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    private ListView list;
    TextView t1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java);
        getIntent();
        t1=(TextView)findViewById(R.id.t1);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        r4=(RadioButton)findViewById(R.id.r4);
        list=findViewById(R.id.list);


    }
    public void startAlert(View view) {
        int i =60;
        Intent intent = new Intent(this,
                MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 0, intent,
                0);
        AlarmManager alarmManager = (AlarmManager)
                getSystemService(ALARM_SERVICE);
        assert alarmManager != null;
        alarmManager.set(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis()+ (i * 1000),
                pendingIntent);
        Toast.makeText(this, "Quiz end in " + i+
                "seconds",Toast.LENGTH_LONG).show();



        String[] question={"1) Which of the following option leads to the portability and security of Java?","2) Which of the following is not a Java features?",
                "3) The \\u0021 article referred to as a","4) _____ is used to find and fix bugs in the Java programs.","5) Which of the following is a valid declaration of a char?"};
        String[] a={"Bytecode is executed by JVM","Dynamic","Unicode escape sequence","JVM","char ch = '\\utea';"};
        String[] b={"The applet makes the Java code secure and portable","Architecture Neutral","Octal escape","JRE","char ca = 'tea';"};
        String[] c={"Use of exception handling","Use of pointers","Hexadecimal","JDK","char cr = \\u0223;"};
        String[] d={"Dynamic binding between objects","Object-oriented","Line feed","JDB","char cc = '\\itea';"};
        String[] answer={"Bytecode is executed by the JVM","Use of pointers","Unicode escape sequence","JDB","char ch = '\\utea';"};

        Javaq adapter=new Javaq(Java.this,question,a,b,c,d,answer);
        list.setAdapter(adapter);
    }


}