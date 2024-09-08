package org.staff.staffsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.staff.staffsystem.pojo.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/s1")
    public Result setSession(HttpSession session){
        log.info("session 创建完毕:{}", session.hashCode());
//        session.setAttribute("username", "XXXX");
        return Result.success();
    }

    @GetMapping("/s2")
    public Result getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("获取的session:{}", session.hashCode());
//        Object sessionId = session.getAttribute("username");
//        log.info("username:{}", sessionId);
        return Result.success();
    }
}
