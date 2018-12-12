package com.chj.usercenter.web.rest.vm;

import lombok.Data;

@Data
public class UserVM {

    private String name;

    private Integer age;


    private String startTime;
    private String endTime;
    private int page = 0;
    private int size = 20;
}
