package com.uestc.ganbu.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<E, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<H> {

    private Context context;
    private List<E> mData = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private OnRecyclerViewItemClickListener<E> listener;

    public BaseRecyclerViewAdapter(Context context) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public H onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(setViewId(), viewGroup, false);
        return createViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull H h, int i) {
        onBindView(h, mData.get(i));
        if (listener != null) {
            h.itemView.setOnClickListener(v -> listener.onRecyclerViewItemClicked(mData.get(i)));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setListener(OnRecyclerViewItemClickListener<E> listener) {
        this.listener = listener;
    }

    public void setNewData(List<E> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void addNewItems(List<E> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void addNewItem(E e) {
        mData.add(e);
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    public abstract int setViewId();
    public abstract H createViewHolder(View view);
    public abstract void onBindView(H viewHolder, E entity);
}
