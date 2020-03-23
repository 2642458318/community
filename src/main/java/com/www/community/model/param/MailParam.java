package com.www.community.model.param;

public class MailParam {
    /**
     * 消息投递中
     */
    public static Integer DELIVERING = 0;
    /**
     * 消息投递成功
     */
    public static Integer SUCCESS = 1;
    /**
     * 消息投递失败
     */
    public static Integer FAILURE = 2;
    /**
     * 最大重试次数
     */
    public static Integer MAX_TRY_COUNT = 3;
    /**
     * 消息超时时间
     */
    public static Integer MSG_TIMEOUT = 1;
    public static String MAIL_QUEUE_NAME = "javaboy.mail.queue";
    public static String MAIL_EXCHANGE_NAME = "javaboy.mail.exchange";
    public static String MAIL_ROUTING_KEY_NAME = "javaboy.mail.routing.key";
}
