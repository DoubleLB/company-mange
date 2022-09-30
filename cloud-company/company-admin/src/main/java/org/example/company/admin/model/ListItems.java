package org.example.company.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ListItems {
    private Integer i_id;
    private Integer u_id;
    private String i_name;
    private String i_desc;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//设置时间格式和时区
    private Date i_createTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//设置时间格式和时区
    private Date i_finishTime;
    private String i_progress;
    private String u_name;
}
