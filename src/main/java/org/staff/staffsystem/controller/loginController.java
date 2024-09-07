package org.staff.staffsystem.controller;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.staff.staffsystem.pojo.Emp;
import org.staff.staffsystem.pojo.Result;
import org.staff.staffsystem.service.EmpService;
import org.staff.staffsystem.utils.JwtUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class loginController {
    @Autowired
    EmpService empService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登入请求:{}",emp);
        Emp e = empService.login(emp);
        String jwt;
        if(e==null){
            log.info("用户不存在");
            return Result.error("用户不存在");
        }
        else{
            log.info("登入成功");
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            jwt = jwtUtils.generateJwt(claims);
            log.info("Jwt令牌:{}",jwt);
        }
        return Result.success(jwt);
    }
}
