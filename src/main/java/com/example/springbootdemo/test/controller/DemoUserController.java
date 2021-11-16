package com.example.springbootdemo.test.controller;

import com.example.springbootdemo.test.entity.DemoUser;
import com.example.springbootdemo.test.service.IDemoUserService;
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
 * @Package: com.example.springbootdemo.test.entity.DemoUser
 * @Description: <前端控制器>
 * @Author: xz
 * @CreateDate: 2021-11-15
 * @UpdateUser: xz
 * @UpdateDate: 2021-11-15
 * @UpdateRemark: <>
 * @Version: 1.0
 */
@RestController
@Api(tags = "DemoUser-相关接口")
@RequestMapping(value = "DemoUser")
public class DemoUserController {

private static final Logger logger = LoggerFactory.getLogger(DemoUserController.class);

@Autowired
private IDemoUserService iIDemoUserService;

@GetMapping("{id}")
@ApiOperation(value = "获取某一实体")
public R getIDemoUserServiceDetails(@PathVariable Integer id) {
        return R.ok(iIDemoUserService.getById(id));
        }


/**
  * 列表查询（非分页）
  *
  * @return
  */
@RequestMapping("/list")
public R list() {
    DemoUser model = new  DemoUser();
        List<DemoUser> list =  iIDemoUserService.list(model);
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

    DemoUser model = new  DemoUser();
        IPage<DemoUser> page = iIDemoUserService.pageList(model, pageNum, pageSize);
        // todo 再包装一层
        return R.ok(page);
        }

@PostMapping
@ApiOperation(value = "新增数据")
public R saveIDemoUserService(@RequestBody DemoUser dto) {
        return R.ok(iIDemoUserService.save(dto));
        }

@PutMapping("{id}")
@ApiOperation(value = "修改数据")
public R modifyIDemoUserService(@RequestBody DemoUser dto, @PathVariable Integer id) {
        dto.setId(id);
        return R.ok(iIDemoUserService.updateById(dto)) ;
        }

@DeleteMapping("batch")
@ApiOperation(value = "批量删除数据")
public R batchRemoveIDemoUserService(@RequestParam(value = "ids") List<Integer> ids) {
        return R.ok(iIDemoUserService.removeByIds(ids)) ;
        }

@DeleteMapping("{id}")
@ApiOperation(value = "删除数据")
public R removeIDemoUserService(@PathVariable Integer id) {
        return R.ok(iIDemoUserService.removeById(id)) ;
        }
        }
