package com.example.contacts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

public class Main2Activity extends AppCompatActivity {

    EditText name, phone, birthday;
    Button ok, cancel;
    long id;
    String intentName, intentPhone, intentBirthday;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Изменение контакта");

        toolbar = findViewById(R.id.toolbar_actionbar);
//        setSupportActionBar(toolbar);

        name = findViewById(R.id.et1_name);
        phone = findViewById(R.id.et1_phone);
        birthday = findViewById(R.id.et1_birthday);

        id = getIntent().getLongExtra("id", -1);
        intentName = getIntent().getStringExtra("name");
        intentPhone = getIntent().getStringExtra("phone");
        intentBirthday = getIntent().getStringExtra("birthday");

        name.setText(intentName);
        phone.setText(intentPhone);
        birthday.setText(intentBirthday);

        ok = findViewById(R.id.btn1_ok);
        cancel = findViewById(R.id.btn1_cancel);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.update(id, name.getText().toString(), phone.getText().toString(),
                        birthday.getText().toString());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_remove) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
            builder.setTitle("Удаление контакта")
                    .setMessage("Вы действительно хотите удалить данный контакт?")
                    .setCancelable(true)
                    .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.delete(id);
                            setResult(RESULT_CANCELED);
                            finish();
                        }
                    })
                    .setNegativeButton("Нет",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
