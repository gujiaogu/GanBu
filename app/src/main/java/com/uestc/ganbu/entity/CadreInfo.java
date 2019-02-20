package com.uestc.ganbu.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "tc01")
public class CadreInfo implements Parcelable {

    @Property(nameInDb = "BS01")
    @Id
    private Long _id;//sqlite的Cursor必须要有一个_id才能查询
    private String BS02;
    private String BS03;
    private long BS04;
    private long BS05;
    private int BS06;

    // 姓名
    @Property(nameInDb = "A0101")
    private String name;

    // 曾用名
    @Property(nameInDb = "A0104")
    private String formerName;

    // 性别
    @Property(nameInDb = "A0107")
    private String sex;

    // 出生日期
    @Property(nameInDb = "A0111")
    private String birthDay;

    // 籍贯
    @Property(nameInDb = "A0114")
    private String nativePlace;

    // 出生地
    @Property(nameInDb = "A0117")
    private String birthplace;

    // 民族
    @Property(nameInDb = "A0121")
    private String nation;

    // 健康状况
    @Property(nameInDb = "A0124")
    private String health;

    // 婚姻状况
    @Property(nameInDb = "A0127")
    private String maritalStatus;

    // 参加工作日期
    @Property(nameInDb = "A0141")
    private String workTime;

    // 移动电话
    @Property(nameInDb = "A0148")
    private String phone;

    // 户籍所在地
    @Property(nameInDb = "A0171")
    private String placeOfDomicile;

    // 身份证号
    @Property(nameInDb = "A0177")
    private String idNumber;

    // 政治面貌
    @Property(nameInDb = "A2205")
    private String politicalStatus;

    // 参加组织日期
    @Property(nameInDb = "A2210")
    private String joinOrganizationTime;

    // 专业技术职务
    @Property(nameInDb = "A1005")
    private String titleOfTechnicalPost;

    //主职务id
    @Property(nameInDb = "A0703")
    private String postTitle;

    // 主职务名称
    @Property(nameInDb = "A0704")
    private String postTitleDesc;

    // 职务级别
    @Property(nameInDb = "A0901")
    private String postLevel;

    // 任现职时间
    @Property(nameInDb = "A0708")
    private String postTitleTime;

    // 任职机构
    @Property(nameInDb = "A0711")
    private String orgId;

    // 身份类别
    @Property(nameInDb = "C0101")
    private String identityType;

    // 其他身份
    @Property(nameInDb = "C0102")
    private String otherIdentities;

    // 全日学历
    @Property(nameInDb = "C0103")
    private String fullTimeEducation;

    // 全日学位
    @Property(nameInDb = "C0104")
    private String fullTimeDegree;

    // 在职学历
    @Property(nameInDb = "C0105")
    private String inServiceEducation;

    // 在职学位
    @Property(nameInDb = "C0106")
    private String inServiceDegree;

    // 毕业院校(全日)
    @Property(nameInDb = "C0107")
    private String fullTimeSchool;

    // 系及专业 (全日)
    @Property(nameInDb = "C0108")
    private String fullTimeMajor;

    // 毕业院校(在职)
    @Property(nameInDb = "C0109")
    private String inServiceSchool;

    // 系及专业 (在职)
    @Property(nameInDb = "C0110")
    private String inServiceMajor;

    // 熟悉专业有何专长（审批表）
    @Property(nameInDb = "C0111")
    private String specialty;

    // 奖惩记录（审批表）
    @Property(nameInDb = "C0112")
    private String rewardAndPunishment;

    // 首任同级职务时间
    @Property(nameInDb = "C0113")
    private String postLevelTime;

    // 头像
    @Property(nameInDb = "C0114")
    private String photo;

    // 佐证
    @Property(nameInDb = "C0115")
    private String evidence;

    // ------扩展字段
    // 其他民主党派(政治面貌)
    @Property(nameInDb = "C0180")
    private String extAttribute00;
    // 分工
    @Property(nameInDb = "C0181")
    private String extAttribute01;
    // 领导, 非领导
    @Property(nameInDb = "C0182")
    private String extAttribute02;
    @Property(nameInDb = "C0183")
    private String extAttribute03;
    @Property(nameInDb = "C0184")
    private String extAttribute04;
    @Property(nameInDb = "C0185")
    private String extAttribute05;
    @Property(nameInDb = "C0186")
    private String extAttribute06;
    @Property(nameInDb = "C0187")
    private String extAttribute07;
    @Property(nameInDb = "C0188")
    private String extAttribute08;
    // 干部显示顺序
    @Property(nameInDb = "C0189")
    private String extAttribute09;

