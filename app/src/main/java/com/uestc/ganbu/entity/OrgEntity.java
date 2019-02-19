package com.uestc.ganbu.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "ts04")
public class OrgEntity {
    @Property(nameInDb = "BS01")
    @Id
    private Long id;
    private String BS02;
    private String BS03;
    private int BS04;
    private int BS05;
    private int BS06;
    private int BS07;
    @Property(nameInDb = "B0105")
    private String name;
    @Property(nameInDb = "B0110")
    private String orgCode;
    @Property(nameInDb = "B0120")
    private String address;
    @Property(nameInDb = "B0125")
    private String phone;
    @Property(nameInDb = "S0401")
    private String sort;
    @Property(nameInDb = "S0402")
    private String orgCadreNum;
    @Property(nameInDb = "S0403")
    private String orgEvidence;
    @Property(nameInDb = "S0404")
    private String workEvidence;
    @Property(nameInDb = "S0405")
    private String orgOtherFlag;

    @Generated(hash = 724132166)
    public OrgEntity(Long id, String BS02, String BS03, int BS04, int BS05,
            int BS06, int BS07, String name, String orgCode, String address,
            String phone, String sort, String orgCadreNum, String orgEvidence,
            String workEvidence, String orgOtherFlag) {
        this.id = id;
        this.BS02 = BS02;
        this.BS03 = BS03;
        this.BS04 = BS04;
        this.BS05 = BS05;
        this.BS06 = BS06;
        this.BS07 = BS07;
        this.name = name;
        this.orgCode = orgCode;
        this.address = address;
        this.phone = phone;
        this.sort = sort;
        this.orgCadreNum = orgCadreNum;
        this.orgEvidence = orgEvidence;
        this.workEvidence = workEvidence;
        this.orgOtherFlag = orgOtherFlag;
    }

    @Generated(hash = 2061818262)
    public OrgEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getBS04() {
        return BS04;
    }

    public void setBS04(int BS04) {
        this.BS04 = BS04;
    }

    public int getBS05() {
        return BS05;
    }

    public void setBS05(int BS05) {
        this.BS05 = BS05;
    }

    public int getBS06() {
        return BS06;
    }

    public void setBS06(int BS06) {
        this.BS06 = BS06;
    }

    public int getBS07() {
        return BS07;
    }

    public void setBS07(int BS07) {
        this.BS07 = BS07;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrgCadreNum() {
        return orgCadreNum;
    }

    public void setOrgCadreNum(String orgCadreNum) {
        this.orgCadreNum = orgCadreNum;
    }

    public String getOrgEvidence() {
        return orgEvidence;
    }

    public void setOrgEvidence(String orgEvidence) {
        this.orgEvidence = orgEvidence;
    }

    public String getWorkEvidence() {
        return workEvidence;
    }

    public void setWorkEvidence(String workEvidence) {
        this.workEvidence = workEvidence;
    }

    public String getOrgOtherFlag() {
        return orgOtherFlag;
    }

    public void setOrgOtherFlag(String orgOtherFlag) {
        this.orgOtherFlag = orgOtherFlag;
    }
}
