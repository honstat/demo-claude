package com.example.demo.service;

import com.example.demo.models.Student;
import com.example.demo.models.dto.StudentCreateRequest;
import com.example.demo.models.dto.StudentUpdateRequest;

import java.util.List;
import java.util.Optional;

/**
 * 学生服务接口
 */
public interface StudentService {

    /**
     * 根据ID查询学生
     *
     * @param id 主键
     * @return 学生信息
     */
    Optional<Student> getStudentById(Long id);

    /**
     * 查询所有学生
     *
     * @return 学生列表
     */
    List<Student> getAllStudents();

    /**
     * 根据学号查询学生
     *
     * @param studentNo 学号
     * @return 学生信息
     */
    Optional<Student> getStudentByNo(String studentNo);

    /**
     * 创建学生
     *
     * @param request 创建请求
     * @return 创建的学生信息
     */
    Student createStudent(StudentCreateRequest request);

    /**
     * 更新学生
     *
     * @param request 更新请求
     * @return 更新后的学生信息
     */
    Student updateStudent(StudentUpdateRequest request);

    /**
     * 删除学生
     *
     * @param id 主键
     * @return 是否删除成功
     */
    boolean deleteStudent(Long id);
}
