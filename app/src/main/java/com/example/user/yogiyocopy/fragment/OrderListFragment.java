package com.example.user.yogiyocopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.yogiyocopy.R;
import com.example.user.yogiyocopy.activity.MainActivity;
import com.example.user.yogiyocopy.adapter.OrderAdapter;
import com.example.user.yogiyocopy.data.OrderData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by user on 2017-08-04.
 */

public class OrderListFragment extends Fragment {
    private ListView orderListView;
    List<OrderData> orderDataList = new ArrayList<>();
    OrderAdapter orderAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order_list, container, false);
        orderListView = (ListView)v.findViewById(R.id.orderListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        orderDataList.add(new OrderData(StoreListFragment.storeDataList.get(0), Calendar.getInstance(), "종로3가", 15000));
        orderDataList.add(new OrderData(StoreListFragment.storeDataList.get(0), Calendar.getInstance(), "종로1가", 10000));
        orderDataList.add(new OrderData(StoreListFragment.storeDataList.get(0), Calendar.getInstance(), "을지로3가", 30000));
        orderDataList.add(new OrderData(StoreListFragment.storeDataList.get(1), Calendar.getInstance(), "종로3가", 25000));
        orderDataList.add(new OrderData(StoreListFragment.storeDataList.get(1), Calendar.getInstance(), "종로3가", 15000));
        orderDataList.add(new OrderData(StoreListFragment.storeDataList.get(4), Calendar.getInstance(), "종로3가", 33000));
        orderDataList.add(new OrderData(StoreListFragment.storeDataList.get(2), Calendar.getInstance(), "종로3가", 11000));
        orderDataList.add(new OrderData(StoreListFragment.storeDataList.get(2), Calendar.getInstance(), "종로3가", 12000));

        orderAdapter = new OrderAdapter(getActivity(), orderDataList);
        orderListView.setAdapter(orderAdapter);
    }
}
