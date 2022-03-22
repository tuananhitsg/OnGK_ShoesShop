    package com.example.byciclestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

    public class Layout3Activity extends AppCompatActivity {

    private ImageView img;
    private TextView tvName;
    private TextView tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3);

        Intent intent = getIntent();
        Shoe shoe = (Shoe) intent.getSerializableExtra("shoe");

        img = findViewById(R.id.imgItem);
        tvName = findViewById(R.id.txtNameItem);
        tvPrice = findViewById(R.id.txtPriceItem);

        img.setImageResource(shoe.getImg());
        tvName.setText(shoe.getName());
        DecimalFormat df = new DecimalFormat("$#,###");
        tvPrice.setText(df.format(shoe.getPrice()));
    }
}