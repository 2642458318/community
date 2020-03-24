package com.www.community.service.local.hr;

import com.www.community.model.entity.hr.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 获取所有菜单数据
     * @return
     */
    List<Menu> getAllMenuWitchRole();
}
