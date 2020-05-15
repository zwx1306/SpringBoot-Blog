package com.ecut.service;

import com.ecut.domain.Blog;
import com.ecut.domain.BlogAndTag;
import com.ecut.dto.*;

import java.util.List;
import java.util.Map;

public interface BlogService {
    //根据id获取blog
    List<Map<String, Object>> getBlog(Long id);
    //blog列表   //获取部分值需要使用
     List<Map<String, Object>> listBlog();
     int saveBlog(Blog blog);

     void delete(Long id);
    //修改recommend,因为recommend从前台接收只能接收字符串，但数据库中的Integer类型，所以转一下
    void transformRecommend(SearchBlog searchBlog);
    //根据查询条件拿到查询后的值
    List<BlogQuery> getBlogBySearch(SearchBlog searchBlog);
    int deleteBlog(Long id);
    ShowBlog getBlogById(Long id);
    void updateBlog(ShowBlog showBlog);
    //拿到用户首页的博客
    List<FirstPageBlog> getAllFirstPageBlog();

    List<RecommendBlog> getAllRecommendBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id) throws Exception;
    void  upViews(Long id);

    //根据TypeId获取博客
    List<FirstPageBlog> getByTypeId(Long typeId);
    List<FirstPageBlog> getByTagId(Long tagId);
}
