package com.example.appone.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appone.R;
import com.example.appone.clases.Contact;

import java.util.List;

public class BasicAdapter extends RecyclerView.Adapter<BasicAdapter.BasicViewHolder> {
    private List<Contact> data;
    public BasicAdapter(List<Contact> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @NonNull
    @Override
    public BasicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_basic, parent, false);
        return new BasicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasicViewHolder holder, int position) {
        TextView txt_fullname =  holder.itemView.findViewById(R.id.txt_fullname);
        TextView txt_phone =  holder.itemView.findViewById(R.id.txt_phone);
        Contact contact = data.get(position);
        txt_fullname.setText(contact.getFullName());
        txt_phone.setText(contact.getPhone());
    }

    public class BasicViewHolder extends RecyclerView.ViewHolder{
        public BasicViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
