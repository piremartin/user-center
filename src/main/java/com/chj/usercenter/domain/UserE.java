package com.chj.usercenter.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user")
public class UserE implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    public UserE(){

    }

    public UserE(String name){
        this.name = name;
    }


}
