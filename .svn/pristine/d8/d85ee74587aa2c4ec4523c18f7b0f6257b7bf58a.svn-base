package com.uestc.ganbu.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * tc10 惩罚信息表
 *
 * @author: xfh
 * @create: 2018-06-12
 */
@Entity(nameInDb = "tc10")
public class CadrePunishment {

    @Property(nameInDb = "BS01")
    @Id
    private Long _id;//sqlite的Cursor必须要有一个_id才能查询
    private String BS02;
    private String BS03;
    private long BS04;
    private long BS05;
    private int BS06;

    // 处分名称
    @Property(nameInDb = "A2705")
    private String punishmentName;

    // 处分原因
    @Property(nameInDb = "A2710")
    private String punishmentReason;

    // 处分批准日期
    @Property(nameInDb = "A2715")
    private String approvalTime;

    // 处分批准机关名称
    @Property(nameInDb = "A2720")
    private String approvalAuthority;

    // 处分撤销日期
    @Property(nameInDb = "A2725")
    private String undoTime;

    // 备注
    @Property(nameInDb = "C1002")
    private String remark;

    // 状态（0：立案 1：结案 2：撤销）
    @Property(nameInDb = "C1001")
    private int punishmentState;

    // 干部id
    @Property(nameInDb = "C1011")
    private long cadreId;

    // 佐证
    @Property(nameInDb = "C1012")
    private String evidence;

    // 佐证
    @Property(nameInDb = "C1013")
    private String endEvidence;

    @Transient
    private String punishmentNameDesc;

    @Transient
    private String punishmentReasonDesc;

    @Generated(hash = 2076968696)
    public CadrePunishment(Long _id, String BS02, String BS03, long BS04, long BS05,
            int BS06, String punishmentName, String punishmentReason,
            String approvalTime, String approvalAuthority, String undoTime,
            String remark, int punishmentState, long cadreId, String evidence,
            String endEvidence) {
        this._id = _id;
        this.BS02 = BS02;
        this.BS03 = BS03;
        this.BS04 = BS04;
        this.BS05 = BS05;
        this.BS06 = BS06;
        this.punishmentName = punishmentName;
        this.punishmentReason = punishmentReason;
        this.approvalTime = approvalTime;
        this.approvalAuthority = approvalAuthority;
        this.undoTime = undoTime;
        this.remark = remark;
        this.punishmentState = punishmentState;
        this.cadreId = cadreId;
        this.evidence = evidence;
        this.endEvidence = endEvidence;
    }

    @Generated(hash = 728646490)
    public CadrePunishment() {
    }

    public String getPunishmentName() {
        return punishmentName;
    }

    public void setPunishmentName(String punishmentName) {
        this.punishmentName = punishmentName;
    }

    public String getPunishmentReason() {
        return punishmentReason;
    }

    public void setPunishmentReason(String punishmentReason) {
        this.punishmentReason = punishmentReason;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getApprovalAuthority() {
        return approvalAuthority;
    }

    public void setApprovalAuthority(String approvalAuthority) {
        this.approvalAuthority = approvalAuthority;
    }

    public String getUndoTime() {
        return undoTime;
    }

    public void setUndoTime(String undoTime) {
        this.undoTime = undoTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPunishmentState() {
        return punishmentState;
    }

    public void setPunishmentState(int punishmentState) {
        this.punishmentState = punishmentState;
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

    public String getEndEvidence() {
        return endEvidence;
    }

    public void setEndEvidence(String endEvidence) {
        this.endEvidence = endEvidence;
    }

    public String getPunishmentNameDesc() {
        return punishmentNameDesc;
    }

    public void setPunishmentNameDesc(String punishmentNameDesc) {
        this.punishmentNameDesc = punishmentNameDesc;
    }

    public String getPunishmentReasonDesc() {
        return punishmentReasonDesc;
    }

    public void setPunishmentReasonDesc(String punishmentReasonDesc) {
        this.punishmentReasonDesc = punishmentReasonDesc;
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
