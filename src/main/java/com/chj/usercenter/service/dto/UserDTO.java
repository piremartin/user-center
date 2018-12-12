package com.chj.usercenter.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private String startTime;
    private String endTime;

    //from entity
    private Long id;
    private String name;
    private Integer age;
    private LocalDateTime createTime = LocalDateTime.now();
}
