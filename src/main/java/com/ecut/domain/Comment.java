package com.ecut.domain;

import com.ecut.dto.DetailedBlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Long id;
    private String nickname;
    private String email;
    //评论内容
    private String content;

    //头像 图片地址或64位的码
    private String avatar;
    private Date createTime;

    private Long blogId;


    private Long parentCommentId;
    private String parentNickname;

    //回复评论
    private List<Ccomment> replyComments = new ArrayList<>();

    private DetailedBlog blog;
    private Integer adminComment;
}
