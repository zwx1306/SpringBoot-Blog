package com.ecut.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    //头像
    private String avatar;
    private Integer type;
    private Date createTime;
    private Date updateTime;

    private List<Blog> blogs = new ArrayList<>();
}
