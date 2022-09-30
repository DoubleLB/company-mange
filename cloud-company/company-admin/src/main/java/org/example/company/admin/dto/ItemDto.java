package org.example.company.admin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ItemDto {
    private String i_name;
    private String i_desc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")//接收非json格式参数（普通参数）
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//接收json格式的参数
    private Date i_createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")//接收非json格式参数（普通参数）
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//接收json格式的参数
    private Date i_finishTime;
    private String i_progress;
    private Integer i_principal;
}
