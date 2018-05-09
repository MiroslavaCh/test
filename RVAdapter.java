package com.example.contacts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ContactViewHolder> {

    Context context;
    List<Contact> contacts;

    public RVAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_content, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        final Contact contact = contacts.get(position);

        holder.textViewName.setText(contact.getName());
        holder.textViewPhone.setText(contact.getPhone());
        holder.textViewBirthday.setText(contact.getBirthday());
        holder.setContact(contact);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CardView cardView;
        TextView textViewName, textViewPhone, textViewBirthday;
        Contact contact;

        public ContactViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cv_rv);

            textViewName = itemView.findViewById(R.id.tv_name);
            textViewPhone = itemView.findViewById(R.id.tv_phone);
            textViewBirthday = itemView.findViewById(R.id.tv_birthday);

            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, Main2Activity.class);
            i.putExtra("id", contact.getId());
            i.putExtra("name", contact.getName());
            i.putExtra("phone", contact.getPhone());
            i.putExtra("birthday", contact.getBirthday());
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

        void setContact(Contact contact) {
            this.contact = contact;
        }

    }
}
