package com.uestc.ganbu.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * tc07 任免信息表
 *
 * @author: xfh
 * @create: 2018-06-11
 */
//任免信息
@Entity(nameInDb = "tc07")
public class CadreAppointAndDismiss {

    @Property(nameInDb = "BS01")
    @Id
    private Long _id;//sqlite的Cursor必须要有一个_id才能查询
    private String BS02;
    private String BS03;
    private long BS04;
    private long BS05;
    private int BS06;

    // 任职机构
    @Property(nameInDb = "A0711")
    private long orgId;

    // 职务名称
    @Property(nameInDb = "A0704")
    private String postTitle;

    // 其他职务标志(1= 其他职务, 0=POST_TITLE字段职务)
    @Property(nameInDb = "A0705")
    private int postOtherFlag;

    // 其他职务名称
    @Property(nameInDb = "A0706")
    private String postOther;

    // 职务级别
    @Property(nameInDb = "A0901")
    private String postLevel;

    // 任职原因
    @Property(nameInDb = "A0717")
    private String appointReason;

    // 任职时间
    @Property(nameInDb = "A0708")
    private String appointTime;

    // 是否为主职务（1是2否）
    @Property(nameInDb = "A0741")
    private int postOrder;

    // 批准机关名称
    @Property(nameInDb = "A0731")
    private String approvalAuthority;

    // 任职文号
    @Property(nameInDb = "A0721")
    private String appointNumber;

    // 免职日期
    @Property(nameInDb = "A0747")
    private String dismissTime;

    // 免职文号
    @Property(nameInDb = "A0757")
    private String dismissNumber;

    // 免职方式
    @Property(nameInDb = "A0751")
    private String dismissMode;

    // 免职类别
    @Property(nameInDb = "A0754")
    private String dismissCategory;

    // 任职说明
    @Property(nameInDb = "C0701")
    private String appointRemark;

    // 免职说明
    @Property(nameInDb = "C0702")
    private String dismissRemark;

    // 干部id
    @Property(nameInDb = "C0711")
    private long cadreId;

    // 佐证
    @Property(nameInDb = "C0712")
    private String evidence;

    // 任免状态(1 任职 2 免职)
    @Property(nameInDb = "C0703")
    private int status;

    // 经历类型
    @Property(nameInDb = "C0704")
    private String experienceType;

    //排序
    @Property(nameInDb = "C0714")
    private int seq;

    private String name;

    private String sexDesc;

    private String orgName;

    private String postTitleDesc;

    private String postTitleTime;

    private String postLevelDesc;

    // 是否领导(1=领导, 0=非领导)
    @Property(nameInDb = "A0707")
    private String isLeader;

    @Generated(hash = 31867323)
    public CadreAppointAndDismiss(Long _id, String BS02, String BS03, long BS04,
            long BS05, int BS06, long orgId, String postTitle, int postOtherFlag,
            String postOther, String postLevel, String appointReason,
            String appointTime, int postOrder, String approvalAuthority,
            String appointNumber, String dismissTime, String dismissNumber,
            String dismissMode, String dismissCategory, String appointRemark,
            String dismissRemark, long cadreId, String evidence, int status,
            String experienceType, int seq, String name, String sexDesc,
            String orgName, String postTitleDesc, String postTitleTime,
            String postLevelDesc, String isLeader) {
        this._id = _id;
        this.BS02 = BS02;
        this.BS03 = BS03;
        this.BS04 = BS04;
        this.BS05 = BS05;
        this.BS06 = BS06;
        this.orgId = orgId;
        this.postTitle = postTitle;
        this.postOtherFlag = postOtherFlag;
        this.postOther = postOther;
        this.postLevel = postLevel;
        this.appointReason = appointReason;
        this.appointTime = appointTime;
        this.postOrder = postOrder;
        this.approvalAuthority = approvalAuthority;
        this.appointNumber = appointNumber;
        this.dismissTime = dismissTime;
        this.dismissNumber = dismissNumber;
        this.dismissMode = dismissMode;
        this.dismissCategory = dismissCategory;
        this.appointRemark = appointRemark;
        this.dismissRemark = dismissRemark;
        this.cadreId = cadreId;
        this.evidence = evidence;
        this.status = status;
        this.experienceType = experienceType;
        this.seq = seq;
        this.name = name;
        this.sexDesc = sexDesc;
        this.orgName = orgName;
        this.postTitleDesc = postTitleDesc;
        this.postTitleTime = postTitleTime;
        this.postLevelDesc = postLevelDesc;
        this.isLeader = isLeader;
    }

