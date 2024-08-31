package org.staff.staffsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.staff.staffsystem.mapper.EmpMapper;
import org.staff.staffsystem.pojo.Emp;
import org.staff.staffsystem.pojo.PageBean;
import org.staff.staffsystem.service.EmpService;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean getPage(Integer page, Integer pageSize, String name, Short gender,
                            LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }
}
