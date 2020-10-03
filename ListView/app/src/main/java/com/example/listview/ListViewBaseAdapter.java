package com.example.listview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ListViewBaseAdapter extends BaseAdapter {
    public ArrayList<ListViewBean> arrayListListener;
    private List<ListViewBean> mListenerList;
    Context mContext;

    public ListViewBaseAdapter(List<ListViewBean> mListenerList, Context context){
        mContext = context;
        this.mListenerList = mListenerList;
        this.arrayListListener = new ArrayList<ListViewBean>();
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
        } catch (Exception e){

        }
        return view;
    }
}
