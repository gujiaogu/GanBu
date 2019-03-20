package com.uestc.ganbu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.entity.CadreResume;
import com.uestc.ganbu.util.TimeFormatUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResumeAdapter extends RecyclerView.Adapter<ResumeAdapter.ResumeViewHolder> {

    private Context context;
    private ArrayList<CadreResume> mData = new ArrayList<>();

    public ResumeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ResumeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_resume, viewGroup, false);
        return new ResumeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeViewHolder resumeViewHolder, int i) {
        CadreResume entity = mData.get(i);
        String startTime = entity.getBeginTime();
        if (!TextUtils.isEmpty(startTime)) {
            try {
                startTime = TimeFormatUtil.sdf4.format(TimeFormatUtil.sdf6.parse(startTime));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            startTime = "";
        }
        String endTime = entity.getEndTime();
        if (!TextUtils.isEmpty(endTime)) {
            try {
                endTime = TimeFormatUtil.sdf4.format(TimeFormatUtil.sdf6.parse(endTime));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            endTime = "";
        }
        resumeViewHolder.mTime.setText(startTime + " 至 " + endTime);
        resumeViewHolder.mPosition.setText(entity.getContent());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<CadreResume> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    static class ResumeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_resume_time)
        TextView mTime;
        @BindView(R.id.item_resume_position)
        TextView mPosition;

        public ResumeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
