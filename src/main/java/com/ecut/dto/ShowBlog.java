package com.ecut.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//修改博客页面的数据
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowBlog {

    private Long id;
    private boolean published;
    private String flag;
    private String title;
    private String content;
    private Long typeId;
    private String tagIds;
    private String firstPicture;
    private String description;
    private boolean recommend;
    private boolean shareStatement;
    private boolean appreciation;
    private boolean commentabled;
    private Date updateTime;

}