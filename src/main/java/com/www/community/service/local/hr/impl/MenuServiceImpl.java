package com.www.community.service.local.hr.impl;

import com.www.community.dao.mapper.hr.MenuMapper;
import com.www.community.model.entity.hr.Menu;
import com.www.community.service.local.hr.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取所有菜单数据
     * @return
     */
    @Override
    public List<Menu> getAllMenuWitchRole() {
        return menuMapper.getAllMenuWithRole();
    }
}
