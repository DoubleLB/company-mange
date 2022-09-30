package org.example.company.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class IProgress {
    private Integer ig_id;
    private String u_name;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//设置时间格式和时区
    private Date ig_date;
    private String ig_desc;
}
