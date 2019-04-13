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
import com.uestc.ganbu.entity.CadreFamily;
import com.uestc.ganbu.util.StreamUtil;
import com.uestc.ganbu.util.TimeFormatUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FamilyAdapter extends RecyclerView.Adapter<FamilyAdapter.FamilyViewHolder> {

    private Context context;
    private ArrayList<CadreFamily> mData = new ArrayList<>();
    private SQLiteDatabase db;

    public FamilyAdapter(Context context, SQLiteDatabase db) {
        this.context = context;
        this.db = db;
    }

    @NonNull
    @Override
    public FamilyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_family, viewGroup, false);
        return new FamilyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FamilyViewHolder holder, int i) {
        CadreFamily entity = mData.get(i);
        holder.mName.setText(entity.getName());
        String birthday = entity.getBirthDay();
        if (!TextUtils.isEmpty(birthday)) {
            try {
                birthday = TimeFormatUtil.sdf.format(TimeFormatUtil.sdf6.parse(birthday));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            birthday = "";
        }
        holder.mBirthday.setText(birthday);
        holder.mWorkUnit.setText(entity.getWorkUnit() == null ? "" : entity.getWorkUnit());
        String relationship = entity.getRelationship();
        if (!TextUtils.isEmpty(relationship)) {
            Cursor cursor = db.rawQuery("SELECT * FROM ts06 WHERE S0601='45' and S0602=?", new String[]{relationship});
            int count = cursor.getCount();
            if (count > 0) {
                if (cursor.moveToFirst()) {
                    holder.mRelationship.setText(cursor.getString(cursor.getColumnIndex("S0603")));
                }
            }
            StreamUtil.close(cursor);
        }

        String political = entity.getPoliticalStatus();
        if (!TextUtils.isEmpty(political)) {
            Cursor cursor = db.rawQuery("SELECT * FROM ts06 WHERE S0601='20' and S0602=?", new String[]{political});
            int count = cursor.getCount();
            if (count > 0) {
                if (cursor.moveToFirst()) {
                    holder.mPolitical.setText(cursor.getString(cursor.getColumnIndex("S0603")));
                }
            }
            StreamUtil.close(cursor);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<CadreFamily> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    static class FamilyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_family_relationship)
        TextView mRelationship;
        @BindView(R.id.item_family_name)
        TextView mName;
        @BindView(R.id.item_family_birthday)
        TextView mBirthday;
        @BindView(R.id.item_family_political)
        TextView mPolitical;
        @BindView(R.id.item_family_work_unit)
        TextView mWorkUnit;

        public FamilyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
