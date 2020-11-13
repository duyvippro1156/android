package com.example.ktralan2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public abstract class ListViewBaseAdapter extends BaseAdapter {
    public ArrayList<com.example.ktralan2.ListViewBean> arrayListListener;
    private List<com.example.ktralan2.ListViewBean> mListenerList;
    Context mContext;

    public ListViewBaseAdapter(List<com.example.ktralan2.ListViewBean> mListenerList, Context context){
        mContext = context;
        this.mListenerList = mListenerList;
        this.arrayListListener = new ArrayList<com.example.ktralan2.ListViewBean>();
        this.arrayListListener.addAll(mListenerList);
    }
    public class ViewHolder{
        ImageView mItemPic;
        TextView mLangName;
    }
    @Override
    public int getCount(){
        return mListenerList.size();
    }
    @Override
    public Object getItem(int position){
        return position;
    }
    @Override
    public View getView(final int position, View view, ViewGroup parent){
        final ViewHolder holder;
        if (view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.mItemPic = (ImageView) view.findViewById(R.id.im_test);
            holder.mLangName = (TextView) view.findViewById(R.id.tv_langName);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        try{
            int image = mListenerList.get(position).getImage();
            holder.mItemPic.setImageResource(image);
            holder.mLangName.setText(mListenerList.get(position).getLangName());
        } catch (Exception ẽx){

        }
        return view;
    }
}

