package org.example.company.pub.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.company.pub.model.Department;
import org.example.company.pub.model.Role;

import java.util.List;

@Mapper
public interface PublicDao {

    @Select("select * from sys_department")
    List<Department> findDepartment();

    @Select("select * from sys_role")
    List<Role> findRole();
}
