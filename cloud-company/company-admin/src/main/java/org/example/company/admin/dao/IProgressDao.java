package org.example.company.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.company.admin.dto.IProgressDto;
import org.example.company.admin.model.IProgress;

import java.util.List;

@Mapper
public interface IProgressDao {
    @Select("SELECT ig_id,u_name,ig_date,ig_desc FROM sys_itemprogress INNER JOIN sys_user ON sys_itemprogress.u_id = sys_user.u_id WHERE i_id = #{i_id} ORDER BY ig_id")
    List<IProgress> progressList(IProgressDto iProgressDto);
}
