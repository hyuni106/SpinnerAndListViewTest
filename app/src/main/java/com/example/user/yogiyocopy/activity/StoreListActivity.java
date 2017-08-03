package com.example.user.yogiyocopy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.user.yogiyocopy.R;
import com.example.user.yogiyocopy.adapter.SortSpinnerAdapter;
import com.example.user.yogiyocopy.adapter.StoreAdapter;
import com.example.user.yogiyocopy.data.StoreData;

import java.util.ArrayList;
import java.util.List;

public class StoreListActivity extends AppCompatActivity {

    private Spinner sortSpinner;
    List<String> sortList = new ArrayList<>();
    SortSpinnerAdapter sortSpinnerAdapter;
    private ListView storeListView;
    List<StoreData> storeDataList = new ArrayList<>();
    StoreAdapter storeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);
        this.storeListView = (ListView) findViewById(R.id.storeListView);
        this.sortSpinner = (Spinner) findViewById(R.id.sortSpinner);

        sortList.add("기본 정렬순");
        sortList.add("별점순");
        sortList.add("리뷰 많은순");
        sortList.add("최소 주문 금액순");

        sortSpinnerAdapter = new SortSpinnerAdapter(StoreListActivity.this, sortList);

        sortSpinner.setAdapter(sortSpinnerAdapter);

        storeDataList.add(new StoreData("https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/kyochon_logo.jpg", "교촌치킨-대학로점", 4.2f, 1200, 2330, 15000, true));
        storeDataList.add(new StoreData("https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/one_logo.jpg", "원할머니보쌈-종로5가점", 3.8f, 1100, 300, 25000, false));

        storeAdapter = new StoreAdapter(StoreListActivity.this, storeDataList);
        storeListView.setAdapter(storeAdapter);
    }
}
