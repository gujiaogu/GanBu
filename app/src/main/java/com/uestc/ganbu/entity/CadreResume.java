package com.uestc.ganbu.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * tc04 简历表
 * @author: xfh
 * @create: 2018-06-06
 */
@Entity(nameInDb = "tc04")
public class CadreResume {



    @Property(nameInDb = "BS01")
    @Id
    private Long _id;//sqlite的Cursor必须要有一个_id才能查询
    private String BS02;
    private String BS03;
    private long BS04;
    private long BS05;
    private int BS06;

    // 起始时间
    @Property(nameInDb = "A1905")
    private String beginTime;

    // 终止时间
    @Property(nameInDb = "A1910")
    private String endTime;

    // 经历类型
    @Property(nameInDb = "C0401")
    private String experienceType;

    // 职务类型
    @Property(nameInDb = "A0704")
    private String postType;

    // 简历记录
    @Property(nameInDb = "C0402")
    private String content;

    // 部门类型
    @Property(nameInDb = "C0404")
    private String orgType;

    // 分工
    @Property(nameInDb = "C0405")
    private String division;

    // 备注
    @Property(nameInDb = "C0410")
    private String remark;

    // 干部id
    @Property(nameInDb = "C0411")
    private Long cadreId;

    // 佐证
    @Property(nameInDb = "C0412")
    private String evidence;

    @Transient
    private String experienceTypeDesc;

    // 年限
    @Transient
    private String yearsLimit;

    @Generated(hash = 1518462181)
    public CadreResume(Long _id, String BS02, String BS03, long BS04, long BS05,
            int BS06, String beginTime, String endTime, String experienceType,
            String postType, String content, String orgType, String division,
            String remark, Long cadreId, String evidence) {
        this._id = _id;
        this.BS02 = BS02;
        this.BS03 = BS03;
        this.BS04 = BS04;
        this.BS05 = BS05;
        this.BS06 = BS06;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.experienceType = experienceType;
        this.postType = postType;
        this.content = content;
        this.orgType = orgType;
        this.division = division;
        this.remark = remark;
        this.cadreId = cadreId;
        this.evidence = evidence;
    }

    @Generated(hash = 2122941815)
    public CadreResume() {
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

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getExperienceType() {
        return experienceType;
    }

    public void setExperienceType(String experienceType) {
        this.experienceType = experienceType;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCadreId() {
        return cadreId;
    }

    public void setCadreId(Long cadreId) {
        this.cadreId = cadreId;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getExperienceTypeDesc() {
        return experienceTypeDesc;
    }

    public void setExperienceTypeDesc(String experienceTypeDesc) {
        this.experienceTypeDesc = experienceTypeDesc;
    }

    public String getYearsLimit() {
        return yearsLimit;
    }

    public void setYearsLimit(String yearsLimit) {
        this.yearsLimit = yearsLimit;
    }
}
