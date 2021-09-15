package com.example.fragment2_dynamic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MyHolder extends RecyclerView.ViewHolder {
    TextView textView1;
    TextView textView2;
    ImageView imageView;
    public MyHolder(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    private void initViews() {
        textView1=itemView.findViewById(R.id.tv1);
        textView2=itemView.findViewById(R.id.tv2);
        imageView=itemView.findViewById(R.id.image);
    }
    public void setData(Example example)
    {
        textView1.setText(example.getImage());
        textView2.setText(example.getSubTitle());

        Glide.with(imageView).load(example.getImage()).into(imageView);
    }
}
