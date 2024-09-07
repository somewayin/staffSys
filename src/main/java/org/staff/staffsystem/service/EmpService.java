package org.staff.staffsystem.service;

import org.springframework.format.annotation.DateTimeFormat;
import org.staff.staffsystem.pojo.Emp;
import org.staff.staffsystem.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean getPage(Integer page, Integer pageSize, String name, Short gender,
                   LocalDate begin,LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
