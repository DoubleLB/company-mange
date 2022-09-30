package org.example.company.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.example.company.admin.dao.RoleDao;
import org.example.company.admin.dto.DepartmentDto;
import org.example.company.admin.dto.RoleDto;
import org.example.company.admin.model.Role;
import org.example.company.admin.model.User;
import org.example.company.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //方便日志输出
@Transactional //事务注解
@RestController
@RequestMapping("/admin/role")
public class RoleApi {
    @Autowired
    private RoleDao roleDao;

    @GetMapping("/list")
    public Result<List<Role>> List(){
        List<Role> list = roleDao.List();
        return Result.OK(list);
    }

    @PostMapping("/insert")
    public Result AddDepartment(@RequestBody RoleDto roleDto){
        roleDao.AddRole(roleDto);
        return Result.OK();
    }

    @PostMapping("/listasr")
    public Result<List<User>> ListAsr(@RequestBody RoleDto roleDto){
        List<User> list = roleDao.ListAsR(roleDto);
        return Result.OK(list);
    }
}
