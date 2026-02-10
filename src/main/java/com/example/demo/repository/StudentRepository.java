package com.example.demo.repository;

import com.example.demo.models.Student;

import java.util.List;
import java.util.Optional;

/**
 * 学生数据访问接口
 */
public interface StudentRepository {

    /**
     * 根据ID查询学生
     *
     * @param id 主键
     * @return 学生信息
     */
    Optional<Student> findById(Long id);

    /**
     * 查询所有学生
     *
     * @return 学生列表
     */
    List<Student> findAll();

    /**
     * 根据学号查询学生
     *
     * @param studentNo 学号
     * @return 学生信息
     */
    Optional<Student> findByStudentNo(String studentNo);

    /**
     * 插入学生
     *
     * @param student 学生信息
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 更新学生
     *
     * @param student 学生信息
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 根据ID删除学生
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
}
