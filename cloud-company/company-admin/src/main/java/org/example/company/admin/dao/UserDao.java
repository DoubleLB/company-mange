package org.example.company.admin.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.company.admin.dto.InsertDto;
import org.example.company.admin.dto.UpdataDto;
import org.example.company.admin.model.User;
import org.example.company.admin.model.UserList;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM sys_user INNER JOIN sys_department ON sys_user.d_id = sys_department.d_id INNER JOIN sys_role ON sys_user.r_id = sys_role.r_id ORDER BY u_id")
    List<User> ListUser();

    @Insert("insert into sys_user(u_id,d_id,r_id,u_name,u_pwd,u_email,u_phone,u_payment,u_pic,u_sex,u_busy) values(#{u_id},#{d_id},#{r_id},#{u_name},'123',#{u_email},#{u_phone},#{u_payment},#{u_pic},#{u_sex},'0')")
    void insertUser(InsertDto insertDto);

    @Update("update sys_user set d_id= #{d_id} ,r_id= #{r_id}, u_payment= #{u_payment} where u_id= #{u_id}")
    void updataUser(UpdataDto updataDto);

    @Select("select u_id AS user_id,u_name AS user_name from sys_user where u_busy = 0")
    List<UserList> Nobusy();
}
