package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listview);
        arr_bean = new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.android, "Android", 33));
        arr_bean.add(new ListViewBean(R.drawable.java, "Java",49));
        arr_bean.add(new ListViewBean(R.drawable.php, "PHP",26));
        arr_bean.add(new ListViewBean(R.drawable.python, "Python",31));
        adapter = new ListViewBaseAdapter(arr_bean, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv.setAdapter(adapter);
    }
}