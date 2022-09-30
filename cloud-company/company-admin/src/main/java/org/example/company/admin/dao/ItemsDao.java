package org.example.company.admin.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.company.admin.dto.ItemDto;
import org.example.company.admin.dto.ItemsDto;
import org.example.company.admin.model.ListItems;
import org.example.company.admin.model.ListUIs;

import java.util.List;

@Mapper
public interface ItemsDao {
    @Select("SELECT i_id,i_name,i_desc,i_createTime,i_finishTime,i_progress,u_name FROM sys_items INNER JOIN sys_user ON sys_items.i_principal = sys_user.u_id ORDER BY i_id")
    List<ListItems> ListItems();

    @Select("SELECT ui_id,sys_user.u_id,u_name,u_email,u_phone FROM sys_user_item INNER JOIN sys_user ON sys_user_item.u_id = sys_user.u_id WHERE i_id = #{i_id} AND ui_status = 1")
    List<ListUIs> ListUIs(ItemsDto itemsDto);

    @Insert("insert into sys_items(i_name, i_desc, i_createTime, i_finishTime, i_progress, i_principal) values(#{i_name},#{i_desc},#{i_createTime},#{i_finishTime},#{i_progress},#{i_principal})")
    void InsertItem(ItemDto itemDto);

    @Insert("INSERT INTO sys_user_item (i_id,u_id,ui_status)VALUES(#{i_id},#{u_id},1)")
    void InsertUI(ItemsDto itemsDto);

    @Select("select ui_status from sys_user_item where i_id = #{i_id} AND u_id = #{u_id}")
    Integer Ifempty(ItemsDto itemsDto);

    @Update("UPDATE sys_user_item SET ui_status = 1 WHERE i_id = #{i_id} AND u_id = #{u_id}")
    void UiStatus(ItemsDto itemsDto);

    @Update("UPDATE sys_user_item SET ui_status = 0 WHERE ui_id = #{ui_id}")
    void DeleteUI(ItemsDto itemsDto);

    @Update("UPDATE sys_user SET u_busy = 1 WHERE u_id = #{u_id}")
    void UisBusy(ItemsDto itemsDto);

    @Update("UPDATE sys_user SET u_busy = 0 WHERE u_id = #{u_id}")
    void UnoBusy(ItemsDto itemsDto);

    //三个查询
    @Select("SELECT i_id,u_id,i_name,i_desc,i_createTime,i_finishTime,i_progress,u_name FROM sys_items INNER JOIN sys_user ON sys_items.i_principal = sys_user.u_id WHERE i_progress = '准备中' ORDER BY i_id")
    List<ListItems> ListItems1();
    @Select("SELECT i_id,u_id,i_name,i_desc,i_createTime,i_finishTime,i_progress,u_name FROM sys_items INNER JOIN sys_user ON sys_items.i_principal = sys_user.u_id WHERE i_progress = '进行中' ORDER BY i_id")
    List<ListItems> ListItems2();
    @Select("SELECT i_id,u_id,i_name,i_desc,i_createTime,i_finishTime,i_progress,u_name FROM sys_items INNER JOIN sys_user ON sys_items.i_principal = sys_user.u_id WHERE i_progress = '已完成' ORDER BY i_id")
    List<ListItems> ListItems3();

    //审批
    @Select("SELECT i_id FROM sys_items WHERE i_principal = #{u_id} AND i_progress = '进行中'")
    List<Integer>  ifIng(ItemsDto itemsDto);

    @Update("UPDATE sys_items SET i_progress = '进行中' WHERE i_id = #{i_id} AND i_principal = #{u_id}")
    void UpItem(ItemsDto itemsDto);
}
