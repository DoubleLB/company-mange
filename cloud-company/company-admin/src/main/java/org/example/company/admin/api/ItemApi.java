package org.example.company.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.example.company.admin.dao.ItemsDao;
import org.example.company.admin.dao.UserDao;
import org.example.company.admin.dto.ItemDto;
import org.example.company.admin.dto.ItemsDto;
import org.example.company.admin.dto.ListUIsDto;
import org.example.company.admin.model.ListItems;
import org.example.company.admin.model.ListUIs;
import org.example.company.admin.model.User;
import org.example.company.common.Result;
import org.example.company.common.exception.SysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //方便日志输出
@Transactional //事务注解
@RestController
@RequestMapping("/admin/items")
public class ItemApi {
    @Autowired
    private ItemsDao itemsDao;

    @GetMapping("/list")
    public Result<List<ListItems>> ListItems(){
        List<ListItems> list = itemsDao.ListItems();
        return Result.OK(list);
    }

    @PostMapping("stUIs")
    public Result<List<ListUIs>> ListUIs(@RequestBody ItemsDto itemsDto){
        List<ListUIs> list;
        try{
            list = itemsDao.ListUIs(itemsDto);
        }catch(Exception e){
            throw new SysException("系统错误",e);
        }
        return Result.OK(list);

    }

    @PostMapping("/insertItem")
    public Result InsertItem(@RequestBody ItemDto itemDto){
        try{
            itemsDao.InsertItem(itemDto);
        }catch(Exception e){
            throw new SysException("系统错误",e);
        }
        return Result.OK();
    }

    @PostMapping("/insertUIs")
    public Result InsertUIs(@RequestBody ItemsDto itemsDto){
        Integer status = itemsDao.Ifempty(itemsDto);
        if(status==null){
            itemsDao.InsertUI(itemsDto);
            itemsDao.UisBusy(itemsDto);
        }else{
            if(status==1){
                return Result.OK("此人已经在项目中");
            }else{
                itemsDao.UiStatus(itemsDto);
                itemsDao.UisBusy(itemsDto);
            }
        }
        return Result.OK();
    }

    @PostMapping("/deleteUIs")
    public Result DeleteUIs(@RequestBody ItemsDto itemsDto){
        itemsDao.DeleteUI(itemsDto);
        itemsDao.UnoBusy(itemsDto);
        return Result.OK();
    }

    @GetMapping("/list1")
    public Result<List<ListItems>> ListItems1(){
        List<ListItems> list = itemsDao.ListItems1();
        return Result.OK(list);
    }
    @GetMapping("/list2")
    public Result<List<ListItems>> ListItems2(){
        List<ListItems> list = itemsDao.ListItems2();
        return Result.OK(list);
    }
    @GetMapping("/list3")
    public Result<List<ListItems>> ListItems3(){
        List<ListItems> list = itemsDao.ListItems3();
        return Result.OK(list);
    }

    //审批
    @PostMapping("/agree")
    public Result Agree(@RequestBody ItemsDto itemsDto){
        List<Integer> list = itemsDao.ifIng(itemsDto);
        if(list.size()==0){
            itemsDao.UpItem(itemsDto);
            this.InsertUIs(itemsDto);
        }else{
            return Result.err(530,"此人已经在负责其他项目");
        }
        return Result.OK();
    }

}
