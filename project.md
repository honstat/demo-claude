# demo-claude 项目架构文档

## 项目概述
本项目是一个学习积累Claude使用经验的示例项目，采用标准的Spring Boot分层架构。

##技术栈
| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 3.0.2 | 应用框架 |
| Java | 17 | 编程语言 |
| MyBatis | 3.0.3 | ORM框架 |
| MySQL | 8.0.32 | 数据库 |
| Lombok | - | 代码简化工具 |

## 项目结构
```
demo-claude/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java          # 应用启动类
│   │   │   ├── controller/                   # 控制器层
│   │   │   │   ├── HealthController.java      # 健康检查
│   │   │   │   └── StudentController.java     # 学生CRUD接口
│   │   │   ├── service/                      # 服务层
│   │   │   │   ├── StudentService.java        # 学生服务接口
│   │   │   │   └── impl/
│   │   │   │       └── StudentServiceImpl.java # 学生服务实现
│   │   │   ├── repository/                   # 数据访问层
│   │   │   │   ├── StudentRepository.java     # 学生仓储接口
│   │   │   │   ├── impl/
│   │   │   │   │   └── StudentRepositoryImpl.java # 学生仓储实现
│   │   │   │   └── mapper/
│   │   │   │       └── StudentMapper.java    # MyBatis Mapper接口
│   │   │   ├── models/                       # 模型层
│   │   │   │   ├── Student.java              # 学生实体
│   │   │   │   └── dto/                      # 数据传输对象
│   │   │   │       ├── StudentCreateRequest.java
│   │   │   │       └── StudentUpdateRequest.java
│   │   │   └── utils/                        # 工具类
│   │   │       └── Result.java               # 统一响应格式
│   │   └── resources/
│   │       ├── application.properties         # 应用配置
│   │       └── mapper/                       # MyBatis XML映射
│   │           └── StudentMapper.xml
```

## 功能模块

### 1. 健康检查模块
**端点**: `GET /health`
**说明**: 应用健康状态检查接口

### 2. 学生管理模块
**基路径**: `/api/st/students`

| 方法 | 端点 | 说明 |
|------|------|------|
| GET | `/api/st/students` | 查询所有学生 |
||GET | `/api/st/students/{id}` | 根据ID查询学生 |
| POST | `/api/st/students` | 创建学生 |
| PUT | `/api/st/students` | 更新学生信息 |
| DELETE | `/api/st/students/{id}` | 删除学生(逻辑删除) |

### 学生实体字段
| 字段 | 类型 | 说明 |
|------|------|------|
| id | Long | 主键 |
| studentNo | String | 学号 |
| name | String | 姓名 |
| gender | Integer | 性别(0:女,1:男) |
| grade | String | 年级 |
| className | String | 班级 |
| createTime | LocalDateTime | 创建时间 |
| updateTime | LocalDateTime | 更新时间 |
| deleted | Boolean | 逻辑删除标记 |

## 技术规范
### 逻辑删除规范（强制）
- 所有业务实体的删除操作必须使用逻辑删除，禁止物理删除
- 实体模型需包含 `deleted` 字段（Boolean 类型）用于标记删除状态
- 数据库表需包含 `deleted` 字段（TINYINT(1)，默认值 0）
- Mapper XML 中删除操作改为 UPDATE 操作，设置 `deleted = 1`
- 所有查询操作需添加 `WHERE deleted = 0` 过滤条件
- 恢复操作通过 UPDATE 将 `deleted` 设为 0 实现

## 数据库配置
- 数据库名: demo
- 服务端口: 8081
- 数据库地址: localhost:3306

## 统一响应格式
```json
{
  "code": 200,
  "message": "操作成功",
  "data": {}
}
```
