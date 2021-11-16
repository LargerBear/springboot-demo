package com.example.springbootdemo.demo.controller;

import com.example.springbootdemo.demo.entity.User;
import com.example.springbootdemo.demo.service.IUserService;
import com.example.springbootdemo.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @Package: com.example.springbootdemo.demo.entity.User
 * @Description: <前端控制器>
 * @Author: xz
 * @CreateDate: 2021-11-15
 * @UpdateUser: xz
 * @UpdateDate: 2021-11-15
 * @UpdateRemark: <>
 * @Version: 1.0
 */
@RestController
@Api(tags = "User-相关接口")
@RequestMapping(value = "User")
public class UserController {

private static final Logger logger = LoggerFactory.getLogger(UserController.class);

@Autowired
private IUserService iIUserService;

@GetMapping("{id}")
@ApiOperation(value = "获取某一实体")
public R getIUserServiceDetails(@PathVariable Integer id) {
        return R.ok(iIUserService.getById(id));
        }


/**
  * 列表查询（非分页）
  *
  * @return
  */
@RequestMapping("/list")
public R list() {
    User model = new  User();
        List<User> list =  iIUserService.list(model);
        // todo 再包装一层
        return  R.ok(list);
        }


/**
* 列表查询（分页）
*
* @return
*/
@RequestMapping("/pageList")
public R pageList(Integer pageNum, Integer pageSize) {

    User model = new  User();
        IPage<User> page = iIUserService.pageList(model, pageNum, pageSize);
        // todo 再包装一层
        return R.ok(page);
        }

@PostMapping
@ApiOperation(value = "新增数据")
public R saveIUserService(@RequestBody User dto) {
        return R.ok(iIUserService.save(dto));
        }

@PutMapping("{id}")
@ApiOperation(value = "修改数据")
public R modifyIUserService(@RequestBody User dto, @PathVariable Integer id) {
        dto.setId(id);
        return R.ok(iIUserService.updateById(dto)) ;
        }

@DeleteMapping("batch")
@ApiOperation(value = "批量删除数据")
public R batchRemoveIUserService(@RequestParam(value = "ids") List<Integer> ids) {
        return R.ok(iIUserService.removeByIds(ids)) ;
        }

@DeleteMapping("{id}")
@ApiOperation(value = "删除数据")
public R removeIUserService(@PathVariable Integer id) {
        return R.ok(iIUserService.removeById(id)) ;
        }
        }
