# CLAUDE.md
请始终使用简体中文与我对话，回答代码相关问题时保持专业、简洁、结构清晰。

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.





# demo-claude
学习积累claude经验的项目

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

 ## 行为规范
 ### 常规
  - 用户提出开发和修改需求时先思考和追问 澄清后再开始编码

  - 排查问题时需要检查相关联上下游和类似用到的地方是否也有异常，罗列出来和用户确认
  - 开发或修改完成时需要编译通过，规划测试用例，并运行测试用例
  - 测试用例需要覆盖修改的代码和检查服务是否已成功启动
  
 ##  测试
  - 测试通过后问询研发是否需要提交到远程git仓库



