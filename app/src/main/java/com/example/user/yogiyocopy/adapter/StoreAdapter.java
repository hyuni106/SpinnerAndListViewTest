package com.example.user.yogiyocopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.yogiyocopy.R;
import com.example.user.yogiyocopy.data.StoreData;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by user on 2017-08-02.
 */

public class StoreAdapter extends ArrayAdapter<StoreData> {
    Context mContext;
    List<StoreData> mList;
    LayoutInflater inf;

    public StoreAdapter(Context context, List<StoreData> list) {
        super(context, R.layout.store_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null) {
            row = inf.inflate(R.layout.store_list_item, null);
            // 뷰를 새로 그려주는 작업
            // 재활용 하는 시점에는 들어오지 않는 부분
        }

        StoreData mData = mList.get(position);
        ImageView cescoImg = row.findViewById(R.id.cescoImg);
        ImageView storeImg = row.findViewById(R.id.storeImg);
        ImageView star1 = (ImageView)row.findViewById(R.id.star1);
        ImageView star2 = (ImageView)row.findViewById(R.id.star2);
        ImageView star3 = (ImageView)row.findViewById(R.id.star3);
        ImageView star4 = (ImageView)row.findViewById(R.id.star4);
        ImageView star5 = (ImageView)row.findViewById(R.id.star5);
        TextView storeNameTxt = row.findViewById(R.id.storeNameTxt);
        TextView avgRatingTxt = row.findViewById(R.id.avgRatingTxt);
        TextView timeTxt = row.findViewById(R.id.timeTxt);
        TextView costTxt = row.findViewById(R.id.costTxt);
        TextView payTxt = row.findViewById(R.id.payTxt);

        Glide.with(mContext).load(mData.getImgPath()).into(storeImg);

        List<ImageView> stars = new ArrayList<>();
        stars.add(star1);
        stars.add(star2);
        stars.add(star3);
        stars.add(star4);
        stars.add(star5);

        for(ImageView iv : stars) {
            iv.setImageResource(R.drawable.empty_star);
        }

        int avg = (int)mData.getAvgRating();
        for(int i=0; i<avg; i++) {
            stars.get(i).setImageResource(R.drawable.fill_star);
        }

        if(mData.isCesco()) {
            cescoImg.setVisibility(View.VISIBLE);
        } else {
            cescoImg.setVisibility(View.INVISIBLE);
        }

        storeNameTxt.setText(mData.getStoreName());
        avgRatingTxt.setText(mData.getAvgRating() + "점 / " + mData.getReviews().size() + "개의 리뷰");
        String minCostStr = String.format("%,d원 이상 배달 가능", mData.getMinCost());
        costTxt.setText(minCostStr);

        int openHour = mData.getOpenTime()/100;
        int openMinute = mData.getOpenTime()%100;
        int closeHour = mData.getCloseTime()/100;
        int closeMinute = mData.getCloseTime()%100;

        String openCloseStr = String.format("%02d:%02d - %02d:%02d", openHour, openMinute, closeHour, closeMinute);
        timeTxt.setText(openCloseStr);

        return row;
    }
}
