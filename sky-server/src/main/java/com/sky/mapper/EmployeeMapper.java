package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);
    /*
    * 插入员工记录
    * */
    @AutoFill(value = OperationType.INSERT)
    @Insert(" insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user, status) values (#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status}) ")
    void insert(Employee employee);
    /*
    * 员工分页查询方法
    * 查询语句写在xml里了
    * */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /*
    * 员工账号状态更新,根据主键动态修改属性，因此还是写在xml里
    * */
    @AutoFill(value = OperationType.UPDATE)
    void update(Employee employee);

    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);


}
