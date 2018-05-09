package com.example.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    EditText name, phone, birthday;
    Button ok, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("Добавление контакта");

        name = findViewById(R.id.et_name);
        phone = findViewById(R.id.et_phone);
        birthday = findViewById(R.id.et_birthday);

        ok = findViewById(R.id.btn_ok);
        cancel = findViewById(R.id.btn_cancel);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()) {
                    name.setError("Заполните поле");
                    return;
                }
                if (phone.getText().toString().isEmpty()) {
                    phone.setError("Заполните поле");
                    return;
                }
                Intent i = new Intent();
                i.putExtra("name", name.getText().toString());
                i.putExtra("phone", phone.getText().toString());
                i.putExtra("birthday", birthday.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
