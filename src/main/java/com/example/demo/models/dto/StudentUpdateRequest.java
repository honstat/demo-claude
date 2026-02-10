package com.example.demo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新学生请求DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateRequest {

    /**
     * 主键
     */
    private Long id;

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
}
