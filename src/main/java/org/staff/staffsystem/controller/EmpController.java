package org.staff.staffsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.staff.staffsystem.pojo.PageBean;
import org.staff.staffsystem.pojo.Result;
import org.staff.staffsystem.service.EmpService;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService  empService;

    @GetMapping("/emps")
    public Result getPage(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询,page:{},pageSize:{}", page, pageSize);
        PageBean pageBean = empService.getPage(page, pageSize);
        return Result.success(pageBean);
    }
}
