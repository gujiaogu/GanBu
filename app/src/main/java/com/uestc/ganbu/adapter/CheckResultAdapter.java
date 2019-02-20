package com.uestc.ganbu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.entity.CadreAppraisal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckResultAdapter extends RecyclerView.Adapter<CheckResultAdapter.CheckResultViewHolder> {

    private Context context;
    private ArrayList<CadreAppraisal> mData = new ArrayList<>();

    public CheckResultAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CheckResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_check_result, viewGroup, false);
        return new CheckResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckResultViewHolder checkResultViewHolder, int i) {
        CadreAppraisal entity = mData.get(i);
        checkResultViewHolder.content.setText(entity.getC0602());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<CadreAppraisal> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    static class CheckResultViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_check_result_content)
        TextView content;

        public CheckResultViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
