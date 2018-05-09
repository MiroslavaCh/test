package com.example.contacts;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Contact> contacts;
    static DBContacts dbContacts;
    FloatingActionButton floatingActionButton;
    static RVAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                startActivityForResult(i, 0);
            }
        });

        dbContacts = new DBContacts(getApplicationContext());
        contacts = dbContacts.selectAll();
        ;
        rvAdapter = new RVAdapter(getApplicationContext(), contacts);

        recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(rvAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            String phone = data.getStringExtra("phone");
            String birthday = data.getStringExtra("birthday");
            dbContacts.insert(name, phone, birthday);
            updateRecycler();
        }
    }

    static void updateRecycler() {
        rvAdapter.setContacts(dbContacts.selectAll());
        rvAdapter.notifyDataSetChanged();
    }

    static void update(long id, String name, String phone, String birthday) {
        Contact contact = new Contact(id, name, phone, birthday);
        dbContacts.update(contact);
        updateRecycler();
    }

    static void delete(long id) {
        dbContacts.delete(id);
        rvAdapter.setContacts(dbContacts.selectAll());
        rvAdapter.notifyDataSetChanged();
    }
}
