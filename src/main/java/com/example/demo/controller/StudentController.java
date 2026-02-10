package com.example.demo.controller;

import com.example.demo.models.Student;
import com.example.demo.models.dto.StudentCreateRequest;
import com.example.demo.models.dto.StudentUpdateRequest;
import com.example.demo.service.StudentService;
import com.example.demo.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生控制器
 */
@RestController
@RequestMapping("/api/st/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 根据IDID查询学生
     *
     * @param id 主键
     * @return 学生信息
     */
    @GetMapping("/{id}")
    public Result<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(Result::success)
                .orElseGet(() -> Result.error("学生不存在: " + id));
    }

    /**
     * 查询所有学生
     *
     * @return 学生列表
     */
    @GetMapping
    public Result<List<Student>> getAllStudents() {
        return Result.success(studentService.getAllStudents());
    }

    /**
     * 创建学生
     *
     * @param request 创建请求
     * @return 创建的学生信息
     */
    @PostMapping
    public Result<Student> createStudent(@RequestBody StudentCreateRequest request) {
        try {
            Student student = studentService.createStudent(request);
            return Result.success("创建成功", student);
        } catch (IllegalArgumentException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 更新学生
     *
     * @param request 更新请求
     * @return 更新后的学生信息
     */
    @PutMapping
    public Result<Student> updateStudent(@RequestBody StudentUpdateRequest request) {
        try {
            Student student = studentService.updateStudent(request);
            return Result.success("更新成功", student);
        } catch (IllegalArgumentException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 删除学生
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public Result<Void> deleteStudent(@PathVariable Long id) {
        boolean success = studentService.deleteStudent(id);
        if (success) {
            return Result.success("删除成功");
        } else {
            return Result.error("删除失败，学生不存在: " + id);
        }
    }
}
