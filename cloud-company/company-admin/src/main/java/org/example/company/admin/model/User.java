package org.example.company.admin.model;


import lombok.Data;

@Data
public class User {
    private Integer u_id;
    private Integer d_id;
    private Integer r_id;
    private String d_name;
    private String r_name;
    private String u_name;
    private String u_pwd;
    private String u_email;
    private String u_phone;
    private String u_payment;
    private String u_pic;
    private String u_sex;
    private Integer u_busy;
}
