package com.example.tuan9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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
        arr_bean.add(new ListViewBean(R.drawable.android,"Android"));
        arr_bean.add(new ListViewBean(R.drawable.java,"Java"));
        arr_bean.add(new ListViewBean(R.drawable.php,"PHP"));
        arr_bean.add(new ListViewBean(R.drawable.python,"Python"));
        adapter = new ListViewBaseAdapter(arr_bean, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv.setAdapter(adapter);

        ListView Lv = findViewById(R.id.listview);

        registerForContextMenu(Lv);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nv);

        bottomNavigationView.setSelectedItemId(R.id.home_ac);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home_ac:
                        return;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), ActivityMess.class));
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo){
        super.onCreateContextMenu(menu, v, menuinfo);
        menu.setHeaderTitle("Chose your option");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.op1:
                Toast.makeText(this, "Thêm Mới", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.op2:
                Toast.makeText(this, "Sửa Đổi", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.op3:
                Toast.makeText(this, "Xóa", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}