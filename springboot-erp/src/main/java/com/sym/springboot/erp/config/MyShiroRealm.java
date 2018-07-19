package com.sym.springboot.erp.config;

import com.sym.springboot.domain.entity.Resource;
import com.sym.springboot.domain.entity.User;
import com.sym.springboot.service.ResourceService;
import com.sym.springboot.service.UserServie;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/28
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserServie sysUserServie;

    @Autowired
    private ResourceService resourceService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = sysUserServie.getUser(username);
        String salt = user.getSalt();
        if (user==null) {
            throw new UnknownAccountException();
        }
        /*if (0==user.getEnable()) {
            throw new LockedAccountException(); // 帐号锁定
        }*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(salt),
                getName()  //realm name
        );
        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", user);
        session.setAttribute("userSessionId", user.getId());
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> map = new HashMap<String,Object>();
        List<Resource> resources = resourceService.getResource(user);
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Resource resource : resources) {
            if(StringUtils.isNotBlank(resource.getUrl())){
                info.addStringPermission(resource.getUrl());
            }
        }
        return info;
    }


}
