# CLAUDE.md
请始终使用简体中文与我对话，回答代码相关问题时保持专业、简洁、结构清晰。

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.





# demo-claude
学习积累claude经验的项目

## 启动
 如果有会话 恢复最近一次会话
 claude --resume demo-claude
 如果没有会话，创建指定会话
 claude --session demo-claude
## 压缩上下文
/compact
打日志，提示正在压缩上下文
### 压缩策略
上下文超长或对话轮数超过10轮


## 常用命令

### Maven 构建
```bash
# 编译项目
mvn compile

# 运行测试
mvn test

# 打包
mvn package

# 跳过测试打包
mvn package -DskipTests

# 运行应用
mvn spring-boot:run

# 清理并重新构建
mvn clean install
```

## 基本约束
 - 所有文字和回复采用简体中文 配置和代码除外
 - 记忆本项目的上次会话，新打开项目时加载历史会话

## 开发规范
### **后端采用java语言**
  - springboot 3.0
  - java17
  - mysql8.0数据库
  - mybatis

### **后端技术规范**
  - 模块分层划分 models DTO模型层 reposotory 数据层 内部包含mapper文件夹 controller请求入口 utils 工具层 service 服务实现层

  - 驼峰命名
  - 其他规范参照阿里编码规约

  - **逻辑删除规范**（强制）：
    - 所有业务实体的删除操作必须使用逻辑删除，禁止物理删除
    - 实体模型需包含 `deleted` 字段（Boolean 类型）用于标记删除状态
    - 数据库表需包含 `deleted` 字段（TINYINT(1)，默认值 0）
    - Mapper XML 中删除操作改为 UPDATE 操作，设置 `deleted = 1`
    - 所有查询操作需添加 `WHERE deleted = 0` 过滤条件
    - 恢复操作通过 UPDATE 将 `deleted` 设为 0 实现


 ## 行为规范
 ### 常规
  - 用户提出开发和修改需求时先思考和追问 澄清后再开始编码

  - 排查问题时需要检查相关联上下游和类似用到的地方是否也有异常，罗列出来和用户确认
  - 开发或修改完成时需要编译通过，规划测试用例，并运行测试用例
  - 测试用例需要覆盖修改的代码和检查服务是否已成功启动
  
 ##  测试
  - 测试通过后问询研发是否需要提交到远程git仓库

 ### 验证完成后动作
  - 更新需求内容到项目根目录changelog.md中 以日期时间（yyyy-MM-dd HH:mm:ss） 变更内容 内容子项的形式
  - 更新当前最新的架构和功能到项目根目录 project.md文件中

# 项目说明
  请参考 @README.md 了解项目概况。

 ## Claude 指令