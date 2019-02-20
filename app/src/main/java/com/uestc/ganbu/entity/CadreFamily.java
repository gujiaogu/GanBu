package com.uestc.ganbu.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * tc05 家庭关系表
 * @author: xfh
 * @create: 2018-06-22
 */
@Entity(nameInDb = "tc05")
public class CadreFamily {

    @Property(nameInDb = "BS01")
    @Id
    private Long _id;//sqlite的Cursor必须要有一个_id才能查询
    private String BS02;
    private String BS03;
    private long BS04;
    private long BS05;
    private int BS06;

    // 称谓
//    @Comment(value = "称谓",dict = "RELATIONSHIP_TYPE")
    @Property(nameInDb = "A7910")
    private String relationship;

    // 姓名
    @Property(nameInDb = "A7905")
    private String name;

    // 出生日期
    @Property(nameInDb = "A7915")
    private String birthDay;

    // 政治面貌
    //    @Comment(value = "政治面貌",dict = "POLITICAL_TYPE")
    @Property(nameInDb = "A7925")
    private String politicalStatus;

    // 工作单位及职务
    @Property(nameInDb = "A7920")
    private String workUnit;

    // 移居地方
    @Property(nameInDb = "C0501")
    private String immigration;

    // 备注
    @Property(nameInDb = "C0502")
    private String remark;

    // 干部id
    @Property(nameInDb = "C0511")
    private Long cadreId;

    // 佐证
    @Property(nameInDb = "C0512")
    private String evidence;

    // 关系名称
    @Transient
    private String relationshipDesc;

    // 政治面貌
    @Transient
    private String politicalStatusDesc;

    @Generated(hash = 437139480)
    public CadreFamily(Long _id, String BS02, String BS03, long BS04, long BS05,
            int BS06, String relationship, String name, String birthDay,
            String politicalStatus, String workUnit, String immigration,
            String remark, Long cadreId, String evidence) {
        this._id = _id;
        this.BS02 = BS02;
        this.BS03 = BS03;
        this.BS04 = BS04;
        this.BS05 = BS05;
        this.BS06 = BS06;
        this.relationship = relationship;
        this.name = name;
        this.birthDay = birthDay;
        this.politicalStatus = politicalStatus;
        this.workUnit = workUnit;
        this.immigration = immigration;
        this.remark = remark;
        this.cadreId = cadreId;
        this.evidence = evidence;
    }

    @Generated(hash = 947395293)
    public CadreFamily() {
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getImmigration() {
        return immigration;
    }

    public void setImmigration(String immigration) {
        this.immigration = immigration;
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

    public String getRelationshipDesc() {
        return relationshipDesc;
    }

    public void setRelationshipDesc(String relationshipDesc) {
        this.relationshipDesc = relationshipDesc;
    }

    public String getPoliticalStatusDesc() {
        return politicalStatusDesc;
    }

    public void setPoliticalStatusDesc(String politicalStatusDesc) {
        this.politicalStatusDesc = politicalStatusDesc;
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
}
