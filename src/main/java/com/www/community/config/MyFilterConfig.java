package com.www.community.config;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;

/**
 * 提供权限控制，自定义拦截
 * 作用：根据用户传来的请求地址，分析出请求需要的角色
 */
public class MyFilterConfig implements FilterInvocationSecurityMetadataSource {
    /**
     * collection 当前请求需要的角色
     * @param
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object obj) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) obj).getRequestUrl();
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
