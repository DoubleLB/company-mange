package org.example.company.user.api;

import lombok.extern.slf4j.Slf4j;
import org.example.company.common.Result;
import org.example.company.common.exception.BusinessException;
import org.example.company.common.exception.SysException;
import org.example.company.user.dao.UserDao;
import org.example.company.user.dto.UserDto;
import org.example.company.user.model.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Transactional
@RestController
@RequestMapping("/admin/user")
public class UserApi {

    @Autowired
    private UserDao userDao;
//    private UserDao userDao = BeanUtil.getBean(UserDao.class);

    @GetMapping("")
    private Result<List<User>> userList(){

        List<User> list = null;
        try {
            list = userDao.listUser();
        } catch (Exception e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }

        return Result.OK(list);
    }

    @PostMapping("/updateImg")
    private Result userUpdateImg(@RequestBody User user) {

        int i;
        try {
            i = userDao.userUpdateImg(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (i != 1) throw new BusinessException("更新失败");
        else return Result.OK();
    }

    @PostMapping("/addUser")
    private Result<List<User>> mealDoAdd(@RequestBody UserDto userDto , MultipartFile file){//主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；

        try {
            userDao.insertMeal(userDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Result.OK();
    }

    @PostMapping("/admin-edit")
    public Result editUser(@RequestBody UserDto userDto){

        List<User> list;
        try {
            list = userDao.listUser();
            userDao.editUser(userDto);

        } catch (Exception e) {
            throw new SysException("系统错误",e);
        }
        return Result.OK(list);
    }
}
