package org.staff.staffsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.staff.staffsystem.pojo.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class SessionController {

    @GetMapping("/c1")
    public Result setCookie(HttpServletResponse response) {
        response.addCookie(new Cookie("username", "zekenwang"));
        return Result.success();
    }

    @GetMapping("/c2")
    public Result getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("username")){
                    log.info("检测到 {} 用户的cookie", cookie.getValue());
                }
            }
        }
        return Result.success();
    }
}
