package org.example.company.user.dto;

import lombok.Data;

@Data
public class UserDto {

   private Integer u_id;
   private String  u_name;
   private String u_email;
   private String u_phone;
   private String u_payment;
   private String u_pic;
   private Integer d_id;
   private Integer r_id;
}
