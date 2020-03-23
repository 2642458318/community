package com.www.community.service.local.mail;

import com.www.community.model.entity.mail.MailSendLog;

import java.util.Date;
import java.util.List;

public interface MailSendLogService {
    Integer updateMailSendLogStatus(String msgId, Integer status);

    Integer insert(MailSendLog mailSendLog);

    List<MailSendLog> getMailSendLogByStatus();

    Integer updateCount(String msgId, Date date);
}
