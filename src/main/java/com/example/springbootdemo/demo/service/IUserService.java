package com.example.springbootdemo.demo.service;

import com.example.springbootdemo.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Package: com.example.springbootdemo.demo.service
 * @Description: <服务类>
 * @Author: xz
 * @CreateDate: 2021-11-15
 * @UpdateUser: xz
 * @UpdateDate: 2021-11-15
 * @UpdateRemark: <>
 * @Version: 1.0
 */
public interface IUserService extends IService<User> {

        /**
       * 查询
       *
       * @param model
       * @return
       */
        List<User> list(User model);

        /**
        * 分页查询
        *
        * @param model
        * @param pageNum  第几页
        * @param pageSize 每页数量
        * @return
        */
        IPage<User> pageList(User model, Integer pageNum, Integer pageSize);

        }

