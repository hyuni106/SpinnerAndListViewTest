package com.example.user.yogiyocopy.activity;

import android.app.TabActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.user.yogiyocopy.R;
import com.example.user.yogiyocopy.adapter.OrderAdapter;
import com.example.user.yogiyocopy.adapter.StoreAdapter;
import com.example.user.yogiyocopy.data.OrderData;
import com.example.user.yogiyocopy.data.StoreData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabHost myTabHost;
    private ListView storeListView;
    List<StoreData> storeDataList = new ArrayList<>();
    StoreAdapter storeAdapter;
    private ListView orderListView;
    List<OrderData> orderDataList = new ArrayList<>();
    OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTabHost = (TabHost)findViewById(R.id.myTabHost);
        myTabHost.setup();
        storeListView = (ListView) findViewById(R.id.storeListView);
        orderListView = (ListView) findViewById(R.id.orderListView);

        TabHost.TabSpec spec1 = myTabHost.newTabSpec("tab1").setIndicator("가게목록");
        spec1.setContent(R.id.tab1);
        myTabHost.addTab(spec1);

        TabHost.TabSpec spec2 = myTabHost.newTabSpec("tab2").setIndicator("주문내역");
        spec2.setContent(R.id.tab2);
        myTabHost.addTab(spec2);

        TabHost.TabSpec spec3 = myTabHost.newTabSpec("tab3").setIndicator("더보기");
        spec3.setContent(R.id.tab3);
        myTabHost.addTab(spec3);

        TabHost.TabSpec spec4 = myTabHost.newTabSpec("tab4").setIndicator("프로필");
        spec4.setContent(R.id.tab4);
        myTabHost.addTab(spec4);

        listSet();

        storeAdapter = new StoreAdapter(MainActivity.this, storeDataList);
        storeListView.setAdapter(storeAdapter);

        orderAdapter = new OrderAdapter(MainActivity.this, orderDataList);
        orderListView.setAdapter(orderAdapter);
    }

    public void listSet() {
        storeDataList.add(new StoreData("https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/kyochon_logo.jpg", "교촌치킨-대학로점", 4.2f, 1200, 2330, 15000, true));
        storeDataList.add(new StoreData("https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/one_logo.jpg", "원할머니보쌈-종로5가점", 3.8f, 1100, 300, 25000, false));
        storeDataList.add(new StoreData("https://www.yogiyo.co.kr/media/restaurant_logos/%EB%96%A1%EB%B3%B6%EC%9D%B4%EC%88%9C%EB%8C%80%EC%84%B8%ED%8A%B801_20131128_FoodAD_crop_200x200_yjnTv3z.jpg", "스쿨스토어-종로점", 4.2f, 1200, 2330, 15000, true));
        storeDataList.add(new StoreData("https://www.yogiyo.co.kr/media/restaurant_logos/%EB%B3%B8%EB%8F%84%EC%8B%9C%EB%9D%BD_20150825_Franchise%EC%9D%B4%EB%AF%B8%EC%A7%80%EC%95%BD%EC%A0%95%EC%84%9C_crop_200x200_zY4cB53.jpg", "본도시락-서울시청점", 3.8f, 1100, 300, 25000, false));
        storeDataList.add(new StoreData("https://www.yogiyo.co.kr/media/restaurant_logos/%EC%89%AC%EB%A6%BC%ED%94%84_%ED%94%BC%EC%9E%9001_20131128_FoodAD_crop_200x200.jpg", "훼미리피자", 4.2f, 1200, 2330, 15000, true));
        storeDataList.add(new StoreData("https://www.yogiyo.co.kr/media/restaurant_logos/%ED%83%95%EC%88%98%EC%9C%A103_20131128_FoodAD_crop_200x200_Rn9zt25.jpg", "남경-남대문시장점", 3.8f, 1100, 300, 25000, false));

        orderDataList.add(new OrderData(storeDataList.get(0), Calendar.getInstance(), "종로3가", 15000));
        orderDataList.add(new OrderData(storeDataList.get(0), Calendar.getInstance(), "종로1가", 10000));
        orderDataList.add(new OrderData(storeDataList.get(0), Calendar.getInstance(), "을지로3가", 30000));
        orderDataList.add(new OrderData(storeDataList.get(1), Calendar.getInstance(), "종로3가", 25000));
        orderDataList.add(new OrderData(storeDataList.get(1), Calendar.getInstance(), "종로3가", 15000));
        orderDataList.add(new OrderData(storeDataList.get(4), Calendar.getInstance(), "종로3가", 33000));
        orderDataList.add(new OrderData(storeDataList.get(2), Calendar.getInstance(), "종로3가", 11000));
        orderDataList.add(new OrderData(storeDataList.get(2), Calendar.getInstance(), "종로3가", 12000));

    }
}
