package org.staff.staffsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.staff.staffsystem.pojo.Emp;
import org.staff.staffsystem.pojo.PageBean;
import org.staff.staffsystem.pojo.Result;
import org.staff.staffsystem.service.EmpService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService  empService;

    @GetMapping
    public Result getPage(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize, String name, Short gender,
                          @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        log.info("分页查询,page:{},pageSize:{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.getPage(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids")List<Integer> ids){
        log.info("批量删除操作, ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("新增员工, {}",emp);
        empService.add(emp);
        return Result.success();
    }

    @RequestMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("员工 id:{}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息:{}",emp);
        empService.update(emp);
        return Result.success();
    }


}
