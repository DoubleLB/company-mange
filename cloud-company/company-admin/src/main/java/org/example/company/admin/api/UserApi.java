package org.example.company.admin.api;


import lombok.extern.slf4j.Slf4j;
import org.example.company.admin.dao.UserDao;
import org.example.company.admin.dto.InsertDto;
import org.example.company.admin.dto.UpdataDto;
import org.example.company.admin.model.User;
import org.example.company.admin.model.UserList;
import org.example.company.common.Result;
import org.example.company.common.exception.SysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j //方便日志输出
@Transactional //事务注解
@RestController
@RequestMapping("/admin/user")
public class UserApi {
    @Autowired
    private UserDao userDao;

    @GetMapping("")
    public Result<List<User>>  ListUser(){
        List<User> list = userDao.ListUser();
        return Result.OK(list);
    }

    @PostMapping("/insert")
    public Result insertUser(@RequestBody InsertDto userDto, MultipartFile file){
        try{
            userDao.insertUser(userDto);
        }catch (Exception e){
            throw new SysException("系统错误",e);
        }
        return Result.OK();
    }

    @PostMapping("/updata")
    public Result updataUser(@RequestBody UpdataDto updataDto){
        try{
            userDao.updataUser(updataDto);
        }catch (Exception e){
            throw new SysException("系统错误",e);
        }
        return Result.OK();
    }

    @GetMapping("/nobusy")
    public Result<List<UserList>> Nobusy(){
        List<UserList> list = userDao.Nobusy();
        return Result.OK(list);
    }
}
