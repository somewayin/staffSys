package org.staff.staffsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.staff.staffsystem.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    /**
//     * 获取数据库的总记录数
//     * @return
//     */
//    @Select("select count(*) from emp")
//    public Long count();
//
//    /**
//     * 分页查询获取列表数据
//     * @param start
//     * @param pageSize
//     * @return
//     */
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> pages(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    /**
     * 员工数据查询
     * @return
     */
//    @Select("select * from emp")
    public List<Emp> list(@Param("name") String name, @Param("gender") Short gender, @Param("begin") LocalDate begin,
                          @Param("end") LocalDate end);
}
