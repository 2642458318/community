package com.www.community.model.entity.mail;

import lombok.Data;

import java.util.Date;
@Data
public class MailSendLog {
    //消息id
    private String msgId;
    //关联员工id
    private Integer empId;
    //0 消息投递中 1 投递成功 2 投递失败
    private Integer status;
    private String routekey;
    private String exchange;
    //重试次数
    private Integer count;
    //重试时间
    private Date tryTime;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
