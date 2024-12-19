package com.chad.baserecyclerviewadapterhelper.activity.databinding.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.databinding.ItemMovieBinding;
import com.chad.baserecyclerviewadapterhelper.entity.Movie;
import com.chad.baserecyclerviewadapterhelper.entity.MoviePresenter;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.viewholder.DataBindingHolder;

/**
 * @author: limuyang
 * @date: 2019-12-05
 * @Description: DataBinding Adapter
 *
 */
public class DataBindingAdapter extends BaseQuickAdapter<Movie, DataBindingHolder<ItemMovieBinding>> {

    private final MoviePresenter mPresenter = new MoviePresenter();

    @NonNull
    @Override
    protected DataBindingHolder<ItemMovieBinding> onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup parent, int viewType) {
        return new DataBindingHolder<>(R.layout.item_movie, parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull DataBindingHolder<ItemMovieBinding> holder, int position, @Nullable Movie item) {
        if (item == null) return;

        // 获取 Binding
        ItemMovieBinding binding = holder.getBinding();
        binding.setMovie(item);
        binding.setPresenter(mPresenter);
        binding.executePendingBindings();
    }
}
