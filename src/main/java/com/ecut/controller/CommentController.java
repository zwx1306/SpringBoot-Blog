package com.ecut.controller;

import com.ecut.domain.Ccomment;
import com.ecut.domain.Comment;
import com.ecut.domain.User;
import com.ecut.service.BlogService;
import com.ecut.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) throws Exception {
        List<Comment> comments = commentService.findCommentsByBlogId(blogId);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", blogService.getDetailedBlog(blogId));
        return "blog";
    }

//
//
    @PostMapping("/comments")
    public String post(@RequestParam String replyname,
                       Comment comment, HttpSession session) throws Exception {
        Long blogId = comment.getBlogId();
        System.out.println(comment.getParentCommentId());
        System.out.println(replyname);
        comment.setBlog(blogService.getDetailedBlog(blogId));

       //是否为管理员
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(1);
        } else {
            //设置头像
            comment.setAvatar(avatar);


        }

         if(comment.getParentCommentId() == -1) {
             commentService.saveComment(comment);

         }else {

           commentService.saveCcomment(comment,replyname);

         }
        return "redirect:/comments/" + blogId;
    }



}
