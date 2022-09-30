package org.example.company.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.example.company.admin.dao.DepartmentDao;
import org.example.company.admin.dto.DepartmentDto;
import org.example.company.admin.model.Department;
import org.example.company.admin.model.User;
import org.example.company.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //方便日志输出
@Transactional //事务注解
@RestController
@RequestMapping("/admin/department")
public class DepartmentApi {
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/list")
    public Result<List<Department>> List(){
        List<Department> list = departmentDao.List();
        return Result.OK(list);
    }

    @PostMapping("/insert")
    public Result AddDepartment(@RequestBody DepartmentDto departmentDto){
        departmentDao.AddDepartment(departmentDto);
        return Result.OK();
    }

    @PostMapping("/listasd")
    public Result<List<User>> ListAsd(@RequestBody DepartmentDto departmentDto){
        List<User> list = departmentDao.ListAsD(departmentDto);
        return Result.OK(list);
    }
}
