package com.ecut.service.impl;

import com.ecut.dao.BlogDao;
import com.ecut.dao.CommentDao;
import com.ecut.domain.Ccomment;
import com.ecut.domain.Comment;
import com.ecut.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BlogDao blogDao;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        //没有父节点的默认为-1
        List<Comment> comments = commentDao.findByBlogIdParentIdNull(blogId, Long.parseLong("-1"));
        return comments;
    }

    @Override
    //接收回复的表单
    public int saveComment(Comment comment) {
        System.out.println("comment:" + comment);
        //判断有没有在别人的评论上进行评论还是一个新的评论
        comment.setCreateTime(new Date());
        comment.setBlog(blogDao.getDetailedBlog(comment.getBlogId()));
        return commentDao.saveComment(comment);
    }





    @Override
    public List<Comment> findCommentsByBlogId(Long id) {
        List<Comment> commentsByBlogId = commentDao.findCommentsByBlogId(id);
        for(Comment comment : commentsByBlogId){
            Long parentId = comment.getId();
            List<Ccomment> childComments = findChildComment(parentId);
            if (childComments.size()>0){
                comment.setReplyComments(childComments);
            }
        }
        return commentsByBlogId;
    }

    @Override
    public List<Ccomment> findChildComment(Long id) {
        return commentDao.findChildComment(id);
    }

    @Override
    public int saveCcomment(Comment comment,String replyname) {
        Ccomment ccomment=new Ccomment();
        ccomment.setContent(comment.getContent());
        ccomment.setNickname(comment.getNickname());
        ccomment.setParentCommentId(comment.getParentCommentId());
        ccomment.setEmail(comment.getEmail());
        ccomment.setCreateTime(new Date());
        ccomment.setReplyname(replyname);
      ccomment.setBlogId(comment.getBlogId());
      ccomment.setAvatar(comment.getAvatar());
      ccomment.setAdminComment(comment.getAdminComment());
        return commentDao.saveCcomment(ccomment);
    }


}

