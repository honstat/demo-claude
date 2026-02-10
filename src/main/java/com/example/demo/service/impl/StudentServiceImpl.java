package com.example.demo.service.impl;

import com.example.demo.models.Student;
import com.example.demo.models.dto.StudentCreateRequest;
import com.example.demo.models.dto.StudentUpdateRequest;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * 学生服务实现类
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentByNo(String studentNo) {
        if (studentNo == null || studentNo.isEmpty()) {
            return Optional.empty();
        }
        return studentRepository.findByStudentNo(studentNo);
    }

    @Override
    public Student createStudent(StudentCreateRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("创建请求不能为空");
        }

        // 检查学号是否已存在
        Optional<Student> existStudent = studentRepository.findByStudentNo(request.getStudentNo());
        if (existStudent.isPresent()) {
            throw new IllegalArgumentException("学号已存在: " + request.getStudentNo());
        }

        Student student = new Student();
        student.setStudentNo(request.getStudentNo());
        student.setName(request.getName());
        student.setGender(request.getGender());
        student.setGrade(request.getGrade());
        student.setClassName(request.getClassName());
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());

        studentRepository.insert(student);
        return student;
    }

    @Override
    public Student updateStudent(StudentUpdateRequest request) {
        if (request == null || request.getId() == null) {
            throw new IllegalArgumentException("更新请求或ID不能为空");
        }

        Optional<Student> existStudent = studentRepository.findById(request.getId());
        if (existStudent.isEmpty()) {
            throw new IllegalArgumentException("学生不存在: " + request.getId());
        }

        Student student = existStudent.get();
        student.setName(request.getName());
        student.setGender(request.getGender());
        student.setGrade(request.getGrade());
        student.setClassName(request.getClassName());
        student.setUpdateTime(LocalDateTime.now());

        studentRepository.update(student);
        return student;
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (id == null) {
            return false;
        }
        return studentRepository.deleteById(id) > 0;
    }
}
