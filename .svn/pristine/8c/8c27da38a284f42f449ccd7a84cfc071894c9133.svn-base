package com.uestc.ganbu.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.entity.CadrePunishment;
import com.uestc.ganbu.entity.CadreReward;
import com.uestc.ganbu.util.StreamUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AwardPunishmentAdapter extends RecyclerView.Adapter<AwardPunishmentAdapter.AwardPunishmentViewHolder> {

    private Context context;
    private ArrayList<Object> mData = new ArrayList<>();
    private SQLiteDatabase db;

    public AwardPunishmentAdapter(Context context, SQLiteDatabase db) {
        this.context = context;
        this.db = db;
    }

    @NonNull
    @Override
    public AwardPunishmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_award_punishment, viewGroup, false);
        return new AwardPunishmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AwardPunishmentViewHolder viewHolder, int i) {
        Object entity = mData.get(i);
        if (entity instanceof CadreReward) {
            CadreReward cadreReward = (CadreReward) entity;
            String year = cadreReward.getApprovalTime();
            if (!TextUtils.isEmpty(year)) {
                year = year.substring(0, 4);
            } else {
                year = "";
            }

            String org = cadreReward.getApprovalAuthority();
            if (TextUtils.isEmpty(org)) {
                org = "";
            }

            String rewardName = cadreReward.getRewardName();

            viewHolder.mAwardPunishment.setText(year + "年被" + org + "评为" + rewardName);
        } else if (entity instanceof CadrePunishment) {
            CadrePunishment cadrePunishment = (CadrePunishment) entity;
            String year = cadrePunishment.getApprovalTime();
            if (!TextUtils.isEmpty(year)) {
                year = year.substring(0, 4);
            } else {
                year = "";
            }

            String org = cadrePunishment.getApprovalAuthority();
            if (TextUtils.isEmpty(org)) {
                org = "";
            }
            String punishmentName = cadrePunishment.getPunishmentName();
            if (!TextUtils.isEmpty(punishmentName)) {
                Cursor cursor = db.rawQuery("SELECT * FROM ts06 WHERE S0601='41' and S0602=?", new String[]{punishmentName});
                int count = cursor.getCount();
                if (count > 0) {
                    if (cursor.moveToFirst()) {
                        punishmentName = cursor.getString(cursor.getColumnIndex("S0603"));
                        if (TextUtils.isEmpty(punishmentName)) {
                            punishmentName = "";
                        }
                    }
                }
                StreamUtil.close(cursor);
            } else {
                punishmentName = "";
            }
            viewHolder.mAwardPunishment.setText(year + "年被" + org + "处" + punishmentName);
        }
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

    static class AwardPunishmentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_award_punishment)
        TextView mAwardPunishment;

        public AwardPunishmentViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
