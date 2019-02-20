package com.uestc.ganbu.adapter;

import com.uestc.ganbu.entity.OrgEntity;

public class OrgStrategy implements Strategy {
    @Override
    public void initView(OrgAdapter.OrgViewHolder orgViewHolder, Object entity) {
        OrgEntity orgEntity = (OrgEntity) entity;
        orgViewHolder.mName.setText(orgEntity.getName());
    }
}
