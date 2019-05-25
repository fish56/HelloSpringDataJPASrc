package com.github.fish56.springdatajpa.preaction;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Note {
    @Id // 主键是必须指定的
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Column(nullable = false) // 映射为字段，值不能为空
    private Date createTime;

    @Column(nullable = false) // 映射为字段，值不能为空
    private Date updateTime;

    /**
     * 存入数据库之前触发
     */
    @PrePersist
    public void onCreate(){
        this.createTime = new Date();
        this.updateTime = new Date();
        System.out.println("PrePersist--------");
    }

    /**
     * 更新记录的时候触发
     */
    @PreUpdate
    public void onUpdate(){
        System.out.println(updateTime);
        this.updateTime = new Date();
        System.out.println(updateTime);
        System.out.println("PreUpdate--------");
    }
}