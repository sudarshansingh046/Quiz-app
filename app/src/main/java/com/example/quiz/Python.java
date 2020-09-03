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

public class Python extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    private ListView list;
    TextView t1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.python);
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
                "3) Which statement is correct....??","4) print(chr(ord('b')+1))","5) The format function, when applied on a string returns :"};
        String[] a={"abc = 1,000,000","32 characters","List is mutable && Tuple is immutable","b","list"};
        String[] b={"a b c = 1000 2000 3000","63 characters","List is immutable && Tuple is mutable","syntax error","bool"};
        String[] c={"a,b,c = 1000, 2000, 3000","79 characters","Both are Immutable","c","int"};
        String[] d={"a_b_c = 1,000,000","None of the above","Both are mutable","b+1","str"};
        String[] answer={"a b c = 1000 2000 3000","None of the above","List is mutable && Tuple is immutable","c","str"};
        pythonq adapter=new pythonq(Python.this,question,a,b,c,d,answer);
        list.setAdapter(adapter);

    }
}