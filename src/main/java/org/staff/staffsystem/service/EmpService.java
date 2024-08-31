package org.staff.staffsystem.service;

import org.springframework.format.annotation.DateTimeFormat;
import org.staff.staffsystem.pojo.PageBean;

import java.time.LocalDate;

public interface EmpService {
    PageBean getPage(Integer page, Integer pageSize, String name, Short gender,
                   LocalDate begin,LocalDate end);
}
