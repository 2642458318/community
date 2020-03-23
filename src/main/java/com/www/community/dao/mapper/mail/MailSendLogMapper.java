package com.www.community.dao.mapper.mail;

import com.www.community.model.entity.mail.MailSendLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MailSendLogMapper {
    Integer updateMailSendLogStatus(@Param("msgId") String msgId,@Param("status") Integer status);

    Integer insert(MailSendLog mailSendLog);

    List<MailSendLog> getMailSendLogByStatus();

    Integer updateCount(@Param("msgId") String msgId,@Param("date") Date date);
}
