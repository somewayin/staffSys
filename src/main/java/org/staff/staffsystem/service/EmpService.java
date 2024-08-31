package org.staff.staffsystem.service;

import org.staff.staffsystem.pojo.PageBean;

public interface EmpService {
    PageBean getPage(Integer page, Integer pageSize);
}
