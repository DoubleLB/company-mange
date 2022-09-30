package org.example.company.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.example.company.admin.dao.SkillDao;
import org.example.company.admin.dto.RoleDto;
import org.example.company.admin.dto.SkillDto;
import org.example.company.admin.model.Skill;
import org.example.company.admin.model.User;
import org.example.company.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //方便日志输出
@Transactional //事务注解
@RestController
@RequestMapping("/admin/skill")
public class SkillApi {
    @Autowired
    private SkillDao skillDao;

    @GetMapping("/list")
    public Result<List<Skill>> List(){
        List<Skill> list = skillDao.List();
        return Result.OK(list);
    }

    @PostMapping("/insert")
    public Result AddDepartment(@RequestBody SkillDto skillDto){
        skillDao.AddSkill(skillDto);
        return Result.OK();
    }

    @PostMapping("/listass")
    public Result<List<User>> ListAss(@RequestBody SkillDto skillDto){
        List<User> list = skillDao.ListAsS(skillDto);
        return Result.OK(list);
    }
}

