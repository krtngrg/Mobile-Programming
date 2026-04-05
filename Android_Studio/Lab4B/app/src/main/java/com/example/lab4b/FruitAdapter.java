package com.example.lab4b;

import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.List;

public class FruitAdapter extends ArrayAdapter<String> {

    Context context;
    String[] fruits;
    int[] images;

    public FruitAdapter(Context context, String[] fruits, int[] images) {
        super(context, R.layout.list_item, fruits);
        this.context = context;
        this.fruits = fruits;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);

        ImageView img = view.findViewById(R.id.imgFruit);
        TextView tv = view.findViewById(R.id.tvFruit);

        img.setImageResource(images[position]);
        tv.setText(fruits[position]);

        return view;
    }
}
