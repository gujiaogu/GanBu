package com.uestc.ganbu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.base.OnRecyclerViewItemClickListener;
import com.uestc.ganbu.entity.CadreInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private Context context;
    private ArrayList<CadreInfo> mData = new ArrayList<>();
    private OnRecyclerViewItemClickListener<CadreInfo> listener;

    public SearchAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search, viewGroup, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int i) {
        CadreInfo entity = mData.get(i);
        holder.mName.setText(entity.getName());
        holder.mPosition.setText(entity.getPostTitleDesc() == null ? "" : entity.getPostTitleDesc());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onRecyclerViewItemClicked(entity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setListener(OnRecyclerViewItemClickListener<CadreInfo> listener) {
        this.listener = listener;
    }

    public void setNewData(List<CadreInfo> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    static class SearchViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_search_name)
        TextView mName;
        @BindView(R.id.item_search_position)
        TextView mPosition;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
