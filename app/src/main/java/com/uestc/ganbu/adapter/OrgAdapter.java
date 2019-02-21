package com.uestc.ganbu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.base.OnRecyclerViewItemClickListener;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.entity.OrgEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrgAdapter extends RecyclerView.Adapter<OrgAdapter.OrgViewHolder> {

    private ArrayList<Object> mData = new ArrayList<>();
    private Context context;
    private OnRecyclerViewItemClickListener<Object> listener;

    public OrgAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public OrgViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_org, viewGroup, false);
        return new OrgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrgViewHolder orgViewHolder, int position) {
        Object entity = mData.get(position);
        Strategy strategy = null;
        if (entity instanceof OrgEntity) {
            strategy = new OrgStrategy();
        } else if (entity instanceof CadreInfo) {
            strategy = new CadreStrategy();
        }
        if (strategy != null) {
            strategy.initView(orgViewHolder, entity);
        }
        orgViewHolder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onRecyclerViewItemClicked(entity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<Object> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void setListener(OnRecyclerViewItemClickListener<Object> listener) {
        this.listener = listener;
    }

    static class OrgViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_org_name)
        TextView mName;
        @BindView(R.id.item_org_icon)
        ImageView mIcon;

        public OrgViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
