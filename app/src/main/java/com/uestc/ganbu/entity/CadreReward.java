package com.uestc.ganbu.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * tc09 奖励信息表
 *
 * @author: xfh
 * @create: 2018-06-12
 */
@Entity(nameInDb = "tc09")
public class CadreReward {

    @Property(nameInDb = "BS01")
    @Id
    private Long _id;//sqlite的Cursor必须要有一个_id才能查询
    private String BS02;
    private String BS03;
    private long BS04;
    private long BS05;
    private int BS06;

    // 奖励类型
    @Property(nameInDb = "A2604")
    private String rewardType;

    // 奖励名称
    @Property(nameInDb = "A2605")
    private String rewardName;

    // 奖励原因
    @Property(nameInDb = "A2610")
    private String rewardReason;

    // 奖励批准机关名称
    @Property(nameInDb = "A2615")
    private String approvalAuthority;

    // 授予荣誉称号
    @Property(nameInDb = "A2620")
    private String titleName;

    // 奖励批准日期
    @Property(nameInDb = "A2625")
    private String approvalTime;


    // 授予荣誉称号级别
    @Property(nameInDb = "A2635")
    private String titleLevel;

    // 干部id
    @Property(nameInDb = "C0911")
    private long cadreId;

    // 佐证
    @Property(nameInDb = "C0912")
    private String evidence;

    @Transient
    private String rewardTypeDesc;

    @Generated(hash = 1050396895)
    public CadreReward(Long _id, String BS02, String BS03, long BS04, long BS05,
            int BS06, String rewardType, String rewardName, String rewardReason,
            String approvalAuthority, String titleName, String approvalTime,
            String titleLevel, long cadreId, String evidence) {
        this._id = _id;
        this.BS02 = BS02;
        this.BS03 = BS03;
        this.BS04 = BS04;
        this.BS05 = BS05;
        this.BS06 = BS06;
        this.rewardType = rewardType;
        this.rewardName = rewardName;
        this.rewardReason = rewardReason;
        this.approvalAuthority = approvalAuthority;
        this.titleName = titleName;
        this.approvalTime = approvalTime;
        this.titleLevel = titleLevel;
        this.cadreId = cadreId;
        this.evidence = evidence;
    }

    @Generated(hash = 8550640)
    public CadreReward() {
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardReason() {
        return rewardReason;
    }

    public void setRewardReason(String rewardReason) {
        this.rewardReason = rewardReason;
    }

    public String getApprovalAuthority() {
        return approvalAuthority;
    }

    public void setApprovalAuthority(String approvalAuthority) {
        this.approvalAuthority = approvalAuthority;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public long getCadreId() {
        return cadreId;
    }

    public void setCadreId(long cadreId) {
        this.cadreId = cadreId;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getRewardTypeDesc() {
        return rewardTypeDesc;
    }

    public void setRewardTypeDesc(String rewardTypeDesc) {
        this.rewardTypeDesc = rewardTypeDesc;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getBS02() {
        return this.BS02;
    }

    public void setBS02(String BS02) {
        this.BS02 = BS02;
    }

    public String getBS03() {
        return this.BS03;
    }

    public void setBS03(String BS03) {
        this.BS03 = BS03;
    }

    public long getBS04() {
        return this.BS04;
    }

    public void setBS04(long BS04) {
        this.BS04 = BS04;
    }

    public long getBS05() {
        return this.BS05;
    }

    public void setBS05(long BS05) {
        this.BS05 = BS05;
    }

    public int getBS06() {
        return this.BS06;
    }

    public void setBS06(int BS06) {
        this.BS06 = BS06;
    }
}
