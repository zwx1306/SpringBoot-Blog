package com.ecut.dao;

import com.ecut.domain.Ccomment;
import com.ecut.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {


    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);

    //查询父级对象
    Comment findByParentCommentId(Long parentCommentId);


    //添加一个评论
    int saveComment(Comment comment);


    //查询博客所属的全部评论
    List<Comment> findCommentsByBlogId (Long id);

    //查询子评论
    List<Ccomment> findChildComment(Long id);

    //保存子评论
    int saveCcomment (Ccomment ccomment);
}
