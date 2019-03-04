package com.uestc.ganbu.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "mobile")
public class MobilePhoneEntity {

    @Id
    private int id;
    private String mobile;

    @Generated(hash = 329797677)
    public MobilePhoneEntity(int id, String mobile) {
        this.id = id;
        this.mobile = mobile;
    }

    @Generated(hash = 1024456143)
    public MobilePhoneEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
