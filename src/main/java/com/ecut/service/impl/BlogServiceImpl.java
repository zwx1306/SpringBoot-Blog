package com.ecut.service.impl;

import com.ecut.dao.BlogDao;
import com.ecut.domain.Blog;
import com.ecut.domain.BlogAndTag;
import com.ecut.domain.Tag;
import com.ecut.dto.*;
import com.ecut.exception.NotFountException;
import com.ecut.service.BlogService;
import com.ecut.util.MarkdownUtils;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;


    @Override
    public List<Map<String, Object>> getBlog(Long id) {
        List<Map<String, Object>> lb = blogDao.getBlog(id);
        return lb;

    }

    @Override
    public List<Map<String, Object>> listBlog() {
        List<Map<String, Object>> lb = blogDao.listBlog();

        return lb;
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        //将标签的数据存到t_blogs_tag表中
        List<Tag> tags = blog.getTags();
        BlogAndTag blogAndTag = null;
        for (Tag tag : tags) {
            blogAndTag = new BlogAndTag(tag.getId(), blog.getId());
            blogDao.saveBlogAndTag(blogAndTag);
        }
        return blogDao.saveBlog(blog);
    }


    @Override
    public void delete(Long id) {
        blogDao.delete(id);

    }

    //将前台传来的string  转为 Integer
    @Override
    public void transformRecommend(SearchBlog searchBlog) {
        if (!"".equals(searchBlog.getRecommend()) && null != searchBlog.getRecommend()) {
            searchBlog.setRecommend2(1);
        }
    }

    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogDao.getBlogBySearch(searchBlog);
    }

    @Override
    public int deleteBlog(Long id) {
        blogDao.deleteBlogAndTag(id);
        blogDao.deleteBlog(id);
        return 1;
    }

    @Override
    public ShowBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }

    @Override
    public void updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        blogDao.updateBlog(showBlog);
    }

    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogDao.getFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getAllRecommendBlog() {
        List<RecommendBlog> allRecommendBlog = blogDao.getAllRecommendBlog();
        List<RecommendBlog> allRecommendedBlog = new ArrayList<>();
        for (RecommendBlog recommendBlog : allRecommendBlog) {
            if (recommendBlog.isRecommend() == true) {
                allRecommendedBlog.add(recommendBlog);
            }
        }
        return allRecommendedBlog;


    }

    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
       return blogDao.getSearchBlog(query);
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = blogDao.getDetailedBlog(id);

        if (detailedBlog == null) {
            throw new NotFountException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return detailedBlog;
    }

    @Override
    public void upViews(Long id) {
        blogDao.upViews(id);
    }

    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }
    @Override
    public List<FirstPageBlog> getByTagId(Long tagId) {
        return blogDao.getByTagId(tagId);
    }

}