    // ------end扩展字段

    // 干部类型(0=正常干部; 10=后备干部; 20=挂职干部)
    @Property(nameInDb = "C0190")
    private String cadreType;

    @Generated(hash = 936102868)
    public CadreInfo(Long _id, String BS02, String BS03, long BS04, long BS05,
            int BS06, String name, String formerName, String sex, String birthDay,
            String nativePlace, String birthplace, String nation, String health,
            String maritalStatus, String workTime, String phone,
            String placeOfDomicile, String idNumber, String politicalStatus,
            String joinOrganizationTime, String titleOfTechnicalPost,
            String postTitle, String postTitleDesc, String postLevel,
            String postTitleTime, String orgId, String identityType,
            String otherIdentities, String fullTimeEducation, String fullTimeDegree,
            String inServiceEducation, String inServiceDegree,
            String fullTimeSchool, String fullTimeMajor, String inServiceSchool,
            String inServiceMajor, String specialty, String rewardAndPunishment,
            String postLevelTime, String photo, String evidence,
            String extAttribute00, String extAttribute01, String extAttribute02,
            String extAttribute03, String extAttribute04, String extAttribute05,
            String extAttribute06, String extAttribute07, String extAttribute08,
            String extAttribute09, String cadreType) {
        this._id = _id;
        this.BS02 = BS02;
        this.BS03 = BS03;
        this.BS04 = BS04;
        this.BS05 = BS05;
        this.BS06 = BS06;
        this.name = name;
        this.formerName = formerName;
        this.sex = sex;
        this.birthDay = birthDay;
        this.nativePlace = nativePlace;
        this.birthplace = birthplace;
        this.nation = nation;
        this.health = health;
        this.maritalStatus = maritalStatus;
        this.workTime = workTime;
        this.phone = phone;
        this.placeOfDomicile = placeOfDomicile;
        this.idNumber = idNumber;
        this.politicalStatus = politicalStatus;
        this.joinOrganizationTime = joinOrganizationTime;
        this.titleOfTechnicalPost = titleOfTechnicalPost;
        this.postTitle = postTitle;
        this.postTitleDesc = postTitleDesc;
        this.postLevel = postLevel;
        this.postTitleTime = postTitleTime;
        this.orgId = orgId;
        this.identityType = identityType;
        this.otherIdentities = otherIdentities;
        this.fullTimeEducation = fullTimeEducation;
        this.fullTimeDegree = fullTimeDegree;
        this.inServiceEducation = inServiceEducation;
        this.inServiceDegree = inServiceDegree;
        this.fullTimeSchool = fullTimeSchool;
        this.fullTimeMajor = fullTimeMajor;
        this.inServiceSchool = inServiceSchool;
        this.inServiceMajor = inServiceMajor;
        this.specialty = specialty;
        this.rewardAndPunishment = rewardAndPunishment;
        this.postLevelTime = postLevelTime;
        this.photo = photo;
        this.evidence = evidence;
        this.extAttribute00 = extAttribute00;
        this.extAttribute01 = extAttribute01;
        this.extAttribute02 = extAttribute02;
        this.extAttribute03 = extAttribute03;
        this.extAttribute04 = extAttribute04;
        this.extAttribute05 = extAttribute05;
        this.extAttribute06 = extAttribute06;
        this.extAttribute07 = extAttribute07;
        this.extAttribute08 = extAttribute08;
        this.extAttribute09 = extAttribute09;
        this.cadreType = cadreType;
    }

    @Generated(hash = 1007958252)
    public CadreInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlaceOfDomicile() {
        return placeOfDomicile;
    }

