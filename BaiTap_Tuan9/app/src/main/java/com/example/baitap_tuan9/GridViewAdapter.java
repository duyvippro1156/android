package com.example.baitap_tuan9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class GridViewAdapter extends ArrayAdapter<ListViewBean> {

    public GridViewAdapter(@NonNull Context context, int resource, @NonNull List<ListViewBean> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (null == v){
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.grid_item, null);
        }
        ListViewBean product = getItem(position);
        ImageView img = (ImageView) v.findViewById(R.id.im_test);
        TextView txtTitle = (TextView) v.findViewById(R.id.tv_langName);

        img.setImageResource(product.getImage());
        txtTitle.setText(product.getLangName());

        return v;
    }
}
