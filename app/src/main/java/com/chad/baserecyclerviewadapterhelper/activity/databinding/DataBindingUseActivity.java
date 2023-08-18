package com.chad.baserecyclerviewadapterhelper.activity.databinding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.baserecyclerviewadapterhelper.activity.databinding.adapter.DataBindingAdapter;
import com.chad.baserecyclerviewadapterhelper.base.BaseViewBindingActivity;
import com.chad.baserecyclerviewadapterhelper.databinding.ActivityUniversalRecyclerBinding;
import com.chad.baserecyclerviewadapterhelper.entity.Movie;
import com.chad.baserecyclerviewadapterhelper.utils.Tips;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author  limuyang
 * @date  2019-12-05
 * @description
 */
public final class DataBindingUseActivity extends BaseViewBindingActivity<ActivityUniversalRecyclerBinding> {

    private final DataBindingAdapter adapter = new DataBindingAdapter();

    @NonNull
    @Override
    public ActivityUniversalRecyclerBinding initBinding() {
        return ActivityUniversalRecyclerBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getViewBinding().titleBar.setTitle("DataBinding Use");
        getViewBinding().titleBar.setOnBackListener(v -> finish());


        getViewBinding().rv.setLayoutManager(new LinearLayoutManager(this));
        getViewBinding().rv.setAdapter(adapter);


        //item 点击事件
        adapter.setOnItemClickListener((movieBaseQuickAdapter, view, position) -> {
            Tips.show("onItemClick: " + position);
        });

        //设置数据
        adapter.submitList(genData());
    }

    private List<Movie> genData() {
        ArrayList<Movie> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "Chad " + i;
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            Movie movie = new Movie(name, len, price, "He was one of Australia's most distinguished artistes");
            list.add(movie);
        }
        return list;
    }
}
