package org.example.company.admin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ManagerDto {
    private Integer m_id;
    private String m_name;
    private String m_pwd;
}
