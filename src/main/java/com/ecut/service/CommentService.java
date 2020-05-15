package com.ecut.service;

import com.ecut.domain.Ccomment;
import com.ecut.domain.Comment;


import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);
    List<Comment> findCommentsByBlogId(Long id);
    List<Ccomment> findChildComment(Long id);

    int saveCcomment(Comment ccomment,String replyname);
}
