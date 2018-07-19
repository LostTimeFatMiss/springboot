package com.sym.springboot.service;

import com.sym.springboot.domain.entity.Resource;
import com.sym.springboot.domain.entity.User;
import com.sym.springboot.domain.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/29
 */
@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getResource(User user){

        return resourceRepository.getResource(user);
    }

}
