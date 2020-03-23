package com.www.community.service.local.news.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.www.community.dao.mapper.news.NewsCategoryMapper;
import com.www.community.exception.BizException;
import com.www.community.model.entity.mail.MailSendLog;
import com.www.community.model.entity.news.NewsCategoryEntity;
import com.www.community.model.param.MailParam;
import com.www.community.model.param.news.AddNewsCategoryParam;
import com.www.community.model.param.news.AlterNewsCategoryParam;
import com.www.community.service.local.mail.MailSendLogService;
import com.www.community.service.local.news.NewsCategoryService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NewsCategoryServiceImpl implements NewsCategoryService {
    @Autowired
    private NewsCategoryMapper newsCategoryMapper;

    @Autowired
    private MailSendLogService mailSendLogService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 资讯分类添加
     *
     * @param addNewsCategoryParam
     * @return
     */
    public int addCategory(AddNewsCategoryParam addNewsCategoryParam) {
        String categoryCode = newsCategoryMapper.selectIsCategoryCode(addNewsCategoryParam.getCategoryCode());
        if (categoryCode != null) {
            throw new BizException("分类编码已存在");
        }
        int i = newsCategoryMapper.addCategory(addNewsCategoryParam);
        if (i == 1) {
            System.out.println("创建id"+addNewsCategoryParam.getCategoryId());

            //生产消息ID
            String msgId = UUID.randomUUID().toString();
            MailSendLog mailSendLog = new MailSendLog();
            mailSendLog.setMsgId(msgId);
            mailSendLog.setCreateTime(new Date());
            mailSendLog.setExchange(MailParam.MAIL_EXCHANGE_NAME);
            mailSendLog.setRoutekey(MailParam.MAIL_ROUTING_KEY_NAME);
            mailSendLog.setEmpId(addNewsCategoryParam.getCategoryId());
            mailSendLog.setTryTime(new Date(System.currentTimeMillis()+1000*60*MailParam.MSG_TIMEOUT));
            mailSendLogService.insert(mailSendLog);
            rabbitTemplate.convertAndSend(MailParam.MAIL_EXCHANGE_NAME,MailParam.MAIL_ROUTING_KEY_NAME,addNewsCategoryParam.getCategoryId(),new CorrelationData());
        }
        return i;
    }

    /**
     * 资讯分类删除
     *
     * @param categoryId
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteCategory(Integer[] categoryId) {
        if (categoryId == null || categoryId.length == 0) {
            throw new BizException("请输入要删除的ID");
        }
        for (Integer integer : categoryId) {
            newsCategoryMapper.deleteCategory(integer);
        }
    }

    /**
     * 资讯分类修改
     *
     * @param alterNewsCategoryParam
     */
    @Override
    public void updateNewsItemCategory(AlterNewsCategoryParam alterNewsCategoryParam) {
        int i = newsCategoryMapper.updateNewsCategory(alterNewsCategoryParam);
        if (i == 0) {
            throw new BizException("修改资讯分类失败");
        }
    }

    /**
     * 咨询分类查找
     *
     * @param parentId
     * @param categoryName
     * @param pn
     * @param ps
     * @return
     */
    @Override
    public PageInfo<NewsCategoryEntity> categoryList(Integer parentId, String categoryName, Integer pn, Integer ps) {
        PageHelper.startPage(pn, ps);
        List<NewsCategoryEntity> newsCategoryEntities = newsCategoryMapper.selectNewsCategoryByCondition(parentId, categoryName);
        return new PageInfo<>(newsCategoryEntities);
    }

    @Override
    public List<NewsCategoryEntity> findAllRecursion() {
        List<NewsCategoryEntity> allRecursion = newsCategoryMapper.findAllRecursion();
        return allRecursion;
    }

    @Override
    public List<NewsCategoryEntity> categoryListNoPage() {
        List<NewsCategoryEntity> newsCategoryEntities = newsCategoryMapper.selectNewsCategoryByCondition(null, null);
        //判断是否有空的层级
        newsCategoryEntities.forEach(newsCategoryEntity -> {
            if (newsCategoryEntity.getLevel() == null) {
                throw new BizException("无法查询分类：部分分类层级存在空值");
            }
        });
        //按层级进行分组
        Map<Integer, List<NewsCategoryEntity>> groupByMap = newsCategoryEntities.stream().collect(Collectors.groupingBy(NewsCategoryEntity::getLevel));
        //获取一级分类
        List<NewsCategoryEntity> firstLevelList = Optional.of(groupByMap).map(groupByMap1 -> groupByMap.get(1)).orElseThrow(() -> new BizException("查询失败：一级分类为空"));
        //获取二级分类
        List<NewsCategoryEntity> secondLevelList = groupByMap.get(2);
        //获取三级分类
        List<NewsCategoryEntity> thirdLevelList = groupByMap.get(3);
        firstLevelList.forEach(newsCategoryEntity -> {
            List<NewsCategoryEntity> subList = new ArrayList<>();
            //如果一级分类CategoryId等于二级分类的parentId，则认为二级分类属于一级分类
            if (secondLevelList != null) {
                secondLevelList.forEach(newsCategoryEntity1 -> {
                    if (newsCategoryEntity1.getParentId().equals(newsCategoryEntity.getCategoryId())) {
                        subList.add(newsCategoryEntity1);
                    }
                });
                if (subList.size() != 0) {
                    newsCategoryEntity.setSubLevelList(subList);
                }
            }
        });
        return firstLevelList;

    }


}
