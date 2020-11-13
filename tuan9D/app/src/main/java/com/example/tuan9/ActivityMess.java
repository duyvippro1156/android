package com.example.tuan9;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ActivityMess extends AppCompatActivity {
    ListView lv;
    ListViewBaseAdapterMess adapter;
    ArrayList<ListViewBeanMess> arr;

    public static boolean isActionMode = false;
    public static List<ListViewBeanMess> UserSelection = new ArrayList<ListViewBeanMess>();
    public static ActionMode actionMode = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess);

        AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context_menu_2, menu);
                isActionMode = true;
                actionMode  = mode;
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                isActionMode = false;
                actionMode = null;
                UserSelection.clear();
            }
        };

        lv = (ListView) findViewById(R.id.listviewMess);
        lv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        lv.setMultiChoiceModeListener(modeListener);

        arr = new ArrayList<ListViewBeanMess>();
        arr.add(new ListViewBeanMess(R.drawable.avta_2, "Lão Ruồi", "Tranh tớ vẽ nè!"));
        arr.add(new ListViewBeanMess(R.drawable.avta_3, "Trang Nguyễn", "Hello bea"));
        arr.add(new ListViewBeanMess(R.drawable.avta_4, "No Nguyễn", "Hey man!"));
        arr.add(new ListViewBeanMess(R.drawable.avta_5, "Duy Mai", "I'm loser"));
        arr.add(new ListViewBeanMess(R.drawable.avta_6, "Biu", "Các bạn hiện đã được kết nối..."));
        arr.add(new ListViewBeanMess(R.drawable.avta_nam, "Mai Duy", "Các bạn hiện đã được kết nối..."));
        adapter = new ListViewBaseAdapterMess(arr, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv.setAdapter(adapter);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nv);

        bottomNavigationView.setSelectedItemId(R.id.about);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.about:
                        return;
                    case R.id.home_ac:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
    }

}
