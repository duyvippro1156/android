package com.example.ktralan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import androidx.appcompat.app.AlertDialog;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ImageView iv;
    final Context context = this;
    ListView lv;
    GridView gv;
    GridViewAdapter gridViewAdapter;
    ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean;

    int idd=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lv = (ListView) findViewById(R.id.listview);
        gv = (GridView) findViewById(R.id.mygridview);
        arr_bean = new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.android,"Android"));
        arr_bean.add(new ListViewBean(R.drawable.java,"Java"));
        arr_bean.add(new ListViewBean(R.drawable.php,"PHP"));
        arr_bean.add(new ListViewBean(R.drawable.python,"Python"));
        //adapter = new ListViewBaseAdapter(arr_bean, this) {
        gridViewAdapter = new GridViewAdapter(this, R.id.mygridview, arr_bean) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        //lv.setAdapter(adapter);
        gv.setAdapter(gridViewAdapter);

        //ListView Lv = findViewById(R.id.listview);
        GridView Lv = findViewById(R.id.mygridview);

        //lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        gv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                idd=position;
                return false;
            }

        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), arr_bean.get(i).getLangName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ProductDetails.class);
                intent.putExtra("name",arr_bean.get(i).getLangName());
                intent.putExtra("image",arr_bean.get(i).getImage());
                startActivity(intent);
            }
        });



        registerForContextMenu(Lv);



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
            case R.id.xoa:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                alertDialogBuilder.setTitle("Xác nhận");
                alertDialogBuilder.setMessage("Bạn có đồng ý Xóa không?");
                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Delete",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                        arr_bean.remove(idd);
                                        idd=-1;
                                        //adapter.notifyDataSetChanged();
                                        gridViewAdapter.notifyDataSetChanged();
                                        Toast.makeText(MainActivity.this,"Delete success",Toast.LENGTH_LONG).show();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}