package com.example.quiz;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Javaq extends BaseAdapter implements ListAdapter {
    LayoutInflater layoutinflater;
    private Context context;
    private String[] question;
    private String[] a;
    private String[] b;
    private String[] c;
    private String[] d;
    private String[] answer;
    public Javaq(Java java, String[] question, String[] a, String[] b, String[] c, String[] d,String[] answer) {
        this.question=question;
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.answer=answer;
        this.context=java;
        layoutinflater= layoutinflater.from(context);
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
        final RadioButton r2=convertView.findViewById(R.id.r2);
        final RadioButton r3=convertView.findViewById(R.id.r3);
        final RadioButton r4=convertView.findViewById(R.id.r4);
        final RadioGroup rg=convertView.findViewById(R.id.rg);
        t1.setText(question[position]);
        r1.setText(a[position]);
        r2.setText(b[position]);
        r3.setText(c[position]);
        r4.setText(d[position]);


        final View finalConvertView = convertView;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setText(answer[position]);
                int count=0;

                if ((position == 0) &&  (r1.isChecked())) {

                        count++;
                        t2.setText("right answer");
                        finalConvertView.setBackgroundColor(Color.GREEN);
                    }

                    else if ((position == 1) &&(r3.isChecked())){

                        count++;
                        t2.setText("right answer");
                        finalConvertView.setBackgroundColor(Color.GREEN);
                    }
                    else if ((position == 2)&&(r1.isChecked())) {

                        count++;
                        t2.setText("right answer");
                        finalConvertView.setBackgroundColor(Color.GREEN);
                    }
                    else if ((position == 3)&&(r4.isChecked())) {

                        count++;
                        t2.setText("right answer");
                        finalConvertView.setBackgroundColor(Color.GREEN);
                    }
                    else if ((position == 4) &&(r1.isChecked())) {

                        count++;
                        t2.setText("right answer");
                        finalConvertView.setBackgroundColor(Color.GREEN);
                    }

                else if((r1.isChecked()==false)&&(r2.isChecked()==false)&&(r3.isChecked()==false)&&(r4.isChecked()==false))
                {
                    t2.setText("wrong answer");
                    finalConvertView.setBackgroundColor(Color.YELLOW);
                }
                else
                {
                    t2.setText("wrong answer");
                    finalConvertView.setBackgroundColor(Color.RED);
                }
            }
        });
        return convertView;
    }

}
