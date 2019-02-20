package com.uestc.ganbu.adapter;

import com.uestc.ganbu.entity.CadreInfo;

public class CadreStrategy implements Strategy {
    @Override
    public void initView(OrgAdapter.OrgViewHolder orgViewHolder, Object entity) {
        CadreInfo cadreInfo = (CadreInfo) entity;
        orgViewHolder.mName.setText(cadreInfo.getName());
    }
}
