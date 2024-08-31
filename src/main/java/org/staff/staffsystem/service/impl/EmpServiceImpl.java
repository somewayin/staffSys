package org.staff.staffsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.staff.staffsystem.mapper.EmpMapper;
import org.staff.staffsystem.pojo.Emp;
import org.staff.staffsystem.pojo.PageBean;
import org.staff.staffsystem.service.EmpService;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean getPage(Integer page, Integer pageSize) {
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.pages(start, pageSize);
        Long count = empMapper.count();
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }
}
