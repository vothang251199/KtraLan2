package com.example.ktralan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    AdapterList cardAdapter;
    List<Item_list> lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView);
        lc=getListData();
        cardAdapter=new AdapterList(MainActivity.this, lc);
        gridView.setAdapter(cardAdapter);
        registerForContextMenu(gridView);

        gridView.setOnItemClickListener(new  AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item_list item_list=(Item_list) getListData().get(position);
                Intent intent=new Intent(MainActivity.this, Profile.class);
                intent.putExtra("ten",item_list.getTen());

                startActivity(intent);
            }
        });
    }
    private List<Item_list> getListData() {
        List<Item_list> Item_listList=new ArrayList<>();
        Item_list Item_list1=new Item_list(R.drawable.cho,"Võ Văn Thắng");
        Item_list Item_list2=new Item_list(R.drawable.cho,"Đinh Ngọc Hà");
        Item_list Item_list3=new Item_list(R.drawable.cho,"Võ Thi A");
        Item_list Item_list4=new Item_list(R.drawable.cho,"Nguyễn Văn B");
        Item_list Item_list5=new Item_list(R.drawable.cho,"Lê thị C");

        Item_listList.add(Item_list1);
        Item_listList.add(Item_list2);
        Item_listList.add(Item_list3);
        Item_listList.add(Item_list4);
        Item_listList.add(Item_list5);
        return Item_listList;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Chọn hành động");
        menu.add(0,1,0,"Xóa");
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Item_list cardItemSelected=(Item_list) this.getListData().get(info.position);
        if(item.getItemId() == 1){
            // Ask before deleting.
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage(cardItemSelected.getTen()+". Bạn có muốn xoá?")
                    .setCancelable(false)
                    .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            deleteItem(info.position);
                            Toast.makeText(MainActivity.this,"Đã Xóa", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Không", null)
                    .show();
        }
        else
            return false;
        return true;
    }
    private void deleteItem(int item)  {
        lc.remove(item);
        cardAdapter.notifyDataSetChanged();
    }
}