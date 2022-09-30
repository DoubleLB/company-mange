package org.example.company.admin.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.company.admin.dto.DepartmentDto;
import org.example.company.admin.model.Department;
import org.example.company.admin.model.User;

import java.util.List;

@Mapper
public interface DepartmentDao {

    @Select("select * from sys_department")
    List<Department> List();

    //按部门来划分员工
    @Select("SELECT u_id, d_name, r_name, u_name, u_pwd, u_email, u_phone, u_phone, u_payment,u_pic FROM sys_user INNER JOIN sys_department ON sys_user.d_id = sys_department.d_id INNER JOIN sys_role ON sys_user.r_id = sys_role.r_id WHERE sys_user.d_id = #{d_id} ORDER BY u_id")
    List<User> ListAsD(DepartmentDto departmentDto);

    @Insert("INSERT INTO sys_department (d_name,d_location) VALUES (#{d_name},#{d_location})")
    void AddDepartment(DepartmentDto departmentDto);

}
