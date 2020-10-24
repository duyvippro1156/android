package com.example.tuan9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public abstract class ListViewBaseAdapterMess extends BaseAdapter {
    public ArrayList<ListViewBeanMess> arrayListListener;
    private List<ListViewBeanMess> mListenerList;
    Context mContext;

    public ListViewBaseAdapterMess(List<ListViewBeanMess> mListenerList, Context context){
        mContext = context;
        this.mListenerList = mListenerList;
        this.arrayListListener = new ArrayList<ListViewBeanMess>();
        this.arrayListListener.addAll(mListenerList);
    }
    public class ViewHolder{
        ImageView mItemPic;
        TextView mLangName;
        TextView mMess;
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
            view = LayoutInflater.from(mContext).inflate(R.layout.listview_item, null);
            holder = new ViewHolder();
            holder.mItemPic = (ImageView) view.findViewById(R.id.im_test);
            holder.mLangName = (TextView) view.findViewById(R.id.tv_langName);
            holder.mMess = (TextView) view.findViewById(R.id.tv_mess);

            CheckBox checkBox = view.findViewById(R.id.checkBox);
            checkBox.setTag(position);
            if (ActivityMess.isActionMode){
                checkBox.setVisibility(View.VISIBLE);
            }
            else {
                checkBox.setVisibility(View.GONE);
            }
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    int position = (int)compoundButton.getTag();
                    if(ActivityMess.UserSelection.contains(arrayListListener.get(position))){
                        ActivityMess.UserSelection.remove(arrayListListener.get(position));
                    }
                    else {
                        ActivityMess.UserSelection.add(arrayListListener.get(position));
                    }
                    ActivityMess.actionMode.setTitle(ActivityMess.UserSelection.size()+ " items selecter...");
                }
            });
            view.setTag(holder);
        try{
            int image = mListenerList.get(position).getImage();
            holder.mItemPic.setImageResource(image);
            holder.mLangName.setText(mListenerList.get(position).getLangName());
            holder.mMess.setText(mListenerList.get(position).getMess());
        } catch (Exception ẽx){

        }
        return view;
    }
}
