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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Transactional
@RestController
@RequestMapping("/admin")
public class ManageApi {

    @Autowired
    private ManagerDao managerDao;

    @PostMapping("/login")
    public Result doLogin(@RequestBody ManagerDto managerDto){

        log.debug("收到参数：username={},password={}",managerDto.getUsername(),managerDto.getPassword());
        Manager manager = null;
        try {
            manager = managerDao.findAdminByNameAndPwd(managerDto);
            log.debug("manager内的信息{}",manager);
        } catch (Exception e) {
            throw new SysException("系统错误",e);
        }

        if(manager == null){
            //账号或密码不正确
            throw new BusinessException("账号密码不正确");
        }
        else {
            //账号密码正确
            return Result.OK();

        }

    }



}
