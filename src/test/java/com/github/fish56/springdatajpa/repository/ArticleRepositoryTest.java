package com.github.fish56.springdatajpa.repository;

import com.alibaba.fastjson.JSONObject;
import com.github.fish56.springdatajpa.SpringDataJpaImplApplicationTests;
import com.github.fish56.springdatajpa.entity.Article;
import com.github.fish56.springdatajpa.entity.Comment;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArticleRepositoryTest extends SpringDataJpaImplApplicationTests {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;

    private Article article1;
    private Comment comment1;
    private Comment comment2;
    private List<Comment> comments;

    @Before
    public void init(){
        article1 = new Article();
        article1.setContent("真好");

        comment1 = new Comment();
        comment1.setContent("还行");

        comment2 = new Comment();
        comment2.setContent("不错");

        comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
    }

    @Test
    public void saveComment(){
        commentRepository.save(comment1);
        Iterable<Comment> comments = commentRepository.findAll();
        System.out.println(JSONObject.toJSONString(comments));

    }

    @Test
    public void save(){
        commentRepository.save(comment1);
        commentRepository.save(comment2);

        article1.setComments(comments);
        articleRepository.save(article1);

        Iterable<Article> articles = articleRepository.findAll();
        System.out.println(JSONObject.toJSONString(articles));
    }
}