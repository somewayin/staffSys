package org.staff.staffsystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.staff.staffsystem.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门数据
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除部门
     */
    @Select("delete from dept where id=#{id}")
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) Values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /**
     * 修改部门
     * @param dept
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void modify(Dept dept);

    /**
     * 根据id获取单条记录
     * @return
     */
    @Select("select * from dept where id=#{id}")
    Dept getById(Integer id);
}
