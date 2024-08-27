package org.staff.staffsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.staff.staffsystem.pojo.Dept;
import org.staff.staffsystem.pojo.Result;
import org.staff.staffsystem.service.DeptService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询全部部门数据
     * @return
     */
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 根据id获取数据
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id:{}获取单条记录", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 根据id删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门");
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @PutMapping
    public Result modify(@RequestBody Dept dept){
        log.info("修改部门:{}",dept);
        deptService.modify(dept);
        return Result.success();
    }
}
