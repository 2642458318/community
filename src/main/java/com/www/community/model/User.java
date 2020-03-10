package com.www.community.model;

import lombok.Data;

/**
 * 网络传输层的数据模型
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreat;
    private Long gmtModified;
    private String avatarUrl;
}
