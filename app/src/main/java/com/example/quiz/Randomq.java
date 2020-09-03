package com.example.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

public class Randomq extends BaseAdapter implements ListAdapter {
    LayoutInflater layoutinflater;
    private Context context;
    private String[] question;
    private String[] a;
    private String[] b;
    private String[] c;
    private String[] d;
    private String[] answer;

    public Randomq(Random random, String[] question, String[] a, String[] b, String[] c, String[] d, String[] answer) {
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
        this.context = random;
        layoutinflater = layoutinflater.from(context);
    }
    @Override
    public int getCount() {
        return question.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView= layoutinflater.inflate(R.layout.questions,null);
        TextView t1=convertView.findViewById(R.id.t1);
        final TextView text2=convertView.findViewById(R.id.text2);
        final TextView t2=convertView.findViewById(R.id.t2);
        Button b1=convertView.findViewById(R.id.b1);
        final RadioButton r1=convertView.findViewById(R.id.r1);
        RadioButton r2=convertView.findViewById(R.id.r2);
        RadioButton r3=convertView.findViewById(R.id.r3);
        RadioButton r4=convertView.findViewById(R.id.r4);
        t1.setText(question[position]);
        r1.setText(a[position]);
        r2.setText(b[position]);
        r3.setText(c[position]);
        r4.setText(d[position]);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setText(answer[position]);
            }
        });


        return convertView;
    }
}