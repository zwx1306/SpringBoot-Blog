package com.ecut.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//查询条件
//在controller  用对象来接受参数
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchBlog {
    private String title;
    private Long typeId;
    //推荐符号从前端传过来是String类型
    private String recommend;
    private Integer recommend2;
}