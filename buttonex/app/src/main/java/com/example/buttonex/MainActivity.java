package com.example.buttonex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ed1, ed2;
    private Button btAdd;
    private Spinner spOperator;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btAdd.setOnClickListener(this);
//        btAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    double n1 = Double.parseDouble(ed1.getText().toString());
//                    double n2 = Double.parseDouble(ed2.getText().toString());
//                    String st = "Result:" + (n1 + n2);
//                    txt.setText(st);
//                } catch (NumberFormatException e) {
//                    System.out.println(e);
//                }
//            }
//        });
//        spOperator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                try {
//                    double n1 = Double.parseDouble(ed1.getText().toString());
//                    double n2 = Double.parseDouble(ed2.getText().toString());
//                    String op = spOperator.getSelectedItem().toString();
//                    String rs = cal(n1, n2, op);
//                    txt.setText(rs);
//                } catch (NumberFormatException e) {
//                    System.out.println(e);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
    }

    private String cal(double n1, double n2, String op) {
        String rs = "";
        switch (op) {
            case "+":
                rs = "Sum:" + (n1 + n2);
                break;
            case "-":
                rs = "Sub:" + (n1 - n2);
                break;
            case "*":
                rs = "Multy:" + (n1 * n2);
                break;
            case ":":
                if (n2 == 0)
                    rs = "not divide by zero";
                else
                    rs = "Divide:" + (n1 / n2);
                break;
        }
        return rs;
    }


    private void initView() {
        ed1=findViewById(R.id.n1);
        ed2=findViewById(R.id.n2);
        btAdd=findViewById(R.id.bt);
        spOperator=findViewById(R.id.sp);
        txt=findViewById(R.id.result);
        String[] st={"+","-","*",":"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.myspinner,st);
        adapter.setDropDownViewResource(R.layout.myspinner);
        spOperator.setAdapter(adapter);
    }
    @Override
    public void onClick(View v){
        if(v==btAdd){
            try {
                double n1 = Double.parseDouble(ed1.getText().toString());
                double n2 = Double.parseDouble(ed2.getText().toString());
                String op = spOperator.getSelectedItem().toString();
                String rs = cal(n1, n2, op);
                txt.setText(rs);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
    }
}