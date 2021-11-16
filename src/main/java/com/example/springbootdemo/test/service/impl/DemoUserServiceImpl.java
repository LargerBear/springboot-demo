package com.example.springbootdemo.test.service.impl;

import com.example.springbootdemo.test.entity.DemoUser;
import com.example.springbootdemo.test.mapper.DemoUserMapper;
import com.example.springbootdemo.test.service.IDemoUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * @Package: com.example.springbootdemo.test.service.impl
 * @Description: <服务实现类>
 * @Author: xz
 * @CreateDate: 2021-11-15
 * @UpdateUser: xz
 * @UpdateDate: 2021-11-15
 * @UpdateRemark: <>
 * @Version: 1.0
 */
        @Service
        public class DemoUserServiceImpl extends ServiceImpl<DemoUserMapper, DemoUser> implements IDemoUserService {

            @Override
            public List< DemoUser> list(DemoUser model) {
            QueryWrapper< DemoUser> wrapper = new QueryWrapper();
            return super.list(wrapper);
            }

            @Override
            public IPage< DemoUser> pageList( DemoUser model, Integer pageNum, Integer pageSize) {

            QueryWrapper< DemoUser> wrapper = new QueryWrapper(model);
            return this.page(new Page<>(pageNum, pageSize), wrapper);
            }
        }

