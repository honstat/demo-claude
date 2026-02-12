# 项目变更历史

## 2026-02-12 22:28:00
### 变更内容：Student实体逻辑删除改造
- 在Student实体中添加deleted字段(Boolean类型)
- 在student表中添加deleted字段(TINYINT(1)，默认值0)
- 修改StudentMapper.xml，将物理删除改为逻辑删除(UPDATE deleted=1)
- 在所有查询语句中添加逻辑删除过滤条件(WHERE deleted=0)
- 在CLAUDE.md中添加逻辑删除规范

## 2025-02-10 23:43:00
### 变更内容：实现Student实体的全链路CRUD功能
- 新增Student实体类(models/Student.java)
- 新增StudentCreateRequest和StudentUpdateRequest DTO类
- 新增StudentRepository数据访问层接口及实现
- 新增StudentMapper MyBatis映射文件
- 新增StudentService服务层接口及实现
- 新增StudentController控制器
- 新增Result统一API响应工具类
- 实现学生信息的增删改查完整功能

## 2025-02-10 23:09:00
### 变更内容：初始化Spring Boot项目并添加健康检查接口
- 创建Spring Boot 3.0.2项目基础结构
- 配置Java 17环境
- 集成MyBatis 3.0.3和MySQL 8.0.32驱动
- 配置数据源连接
- 新增HealthController健康检查接口
