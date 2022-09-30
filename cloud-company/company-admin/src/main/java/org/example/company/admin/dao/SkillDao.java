package org.example.company.admin.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.company.admin.dto.SkillDto;
import org.example.company.admin.model.Skill;
import org.example.company.admin.model.User;

import java.util.List;

@Mapper
public interface SkillDao {
    @Select("select * from sys_skill")
    List<Skill> List();


    @Select("SELECT sys_user.u_id, d_name, r_name, u_name, u_pwd, u_email, u_phone, u_phone, u_payment,u_pic FROM sys_user_skill INNER JOIN sys_user ON sys_user_skill.u_id = sys_user.u_id INNER JOIN sys_department ON sys_user.d_id = sys_department.d_id INNER JOIN sys_role ON sys_user.r_id = sys_role.r_id  WHERE sys_user_skill.s_id = #{s_id} ORDER BY u_id")
    List<User> ListAsS(SkillDto skillDto);
    @Insert("INSERT INTO sys_skill (s_name,s_desc) VALUES (#{s_name},#{s_desc})")
    void AddSkill(SkillDto skillDto);
}

