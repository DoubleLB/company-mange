package org.example.company.admin.dto;

import lombok.Data;

@Data
public class InsertDto {
    private Integer u_id;
    private Integer d_id;
    private Integer r_id;
    private String u_name;
    private String u_pwd;
    private String u_email;
    private String u_phone;
    private String u_payment;
    private String u_pic;
    private String u_sex;
}
