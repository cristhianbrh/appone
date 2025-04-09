package com.example.appone.tertiarydata;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appone.R;
import com.example.appone.adapters.BasicAdapter;
import com.example.appone.clases.Color;
import com.example.appone.clases.Contact;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.BasicViewHolder>  {

    private List<Color> colorList;

    public ColorAdapter(List<Color> colorList) {
        this.colorList = colorList;
    }

    @NonNull
    @Override
    public BasicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_color, parent, false);
        return new ColorAdapter.BasicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasicViewHolder holder, int position) {
        TextView txt_name =  holder.itemView.findViewById(R.id.txt_name);
        TextView txt_colorhex =  holder.itemView.findViewById(R.id.txt_colorhex);
        View view_color = holder.itemView.findViewById(R.id.view_color);
        Color color = colorList.get(position);
        txt_name.setText(color.getNameColor());
        txt_colorhex.setText(color.getHex());

        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setColor(android.graphics.Color.parseColor(color.getHex()));
        drawable.setSize(200, 200);

        view_color.setBackground(drawable);
    }

    @Override
    public int getItemCount() {
        return this.colorList.size();
    }

    public class BasicViewHolder extends RecyclerView.ViewHolder{
        public BasicViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
