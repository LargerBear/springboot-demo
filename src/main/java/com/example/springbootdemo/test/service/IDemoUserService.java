package com.example.springbootdemo.test.service;

import com.example.springbootdemo.test.entity.DemoUser;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Package: com.example.springbootdemo.test.service
 * @Description: <服务类>
 * @Author: xz
 * @CreateDate: 2021-11-15
 * @UpdateUser: xz
 * @UpdateDate: 2021-11-15
 * @UpdateRemark: <>
 * @Version: 1.0
 */
public interface IDemoUserService extends IService<DemoUser> {

        /**
       * 查询
       *
       * @param model
       * @return
       */
        List<DemoUser> list(DemoUser model);

        /**
        * 分页查询
        *
        * @param model
        * @param pageNum  第几页
        * @param pageSize 每页数量
        * @return
        */
        IPage<DemoUser> pageList(DemoUser model, Integer pageNum, Integer pageSize);

        }

