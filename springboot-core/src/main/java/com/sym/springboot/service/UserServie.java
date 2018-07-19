package com.sym.springboot.service;

import com.sym.springboot.domain.entity.User;
import com.sym.springboot.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/22
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServie {
    @Autowired
    private UserRepository userRepository;

    public User get() {
        return userRepository.get(1L);
    }

    public User getUser(String username) {
        return userRepository.getUser(username);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Long register(User user) {
        userRepository.register(user);
        return user.getId();
    }
}
