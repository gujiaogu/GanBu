package com.uestc.ganbu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.base.BaseRecyclerViewAdapter;
import com.uestc.ganbu.entity.OrgEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchOrgAdapter extends BaseRecyclerViewAdapter<OrgEntity, SearchOrgAdapter.SearchOrgViewHolder> {

    public SearchOrgAdapter(Context context) {
        super(context);
    }

    @Override
    public int setViewId() {
        return R.layout.item_search_org;
    }

    @Override
    public SearchOrgViewHolder createViewHolder(View view) {
        return new SearchOrgViewHolder(view);
    }

    @Override
    public void onBindView(SearchOrgViewHolder viewHolder, OrgEntity entity) {
        viewHolder.mName.setText(entity.getName());
    }

    static class SearchOrgViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_search_org_name)
        TextView mName;

        SearchOrgViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
