package com.www.community.service.local.hr.impl;

import com.www.community.dao.mapper.hr.HrMapper;
import com.www.community.model.entity.hr.Hr;
import com.www.community.service.local.hr.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HrSeriviceImpl implements HrService, UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    /**
     * 根据用户名加载hr对象
     *
     * @param
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        //返回hr对象,不需要管密码对不对，security自己进行密码比较
        return hr;
    }
}
