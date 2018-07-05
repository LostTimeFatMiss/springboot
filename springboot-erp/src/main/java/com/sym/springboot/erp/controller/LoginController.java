package com.sym.springboot.erp.controller;

import com.sym.springboot.domain.SysUser;
import com.sym.springboot.service.SysUserServie;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/29
 */
@Controller
public class LoginController {

    @Autowired
    private SysUserServie sysUserServie;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, String username, String password, Model model) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            return "index";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "success";
        } catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            return "error";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            model.addAttribute("msg", "用户或密码不正确！");
            return "login";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(HttpServletRequest request, String username, String password, Model model) {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String newPassword = new SimpleHash("MD5", ByteSource.Util.bytes(password), uuid, 2).toHex();
        System.out.println(newPassword + "----------------------------");
        SysUser sysUser = new SysUser();
        sysUser.setEnabled(true);
        sysUser.setPassword(newPassword);
        sysUser.setSalt(uuid);
        sysUser.setUsername(username);
        Integer id = sysUserServie.register(sysUser);
        System.out.println(id);
        return "success";
    }

}
