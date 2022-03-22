package com.example.byciclestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Layout2Activity extends AppCompatActivity implements View.OnClickListener {

    private GridView gridView;
    private ArrayList<Shoe> shoesList, tempList;
    private ShoesAdapter shoesAdapter;
    private Button btnBoy, btnGirl, btnAll;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);
        context = this;
        gridView = findViewById(R.id.gview);

        shoesList = new ArrayList<>();
        shoesList.add(new Shoe("Nike SOS", R.drawable.giay2, 700, "Boy"));
        shoesList.add(new Shoe("Nylon", R.drawable.giay3, 700, "Boy"));
        shoesList.add(new Shoe("Addidas", R.drawable.giay4, 350, "Boy"));
        shoesList.add(new Shoe("Red One", R.drawable.giay5, 650, "Boy"));
        shoesList.add(new Shoe("ABC", R.drawable.giay6, 750, "Boy"));
        shoesList.add(new Shoe("ABD", R.drawable.giay7, 600, "Girl"));
        shoesList.add(new Shoe("Nike SOS", R.drawable.giay6, 700, "Girl"));

        shoesAdapter = new ShoesAdapter(this, R.layout.item, shoesList);
        gridView.setAdapter(shoesAdapter);



        btnBoy = findViewById(R.id.btnBoy);
        btnGirl = findViewById(R.id.btnBoy2);
        btnAll = findViewById(R.id.btnBoy3);
        btnAll.setBackgroundColor(Color.parseColor("#FF03A9F4"));
        btnAll.setOnClickListener(this);
        btnGirl.setOnClickListener(this);
        btnBoy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBoy:
                showShoe("Boy");
                setFocus(2);
                break;
            case R.id.btnBoy2:
                showShoe("Girl");
                setFocus(3);
                break;
            case R.id.btnBoy3:
                showShoe("All");
                setFocus(1);
                break;
            default:
                Toast.makeText(this, "coming soon!", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void showShoe(String type) {
        tempList = new ArrayList<>();
        if (type.equals("All"))
            tempList = shoesList;
        else {
            for (Shoe s : shoesList) {
                if (s.getType().equals(type))
                    tempList.add(s);
            }
        }
        shoesAdapter = new ShoesAdapter(context, R.layout.item, tempList);
        gridView.setAdapter(shoesAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "123", Toast.LENGTH_LONG).show();
            }
        });
        shoesAdapter.notifyDataSetChanged();
    }

    private void setFocus(int i) {
        btnAll.setBackgroundColor(Color.WHITE);
        btnBoy.setBackgroundColor(Color.WHITE);
        btnGirl.setBackgroundColor(Color.WHITE);
        switch (i) {
            case 1:
                btnAll.setBackgroundColor(Color.parseColor("#FF03A9F4"));
                break;
            case 2:
                btnBoy.setBackgroundColor(Color.parseColor("#FF03A9F4"));
                break;
            case 3:
                btnGirl.setBackgroundColor(Color.parseColor("#FF03A9F4"));
                break;

        }
    }

}