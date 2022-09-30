package org.example.company.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.example.company.admin.dao.IProgressDao;
import org.example.company.admin.dto.IProgressDto;
import org.example.company.admin.model.IProgress;
import org.example.company.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j //方便日志输出
@Transactional //事务注解
@RestController
@RequestMapping("/admin/progress")
public class IProgressApi {
    @Autowired
    private IProgressDao iProgressDao;

    @PostMapping("/list")
    public Result<List<IProgress>> ProgressList(@RequestBody IProgressDto iProgressDto){
        List<IProgress> list = iProgressDao.progressList(iProgressDto);
        return Result.OK(list);
    }
}