package org.staff.staffsystem.service;

import org.staff.staffsystem.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 根据id删除部门
     */
    void delete(Integer id);
}
