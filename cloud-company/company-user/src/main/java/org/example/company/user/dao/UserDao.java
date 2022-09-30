package org.example.company.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.company.user.dto.UserDto;
import org.example.company.user.model.User;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM sys_user INNER JOIN sys_department ON sys_user.d_id = sys_department.d_id INNER JOIN sys_role ON sys_user.r_id = sys_role.r_id ORDER BY u_id")
    List<User> listUser();

//    @Select("SELECT u_id, d_name, r_name, u_name, u_pwd, u_email, u_phone, u_phone, u_payment FROM sys_user INNER JOIN sys_department ON sys_user.d_id = sys_department.d_id INNER JOIN sys_role ON sys_user.r_id = sys_role.r_id ORDER BY u_id")
//    List<User> ListUser();

    @Insert("insert into sys_user(u_id,d_id,r_id,u_name,u_pwd,u_email,u_phone,u_payment,u_pic) values(#{u_id},#{d_id},#{r_id},#{u_name},'123',#{u_email},#{u_phone},#{u_payment},#{u_pic})")
    void insertMeal(UserDto userDto);

    @Update("update sys_user set d_id = #{d_id} ,r_id = #{r_id},u_payment = #{u_payment} where u_id = #{u_id}")
    void editUser(UserDto userDto);

    @Update("update sys_user set u_pic=#{u_pic} where u_id=#{u_id}")
    int userUpdateImg(User user);
}
