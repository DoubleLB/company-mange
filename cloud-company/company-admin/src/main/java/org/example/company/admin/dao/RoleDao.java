package org.example.company.admin.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.company.admin.dto.RoleDto;
import org.example.company.admin.model.Role;
import org.example.company.admin.model.User;

import java.util.List;

@Mapper
public interface RoleDao {
    @Select("select * from sys_role")
    List<Role> List();

    @Select("SELECT u_id, d_name, r_name, u_name, u_pwd, u_email, u_phone, u_phone, u_payment,u_pic FROM sys_user INNER JOIN sys_department ON sys_user.d_id = sys_department.d_id INNER JOIN sys_role ON sys_user.r_id = sys_role.r_id WHERE sys_user.r_id = #{r_id} ORDER BY u_id")
    List<User> ListAsR(RoleDto roleDto);
    @Insert("INSERT INTO sys_role (r_name,r_desc) VALUES (#{r_name},#{r_desc})")
    void AddRole(RoleDto roleDto);
}
