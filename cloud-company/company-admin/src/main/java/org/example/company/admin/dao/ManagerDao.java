package org.example.company.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.example.company.admin.dto.ManagerDto;
import org.example.company.admin.model.Manager;

import java.util.List;


@Mapper
public interface ManagerDao {
    @Insert("insert into sys_manager(m_id,m_name,m_pwd) values(#{m_id},#{m_name},#{m_pwd})")
    void insertManager(ManagerDto managerDto);

    @Delete("delete from sys_manager where m_id= #{m_id}")
    void deleteManager(ManagerDto managerDto);

    @Update("update sys_manager set m_id= #{m_id} ,m_name= #{m_name} ,m_pwd= #{m_pwd}")
    void updateManager(ManagerDto managerDto);

    @Select("select * from sys_manager ")
    List<Manager> ListManager();

    @Select("select * from sys_manager where m_id= #{m_id} and m_pwd= #{m_pwd}")
    Manager LoginManager(ManagerDto managerDto);

}