    @Generated(hash = 2076209430)
    public CadreAppointAndDismiss() {
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getBS02() {
        return BS02;
    }

    public void setBS02(String BS02) {
        this.BS02 = BS02;
    }

    public String getBS03() {
        return BS03;
    }

    public void setBS03(String BS03) {
        this.BS03 = BS03;
    }

    public long getBS04() {
        return BS04;
    }

    public void setBS04(long BS04) {
        this.BS04 = BS04;
    }

    public long getBS05() {
        return BS05;
    }

    public void setBS05(long BS05) {
        this.BS05 = BS05;
    }

    public int getBS06() {
        return BS06;
    }

    public void setBS06(int BS06) {
        this.BS06 = BS06;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public int getPostOtherFlag() {
        return postOtherFlag;
    }

    public void setPostOtherFlag(int postOtherFlag) {
        this.postOtherFlag = postOtherFlag;
    }

    public String getPostOther() {
        return postOther;
    }

    public void setPostOther(String postOther) {
        this.postOther = postOther;
    }

    public String getPostLevel() {
        return postLevel;
    }

    public void setPostLevel(String postLevel) {
        this.postLevel = postLevel;
    }

    public String getAppointReason() {
        return appointReason;
    }

    public void setAppointReason(String appointReason) {
        this.appointReason = appointReason;
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    public int getPostOrder() {
        return postOrder;
    }

    public void setPostOrder(int postOrder) {
        this.postOrder = postOrder;
    }

    public String getApprovalAuthority() {
        return approvalAuthority;
    }

    public void setApprovalAuthority(String approvalAuthority) {
        this.approvalAuthority = approvalAuthority;
    }

    public String getAppointNumber() {
        return appointNumber;
    }

    public void setAppointNumber(String appointNumber) {
        this.appointNumber = appointNumber;
    }

    public String getDismissTime() {
        return dismissTime;
    }

    public void setDismissTime(String dismissTime) {
        this.dismissTime = dismissTime;
    }

    public String getDismissNumber() {
        return dismissNumber;
    }

    public void setDismissNumber(String dismissNumber) {
        this.dismissNumber = dismissNumber;
    }

    public String getDismissMode() {
        return dismissMode;
    }

    public void setDismissMode(String dismissMode) {
        this.dismissMode = dismissMode;
    }

    public String getDismissCategory() {
        return dismissCategory;
    }

    public void setDismissCategory(String dismissCategory) {
        this.dismissCategory = dismissCategory;
    }

    public String getAppointRemark() {
        return appointRemark;
    }

    public void setAppointRemark(String appointRemark) {
        this.appointRemark = appointRemark;
    }

    public String getDismissRemark() {
        return dismissRemark;
    }

    public void setDismissRemark(String dismissRemark) {
        this.dismissRemark = dismissRemark;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getExperienceType() {
        return experienceType;
    }

    public void setExperienceType(String experienceType) {
        this.experienceType = experienceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexDesc() {
        return sexDesc;
    }

    public void setSexDesc(String sexDesc) {
        this.sexDesc = sexDesc;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPostTitleDesc() {
        return postTitleDesc;
    }

    public void setPostTitleDesc(String postTitleDesc) {
        this.postTitleDesc = postTitleDesc;
    }

    public String getPostTitleTime() {
        return postTitleTime;
    }

    public void setPostTitleTime(String postTitleTime) {
        this.postTitleTime = postTitleTime;
    }

    public String getPostLevelDesc() {
        return postLevelDesc;
    }

    public void setPostLevelDesc(String postLevelDesc) {
        this.postLevelDesc = postLevelDesc;
    }

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }
}
