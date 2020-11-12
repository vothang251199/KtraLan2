package com.example.ktralan2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterList extends BaseAdapter {
    private List<Item_list> lc;
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterList(Context context,List<Item_list> lc){
        this.context=context;
        this.lc=lc;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lc.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.activity_item_list,null);
            viewHolder=new ViewHolder();
            viewHolder.image=(ImageView) convertView.findViewById(R.id.imganh);
            viewHolder.ten=(TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder=(ViewHolder) convertView.getTag();

        Item_list cardItem=this.lc.get(position);
        viewHolder.image.setImageResource(cardItem.getImg());
        viewHolder.ten.setText(cardItem.getTen());
        return convertView;
    }
    private class ViewHolder {
        ImageView image;
        TextView ten,mota;
    }
}
