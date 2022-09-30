package org.example.company.admin.api;


import lombok.extern.slf4j.Slf4j;
import org.example.company.admin.dao.ManagerDao;
import org.example.company.admin.dto.ManagerDto;
import org.example.company.admin.model.Manager;
import org.example.company.common.Result;
import org.example.company.common.exception.BusinessException;
import org.example.company.common.exception.SysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@Slf4j //方便日志输出
@Transactional //事务注解
@RestController
@RequestMapping("/admin/manager")
public class ManagerApi {
    @Autowired
    private ManagerDao managerDao;

    @GetMapping("/list")
    private List<Manager> List(){
        List<Manager> list =  managerDao.ListManager();
        return list;
    }

    @PostMapping("/login")
    private Result selectOnly(@RequestBody ManagerDto managerDto){
        log.debug("收到参数: m_id={},m_pwd={}",managerDto.getM_id(),managerDto.getM_pwd());

        Manager manager = null;
        try{
            manager = managerDao.LoginManager(managerDto);
        }catch (Exception e){
            throw new SysException("系统错误",e);
        }

        if(manager == null){
            throw new BusinessException("账号或密码不正确");
        }else{
            return Result.OK();
        }
    }

    @PostMapping("/register")
    private Result register(@RequestBody ManagerDto managerDto){
        try{
            managerDao.insertManager(managerDto);
        }catch (Exception e){
            throw new SysException("系统错误",e);
        }
        return Result.OK();
    }

}
