package com.example.myapplication.ui.Simptome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class ContactsAdapter extends
        RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.format_pacient, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        TextView textView2 = holder.nameTextView2;
        TextView textView3 = holder.nameTextView3;
        TextView textView4 = holder.nameTextView4;
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, nameTextView2, nameTextView3, nameTextView4;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.txtNumePrenume1);
            nameTextView2 = itemView.findViewById(R.id.txtCNP2);
            nameTextView3 = itemView.findViewById(R.id.txtDataNasterii3);
            nameTextView4 = itemView.findViewById(R.id.txtAdresa4);
        }
    }
    private List<Contact> mContacts;

    public ContactsAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }
}