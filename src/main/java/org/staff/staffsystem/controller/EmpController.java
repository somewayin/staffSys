package org.staff.staffsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.staff.staffsystem.pojo.PageBean;
import org.staff.staffsystem.pojo.Result;
import org.staff.staffsystem.service.EmpService;

import java.time.LocalDate;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService  empService;

    @GetMapping("/emps")
    public Result getPage(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize, String name, Short gender,
                          @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        log.info("分页查询,page:{},pageSize:{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.getPage(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }
}
