package com.ecut.dao;

import com.ecut.domain.Blog;
import com.ecut.domain.BlogAndTag;
import com.ecut.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface BlogDao {
    //根据id获取blog
     List<Map<String, Object>> getBlog(Long id);
    //blog列表
     List<Map<String, Object>> listBlog();
     int saveBlog(Blog blog);
     int updateBlog(ShowBlog showBlog);
     void delete(Long id);
    int saveBlogAndTag(BlogAndTag blogAndTag);

     List<BlogQuery> getBlogBySearch(SearchBlog blog);
    ShowBlog getBlogById(Long id);
    int deleteBlog(Long id);
    int deleteBlogAndTag(Long blogId);
    List<FirstPageBlog> getFirstPageBlog();
    List<RecommendBlog> getAllRecommendBlog();
    List<FirstPageBlog> getSearchBlog(String query);
    DetailedBlog getDetailedBlog(Long id);
   //浏览数加一
    void upViews(Long id);
    List<FirstPageBlog> getByTypeId(Long typeId);
    List<FirstPageBlog> getByTagId(Long tagId);
}
