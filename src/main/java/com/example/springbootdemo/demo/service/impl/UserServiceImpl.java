package com.example.springbootdemo.demo.service.impl;

import com.example.springbootdemo.demo.entity.User;
import com.example.springbootdemo.demo.mapper.UserMapper;
import com.example.springbootdemo.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * @Package: com.example.springbootdemo.demo.service.impl
 * @Description: <服务实现类>
 * @Author: xz
 * @CreateDate: 2021-11-15
 * @UpdateUser: xz
 * @UpdateDate: 2021-11-15
 * @UpdateRemark: <>
 * @Version: 1.0
 */
        @Service
        public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

            @Override
            public List< User> list(User model) {
            QueryWrapper< User> wrapper = new QueryWrapper();
            return super.list(wrapper);
            }

            @Override
            public IPage< User> pageList( User model, Integer pageNum, Integer pageSize) {

            QueryWrapper< User> wrapper = new QueryWrapper(model);
            return this.page(new Page<>(pageNum, pageSize), wrapper);
            }
        }

