package com.uestc.ganbu.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "tc06")
public class CadreAppraisal {

    @Property(nameInDb = "BS01")
    @Id
    private Long _id;//sqlite的Cursor必须要有一个_id才能查询
    private String BS02;
    private String BS03;
    private long BS04;
    private long BS05;
    private int BS06;

    private String A2505;
    private String A2520;
    private String C0601;
    private String C0602;
    private String C0611;
    private String C0612;

    @Generated(hash = 489394128)
    public CadreAppraisal(Long _id, String BS02, String BS03, long BS04, long BS05,
            int BS06, String A2505, String A2520, String C0601, String C0602,
            String C0611, String C0612) {
        this._id = _id;
        this.BS02 = BS02;
        this.BS03 = BS03;
        this.BS04 = BS04;
        this.BS05 = BS05;
        this.BS06 = BS06;
        this.A2505 = A2505;
        this.A2520 = A2520;
        this.C0601 = C0601;
        this.C0602 = C0602;
        this.C0611 = C0611;
        this.C0612 = C0612;
    }

    @Generated(hash = 736457719)
    public CadreAppraisal() {
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

    public String getA2505() {
        return A2505;
    }

    public void setA2505(String a2505) {
        A2505 = a2505;
    }

    public String getA2520() {
        return A2520;
    }

    public void setA2520(String a2520) {
        A2520 = a2520;
    }

    public String getC0601() {
        return C0601;
    }

    public void setC0601(String c0601) {
        C0601 = c0601;
    }

    public String getC0602() {
        return C0602;
    }

    public void setC0602(String c0602) {
        C0602 = c0602;
    }

    public String getC0611() {
        return C0611;
    }

    public void setC0611(String c0611) {
        C0611 = c0611;
    }

    public String getC0612() {
        return C0612;
    }

    public void setC0612(String c0612) {
        C0612 = c0612;
    }
}
