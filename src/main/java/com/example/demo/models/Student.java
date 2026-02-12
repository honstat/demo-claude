package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 学生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    /**
     * 主键
     */
    private Long id;

    /**
     * 学号
     */
    private String studentNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 0:女 1:男
     */
    private Integer gender;

    /**
     * 年级
     */
    private String grade;

    /**
     * 班级
     */
    private String className;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除标记：true-已删除，false-未删除
     */
    private Boolean deleted;
}
