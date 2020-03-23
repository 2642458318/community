package com.www.community.task.mail;

import com.www.community.model.entity.mail.MailSendLog;
import com.www.community.model.param.MailParam;
import com.www.community.service.local.mail.MailSendLogService;
import com.www.community.service.local.news.NewsCategoryService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

//@Component
public class MailSendLogTask {

    @Autowired
    private MailSendLogService mailSendLogService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    NewsCategoryService newsCategoryService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void mailResendTask() {
        List<MailSendLog> log = mailSendLogService.getMailSendLogByStatus();
        if (log ==null || log.size()==0){
            return;
        }
        log.forEach(mailSendLog -> {
            if (mailSendLog.getCount() >= 3) {
                //设置该条消息发送失败
                mailSendLogService.updateMailSendLogStatus(mailSendLog.getMsgId(),2);
            }else {
                mailSendLogService.updateCount(mailSendLog.getMsgId(),new Date());
                rabbitTemplate.convertAndSend(MailParam.MAIL_EXCHANGE_NAME, MailParam.MAIL_ROUTING_KEY_NAME,mailSendLog.getEmpId(),new CorrelationData(mailSendLog.getMsgId()));
            }
        });
    }
}
