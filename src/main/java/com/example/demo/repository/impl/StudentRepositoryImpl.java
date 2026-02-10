package com.example.demo.repository.impl;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.mapper.StudentMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 学生数据访问实现类
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentMapper studentMapper;

    public StudentRepositoryImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(studentMapper.findById(id));
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public Optional<Student> findByStudentNo(String studentNo) {
        return Optional.ofNullable(studentMapper.findByStudentNo(studentNo));
    }

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int deleteById(Long id) {
        return studentMapper.deleteById(id);
    }
}
