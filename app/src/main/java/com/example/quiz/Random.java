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

public class Random extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    private ListView list;
    TextView t1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random);
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

        String[] question={"1)Which of the following is an invalid statement?","2) What is the maximum possible length of an identifier?",
                "3) Which statement is correct....??","4) print(chr(ord('b')+1))","5) The format function, when applied on a string returns :",
                "6)The binary equivalent of 50 is,","7)Which standard library function can return a pointer to the last occurrence of a character in a string?",
                "8)To print a float value which format specifier can be used?","9)How many main() function we can have in our project?","10)What is sizeof() in C?",
                "11)If we want define style for an unique element, then which css selector will we use ?","12)If we don't want to allow a floating div to the left side of an element, which css property will we use ?",
                "13)Suppose we want to arragnge five nos. of DIVs so that DIV4 is placed above DIV1. Now, which css property will we use to control the order of stack?","14)If we want to wrap a block of text around an image, which css property will we use ?",
                "15)If we want to show an Arrow as cursor, then which value we will use ?","16) Which of the following option leads to the portability and security of Java?","17) Which of the following is not a Java features?",
                "18) The \\u0021 article referred to as a","19) _____ is used to find and fix bugs in the Java programs.","20) Which of the following is a valid declaration of a char?"};
        String[] a={"abc = 1,000,000","32 characters","List is mutable && Tuple is immutable","b","list","110010","stchar()","%f","1","Operator","Id","margin","d-index","wrap","pointer",
                "Bytecode is executed by JVM","Dynamic","Unicode escape sequence","JVM","char ch = '\\utea';"};
        String[] b={"a b c = 1000 2000 3000","63 characters","List is immutable && Tuple is mutable","syntax error","bool","1010110","strrchr()","%lf","2","Function","Text","padding","z-index","push","default",
                "The applet makes the Java code secure and portable","Architecture Neutral","Octal escape","JRE","char ca = 'tea';"};
        String[] c={"a,b,c = 1000, 2000, 3000","79 characters","Both are Immutable","c","int","101","strchar() & stchar()","%Lf","No Limit"," Macro","class","float","x-index","float"," arrow",
                "Use of exception handling","Use of pointers","Hexadecimal","JDK","char cr = \\u0223;"};
        String[] d={"a_b_c = 1,000,000","None of the above","Both are mutable","b+1","str","101.011.00.00","strrchar()","None of the above","Depends on Compiler","None of these","name","clear","s-index","align","arr",
                "Dynamic binding between objects","Object-oriented","Line feed","JDB","char cc = '\\itea';"};
        String[] answer={"a b c = 1000 2000 3000","None of the above","List is mutable && Tuple is immutable","c","str","110010","strrchr()","%f","1","Operator","Id","clear","z-index","float","default",
                "Bytecode is executed by the JVM","Use of pointers","Unicode escape sequence","JDB","char ch = '\\utea';"};
        Randomq adapter=new Randomq(Random.this,question,a,b,c,d,answer);
        list.setAdapter(adapter);

    }
}
