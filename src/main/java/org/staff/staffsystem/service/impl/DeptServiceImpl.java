package org.staff.staffsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.staff.staffsystem.mapper.DeptMapper;
import org.staff.staffsystem.pojo.Dept;
import org.staff.staffsystem.service.DeptService;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
}
