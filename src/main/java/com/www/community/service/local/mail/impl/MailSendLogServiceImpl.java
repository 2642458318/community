package com.www.community.service.local.mail.impl;

import com.www.community.dao.mapper.mail.MailSendLogMapper;
import com.www.community.model.entity.mail.MailSendLog;
import com.www.community.service.local.mail.MailSendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MailSendLogServiceImpl implements MailSendLogService {

    @Autowired
    private MailSendLogMapper mailSendLogMapper;
    @Override
    public Integer updateMailSendLogStatus(String msgId, Integer status) {
        mailSendLogMapper.updateMailSendLogStatus(msgId,status);
        return null;
    }

    @Override
    public Integer insert(MailSendLog mailSendLog) {
        return mailSendLogMapper.insert(mailSendLog);
    }

    @Override
    public List<MailSendLog> getMailSendLogByStatus() {
        return mailSendLogMapper.getMailSendLogByStatus();
    }

    @Override
    public Integer updateCount(String msgId, Date date) {
        return mailSendLogMapper.updateCount(msgId,date);
    }
}
