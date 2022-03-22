package com.example.byciclestore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class ShoesAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Shoe> shoesList;

    public ShoesAdapter(Context context, int idLayout, List<Shoe> shoesList) {
        this.context = context;
        this.idLayout = idLayout;
        this.shoesList = shoesList;
    }

    @Override
    public int getCount() {
        if (shoesList.size() != 0 && !shoesList.isEmpty())
            return shoesList.size();
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
        }

        TextView tvName = view.findViewById(R.id.txtName);
        TextView tvPrice = view.findViewById(R.id.txtPrice);
        ImageView imageView = view.findViewById(R.id.imageView4b);
        DecimalFormat df = new DecimalFormat("$#,###");

        final Shoe shoe = shoesList.get(i);

        if (shoesList.size() != 0 && !shoesList.isEmpty()) {
            imageView.setImageResource(shoe.getImg());
            tvName.setText(shoe.getName());
            tvPrice.setText(df.format(shoe.getPrice()));
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Layout3Activity.class);
                intent.putExtra("shoe",shoe);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
