package com.www.community.model.entity.temp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TempInsurEntity {
    //预录id
    private Integer tempId;
    //操作人编码
    private String userCode;
    //投保人编码
    private String insureCode;
    //消息类型
    private String tempType;
    //产品编号
    private String productId;
    //内容
    private String content;
    //添加时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    //状态
    private String status;
    //金额
    private BigDecimal amount;
    //产品名称
    private String productName;
    //预录编号
    private String tempCode;
    //投保始期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date insureDateFrom;
    //投保止期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date insureDateEnd;
    //被保人名称
    private String insuredName;
}
