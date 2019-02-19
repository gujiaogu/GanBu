package com.uestc.ganbu.entity;

/**
 * ts04 组织机构表 编码
 * @author: 61jun.com
 * @create: 2018-05-17
 */
public interface SysOrg {

    // 单位名称
    String name = "B0105";

    // 组织机构代码
    String orgCode = "B0110";

    // 单位地址
    String address = "B0120";

    // 单位电话号码
    String phone = "B0125";

    // 排序
    String sort = "S0401";

    //单位人数
    String orgCadreNum="S0402";

    // 佐证
    String orgEvidence = "S0403";

    //分工文件
    String workEvidence="S0404";

    String orgOtherFlag="S0405";
}
