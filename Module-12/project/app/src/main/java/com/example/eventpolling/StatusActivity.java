package com.example.eventpolling;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class StatusActivity extends AppCompatActivity {
    Button logoutbutton;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    TextView tv9;
    TextView tv10;
    TextView tv11;
    TextView tv12;
    PieChartView pieChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
//        pieChartView = findViewById(R.id.chart);
//        List<SliceValue> pieData = new ArrayList<>();
//        pieData.add(new SliceValue(12, Color.BLUE));
//        pieData.add(new SliceValue(25, Color.GRAY));
//        pieData.add(new SliceValue(10, Color.RED));
//        pieData.add(new SliceValue(60, Color.MAGENTA));
//        PieChartData pieChartData = new PieChartData(pieData);
//        pieChartView.setPieChartData(pieChartData);
        tv1 = ((TextView)findViewById(R.id.textView11));
        tv1.setText(getIntent().getStringExtra("pubgcount"));


        tv2 = ((TextView)findViewById(R.id.textView12));
        tv2.setText(getIntent().getStringExtra("fifacount"));

        tv3 = ((TextView)findViewById(R.id.textView13));
        tv3.setText(getIntent().getStringExtra("minicount"));

        tv4 = ((TextView)findViewById(R.id.textView14));
        tv4.setText(getIntent().getStringExtra("csgocount"));

        tv5 = ((TextView)findViewById(R.id.textView21));
        tv5.setText(getIntent().getStringExtra("rollscount"));

        tv6 = ((TextView)findViewById(R.id.textView22));
        tv6.setText(getIntent().getStringExtra("desertscount"));

        tv7 = ((TextView)findViewById(R.id.textView23));
        tv7.setText(getIntent().getStringExtra("burgercount"));

        tv8 = ((TextView)findViewById(R.id.textView24));
        tv8.setText(getIntent().getStringExtra("pizzacount"));

        tv9 = ((TextView)findViewById(R.id.textView31));
        tv9.setText(getIntent().getStringExtra("dancecount"));

        tv10 = ((TextView)findViewById(R.id.textView32));
        tv10.setText(getIntent().getStringExtra("songcount"));

        tv11 = ((TextView)findViewById(R.id.textView33));
        tv11.setText(getIntent().getStringExtra("comedycount"));

        tv12 = ((TextView)findViewById(R.id.textView34));
        tv12.setText(getIntent().getStringExtra("djcount"));




//        int intValue = mIntent.getIntExtra("pubgcount", 0);
        logoutbutton = (Button) findViewById(R.id.logout_button);
        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        }) ;
    }
    public void openActivity() {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
