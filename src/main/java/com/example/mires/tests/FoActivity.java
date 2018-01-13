package com.example.mires.tests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fo);
    }


    public void onClick1(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        TextView start = findViewById(R.id.textViewStartU);
        start.setVisibility(View.INVISIBLE);

        switch (view.getId()){
            case R.id.radio_ball:
                if(checked) {
                    TextView this1 = findViewById(R.id.textViewThis);
                    this1.setVisibility(View.INVISIBLE);
                    this1.setText("Летающий объект символизирует ту ложь, на которую Вы готовы. Мяч говорит о том, что в Вашей жизни мало лжи.");
                } break;
            case R.id.radio_ballon:
                if(checked) {
                    TextView this1 = findViewById(R.id.textViewThis);
                    this1.setVisibility(View.INVISIBLE);
                    this1.setText("Летающий объект символизирует ту ложь, на которую Вы готовы. Воздушный шар символизирует среднее кол-во лжи в Вашей жизни.");
                } break;
            case R.id.radio_plane:
                if(checked) {
                    TextView this1 = findViewById(R.id.textViewThis);
                    this1.setVisibility(View.INVISIBLE);
                    this1.setText("Летающий объект символизирует ту ложь, на которую Вы готовы. Самолёт говорит о большом количестве лжи в Вашей жизни.");
                } break;
            case R.id.radio_ufo:
                if(checked) {
                    TextView this1 = findViewById(R.id.textViewThis);
                    this1.setVisibility(View.INVISIBLE);
                    this1.setText("Летающий объект символизирует ту ложь, на которую Вы готовы. НЛО говорит о том, что привирая, Вы часто отрываетесь от реальности.");
                } break;
            default:
                break;
        }

        TextView textViewDied1 = findViewById(R.id.textViewDied);
        textViewDied1.setVisibility(View.VISIBLE);
        RadioGroup rg2 = findViewById(R.id.radioGroup2);
        rg2.setVisibility(View.VISIBLE);

        TextView textViewReason = findViewById(R.id.textViewReason);
        textViewReason.setVisibility(View.INVISIBLE);

        RadioGroup rg1 = findViewById(R.id.radioGroup);
        rg1.setVisibility(View.GONE);

    }

    public void onClick2(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radioYes:
                if(checked) {
                    TextView textViewDied1 = findViewById(R.id.textViewDied);
                    textViewDied1.setVisibility(View.INVISIBLE);
                    textViewDied1.setText("Наличие жертв и разрушений означает, что Вы не слишком опасаетесь последствий своего вранья.");
                } break;
            case R.id.radioNo:
                if(checked) {
                    TextView textViewDied1 = findViewById(R.id.textViewDied);
                    textViewDied1.setVisibility(View.INVISIBLE);
                    textViewDied1.setText("ОТсутствие жертв и разрушений означает, что Вы опасаетесь последствий своего вранья.");
                } break;
            default:
                break;
        }

        TextView textViewTime1 = findViewById(R.id.textViewTime);
        textViewTime1.setVisibility(View.VISIBLE);
        RadioGroup rg3 = findViewById(R.id.radioGroup3);
        rg3.setVisibility(View.VISIBLE);

        RadioGroup rg2 = findViewById(R.id.radioGroup2);
        rg2.setVisibility(View.GONE);

    }

    public void onClick3(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radio_little:
                if(checked) {
                    TextView textViewTime1 = findViewById(R.id.textViewTime);
                    textViewTime1.setVisibility(View.INVISIBLE);
                    textViewTime1.setText("Ваш выбор символизирует то, что Вы не слишком будете терзаться муками совести.");
                } break;
            case R.id.radio_long:
                if(checked) {
                    TextView textViewTime1 = findViewById(R.id.textViewTime);
                    textViewTime1.setVisibility(View.INVISIBLE);
                    textViewTime1.setText("Ваш выбор символизирует то, что Вы не сильно будете терзатьмя муками совести.");
                } break;
            case R.id.radio_quickly:
                if(checked) {
                    TextView textViewTime1 = findViewById(R.id.textViewTime);
                    textViewTime1.setVisibility(View.INVISIBLE);
                    textViewTime1.setText("Ваш выбор символизирует то, что муки совести для Вас будут крайне болезнены.");
                } break;
            default:
                break;
        }

        RadioGroup rg3 = findViewById(R.id.radioGroup3);
        rg3.setVisibility(View.GONE);
        TextView textViewReason = findViewById(R.id.textViewReason);
        textViewReason.setText("Ваша версия этого события — это те причины, которые обычно заставляют идти вас на обман.");
        textViewReason.setVisibility(View.VISIBLE);
        TextView textViewTime1 = findViewById(R.id.textViewTime);
        textViewTime1.setVisibility(View.VISIBLE);
        TextView textViewDied1 = findViewById(R.id.textViewDied);
        textViewDied1.setVisibility(View.VISIBLE);
        TextView this1 = findViewById(R.id.textViewThis);
        this1.setVisibility(View.VISIBLE);
    }
}
