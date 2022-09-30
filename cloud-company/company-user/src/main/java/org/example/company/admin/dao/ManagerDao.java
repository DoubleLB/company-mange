package org.example.company.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.company.admin.dto.ManagerDto;
import org.example.company.admin.model.Manager;

@Mapper
public interface ManagerDao {

    @Select("select * from sys_manager where m_name = #{username} and m_pwd = #{password}")
    Manager findAdminByNameAndPwd(ManagerDto managerDto);


}
