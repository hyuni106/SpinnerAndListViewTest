package com.example.user.yogiyocopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.yogiyocopy.R;
import com.example.user.yogiyocopy.data.OrderData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by user on 2017-08-03.
 */

public class OrderAdapter extends ArrayAdapter<OrderData> {
    Context mContext;
    List<OrderData> mList;
    LayoutInflater inf;

    public OrderAdapter(Context context, List<OrderData> list) {
        super(context, R.layout.order_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null) {
            row = inf.inflate(R.layout.order_list_item, null);
        }

        OrderData data = mList.get(position);
        TextView storeNameTxt = (TextView)row.findViewById(R.id.storeNameTxt);
        TextView orderDateTxt = (TextView)row.findViewById(R.id.orderDateTxt);
        TextView locationTxt = (TextView)row.findViewById(R.id.locationTxt);
        TextView costTxt = (TextView)row.findViewById(R.id.costTxt);

        storeNameTxt.setText(data.getOrderStore().getStoreName());

        SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년 M월 dd일");
        orderDateTxt.setText(fm1.format(data.getOrderDate().getTime()));

        locationTxt.setText(data.getLocation());

        String cost = String.format(Locale.KOREA, "%,d 원", data.getCost());
        costTxt.setText(cost);

        return row;
    }
}