    public void setPlaceOfDomicile(String placeOfDomicile) {
        this.placeOfDomicile = placeOfDomicile;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getJoinOrganizationTime() {
        return joinOrganizationTime;
    }

    public void setJoinOrganizationTime(String joinOrganizationTime) {
        this.joinOrganizationTime = joinOrganizationTime;
    }

    public String getTitleOfTechnicalPost() {
        return titleOfTechnicalPost;
    }

    public void setTitleOfTechnicalPost(String titleOfTechnicalPost) {
        this.titleOfTechnicalPost = titleOfTechnicalPost;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostTitleDesc() {
        return postTitleDesc;
    }

    public void setPostTitleDesc(String postTitleDesc) {
        this.postTitleDesc = postTitleDesc;
    }

    public String getPostLevel() {
        return postLevel;
    }

    public void setPostLevel(String postLevel) {
        this.postLevel = postLevel;
    }

    public String getPostTitleTime() {
        return postTitleTime;
    }

    public void setPostTitleTime(String postTitleTime) {
        this.postTitleTime = postTitleTime;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getOtherIdentities() {
        return otherIdentities;
    }

    public void setOtherIdentities(String otherIdentities) {
        this.otherIdentities = otherIdentities;
    }

    public String getFullTimeEducation() {
        return fullTimeEducation;
    }

    public void setFullTimeEducation(String fullTimeEducation) {
        this.fullTimeEducation = fullTimeEducation;
    }

    public String getFullTimeDegree() {
        return fullTimeDegree;
    }

    public void setFullTimeDegree(String fullTimeDegree) {
        this.fullTimeDegree = fullTimeDegree;
    }

    public String getInServiceEducation() {
        return inServiceEducation;
    }

    public void setInServiceEducation(String inServiceEducation) {
        this.inServiceEducation = inServiceEducation;
    }

    public String getInServiceDegree() {
        return inServiceDegree;
    }

    public void setInServiceDegree(String inServiceDegree) {
        this.inServiceDegree = inServiceDegree;
    }

    public String getFullTimeSchool() {
        return fullTimeSchool;
    }

    public void setFullTimeSchool(String fullTimeSchool) {
        this.fullTimeSchool = fullTimeSchool;
    }

    public String getFullTimeMajor() {
        return fullTimeMajor;
    }

    public void setFullTimeMajor(String fullTimeMajor) {
        this.fullTimeMajor = fullTimeMajor;
    }

    public String getInServiceSchool() {
        return inServiceSchool;
    }

    public void setInServiceSchool(String inServiceSchool) {
        this.inServiceSchool = inServiceSchool;
    }

    public String getInServiceMajor() {
        return inServiceMajor;
    }

    public void setInServiceMajor(String inServiceMajor) {
        this.inServiceMajor = inServiceMajor;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getRewardAndPunishment() {
        return rewardAndPunishment;
    }

    public void setRewardAndPunishment(String rewardAndPunishment) {
        this.rewardAndPunishment = rewardAndPunishment;
    }

    public String getPostLevelTime() {
        return postLevelTime;
    }

    public void setPostLevelTime(String postLevelTime) {
        this.postLevelTime = postLevelTime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getExtAttribute00() {
        return extAttribute00;
    }

    public void setExtAttribute00(String extAttribute00) {
        this.extAttribute00 = extAttribute00;
    }

    public String getExtAttribute01() {
        return extAttribute01;
    }

    public void setExtAttribute01(String extAttribute01) {
        this.extAttribute01 = extAttribute01;
    }

    public String getExtAttribute02() {
        return extAttribute02;
    }

    public void setExtAttribute02(String extAttribute02) {
        this.extAttribute02 = extAttribute02;
    }

    public String getExtAttribute03() {
        return extAttribute03;
    }

    public void setExtAttribute03(String extAttribute03) {
        this.extAttribute03 = extAttribute03;
    }

    public String getExtAttribute04() {
        return extAttribute04;
    }

    public void setExtAttribute04(String extAttribute04) {
        this.extAttribute04 = extAttribute04;
    }

    public String getExtAttribute05() {
        return extAttribute05;
    }

    public void setExtAttribute05(String extAttribute05) {
        this.extAttribute05 = extAttribute05;
    }

    public String getExtAttribute06() {
        return extAttribute06;
    }

    public void setExtAttribute06(String extAttribute06) {
        this.extAttribute06 = extAttribute06;
    }

    public String getExtAttribute07() {
        return extAttribute07;
    }

    public void setExtAttribute07(String extAttribute07) {
        this.extAttribute07 = extAttribute07;
    }

    public String getExtAttribute08() {
        return extAttribute08;
    }

    public void setExtAttribute08(String extAttribute08) {
        this.extAttribute08 = extAttribute08;
    }

    public String getExtAttribute09() {
        return extAttribute09;
    }

    public void setExtAttribute09(String extAttribute09) {
        this.extAttribute09 = extAttribute09;
    }

    public String getCadreType() {
        return cadreType;
    }

    public void setCadreType(String cadreType) {
        this.cadreType = cadreType;
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
        return this.BS06;
    }

    public void setBS06(int BS06) {
        this.BS06 = BS06;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this._id);
        dest.writeString(this.BS02);
        dest.writeString(this.BS03);
        dest.writeLong(this.BS04);
        dest.writeLong(this.BS05);
        dest.writeInt(this.BS06);
        dest.writeString(this.name);
        dest.writeString(this.formerName);
        dest.writeString(this.sex);
        dest.writeString(this.birthDay);
        dest.writeString(this.nativePlace);
        dest.writeString(this.birthplace);
        dest.writeString(this.nation);
        dest.writeString(this.health);
        dest.writeString(this.maritalStatus);
        dest.writeString(this.workTime);
        dest.writeString(this.phone);
        dest.writeString(this.placeOfDomicile);
        dest.writeString(this.idNumber);
        dest.writeString(this.politicalStatus);
        dest.writeString(this.joinOrganizationTime);
        dest.writeString(this.titleOfTechnicalPost);
        dest.writeString(this.postTitle);
        dest.writeString(this.postTitleDesc);
        dest.writeString(this.postLevel);
        dest.writeString(this.postTitleTime);
        dest.writeString(this.orgId);
        dest.writeString(this.identityType);
        dest.writeString(this.otherIdentities);
        dest.writeString(this.fullTimeEducation);
        dest.writeString(this.fullTimeDegree);
        dest.writeString(this.inServiceEducation);
        dest.writeString(this.inServiceDegree);
        dest.writeString(this.fullTimeSchool);
        dest.writeString(this.fullTimeMajor);
        dest.writeString(this.inServiceSchool);
        dest.writeString(this.inServiceMajor);
        dest.writeString(this.specialty);
        dest.writeString(this.rewardAndPunishment);
        dest.writeString(this.postLevelTime);
        dest.writeString(this.photo);
        dest.writeString(this.evidence);
        dest.writeString(this.extAttribute00);
        dest.writeString(this.extAttribute01);
        dest.writeString(this.extAttribute02);
        dest.writeString(this.extAttribute03);
        dest.writeString(this.extAttribute04);
        dest.writeString(this.extAttribute05);
        dest.writeString(this.extAttribute06);
        dest.writeString(this.extAttribute07);
        dest.writeString(this.extAttribute08);
        dest.writeString(this.extAttribute09);
        dest.writeString(this.cadreType);
    }

    protected CadreInfo(Parcel in) {
        this._id = (Long) in.readValue(Long.class.getClassLoader());
        this.BS02 = in.readString();
        this.BS03 = in.readString();
        this.BS04 = in.readLong();
        this.BS05 = in.readLong();
        this.BS06 = in.readInt();
        this.name = in.readString();
        this.formerName = in.readString();
        this.sex = in.readString();
        this.birthDay = in.readString();
        this.nativePlace = in.readString();
        this.birthplace = in.readString();
        this.nation = in.readString();
        this.health = in.readString();
        this.maritalStatus = in.readString();
        this.workTime = in.readString();
        this.phone = in.readString();
        this.placeOfDomicile = in.readString();
        this.idNumber = in.readString();
        this.politicalStatus = in.readString();
        this.joinOrganizationTime = in.readString();
        this.titleOfTechnicalPost = in.readString();
        this.postTitle = in.readString();
        this.postTitleDesc = in.readString();
        this.postLevel = in.readString();
        this.postTitleTime = in.readString();
        this.orgId = in.readString();
        this.identityType = in.readString();
        this.otherIdentities = in.readString();
        this.fullTimeEducation = in.readString();
        this.fullTimeDegree = in.readString();
        this.inServiceEducation = in.readString();
        this.inServiceDegree = in.readString();
        this.fullTimeSchool = in.readString();
        this.fullTimeMajor = in.readString();
        this.inServiceSchool = in.readString();
        this.inServiceMajor = in.readString();
        this.specialty = in.readString();
        this.rewardAndPunishment = in.readString();
        this.postLevelTime = in.readString();
        this.photo = in.readString();
        this.evidence = in.readString();
        this.extAttribute00 = in.readString();
        this.extAttribute01 = in.readString();
        this.extAttribute02 = in.readString();
        this.extAttribute03 = in.readString();
        this.extAttribute04 = in.readString();
        this.extAttribute05 = in.readString();
        this.extAttribute06 = in.readString();
        this.extAttribute07 = in.readString();
        this.extAttribute08 = in.readString();
        this.extAttribute09 = in.readString();
        this.cadreType = in.readString();
    }

    public static final Parcelable.Creator<CadreInfo> CREATOR = new Parcelable.Creator<CadreInfo>() {
        @Override
        public CadreInfo createFromParcel(Parcel source) {
            return new CadreInfo(source);
        }

        @Override
        public CadreInfo[] newArray(int size) {
            return new CadreInfo[size];
        }
    };
}
