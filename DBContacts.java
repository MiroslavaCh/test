package com.example.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.contacts.OpenHelper.TABLE_NAME;
import static com.example.contacts.OpenHelper.COLUMN_ID;
import static com.example.contacts.OpenHelper.COLUMN_NAME;
import static com.example.contacts.OpenHelper.COLUMN_PHONE;
import static com.example.contacts.OpenHelper.COLUMN_BIRTHDAY;
import static com.example.contacts.OpenHelper.NUM_COLUMN_ID;
import static com.example.contacts.OpenHelper.NUM_COLUMN_NAME;
import static com.example.contacts.OpenHelper.NUM_COLUMN_PHONE;
import static com.example.contacts.OpenHelper.NUM_COLUMN_BIRTHDAY;

public class DBContacts {

    private SQLiteDatabase sqLiteDatabase;

    public DBContacts(Context context) {
        OpenHelper openHelper = new OpenHelper(context);
        sqLiteDatabase = openHelper.getWritableDatabase();
    }

    public long insert(String name, String phone, String birthday) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_PHONE, phone);
        contentValues.put(COLUMN_BIRTHDAY, birthday);
        return sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public int update(Contact contact) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, contact.getName());
        contentValues.put(COLUMN_PHONE, contact.getPhone());
        contentValues.put(COLUMN_BIRTHDAY, contact.getBirthday());
        return sqLiteDatabase.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?"
                , new String[]{String.valueOf(contact.getId())});
    }

    public void deleteAll() {
        sqLiteDatabase.delete(TABLE_NAME, null, null);
    }

    public void delete(long id) {
        sqLiteDatabase.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public Contact select(long id) {
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null);

        cursor.moveToFirst();
        String name = cursor.getString(NUM_COLUMN_NAME);
        String phone = cursor.getString(NUM_COLUMN_PHONE);
        String birthday = cursor.getString(NUM_COLUMN_BIRTHDAY);
        cursor.close();
        return new Contact(id, name, phone, birthday);
    }

    public List<Contact> selectAll() {
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null,
                null, null, null);

        List<Contact> contacts = new ArrayList<>();
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                long id = cursor.getLong(NUM_COLUMN_ID);
                String name = cursor.getString(NUM_COLUMN_NAME);
                String phone = cursor.getString(NUM_COLUMN_PHONE);
                String birthday = cursor.getString(NUM_COLUMN_BIRTHDAY);
                contacts.add(new Contact(id, name, phone, birthday));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contacts;
    }

}
