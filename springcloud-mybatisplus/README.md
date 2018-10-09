# springcloud-mybatisplus脚手架  

## Maven依赖
### 引入mybatisplus依赖  

``` xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.0.3</version>
</dependency>
```

### 数据库选择  
这里引入h2内嵌数据库，是为了更方便本地开发测试，正常环境下MySQL或者其他数据库居多。
``` xml
<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <scope>runtime</scope>
</dependency>

<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
```

### 常用组件
很方便的一个组件，省去了setter，getter等方法，用注解代替，编译期生成代码。
``` xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

## 配置说明
``` yml
spring:
  datasource:
    url: jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE #H2内嵌数据库,加mem是保存内存中，不加保存在本地
    platform: h2
    username: sa
    password: password
    driverClassName: org.h2.Driver
    schema: classpath:db/schema.sql #启动项目时初始化创建表SQL
    data: classpath:db/data.sql # 启动项目初始化插入数据SQL
  h2:
    console:
      enabled: true
      path: /h2-console #H2控制台访问路径
      settings:
        trace: false
        web-allow-others: true
  server:
    port: 8088
```

## 代码生成  
为了减少编写重复代码，`com.chaoscoffee.generator.CodeGenerator`里可以生成相应`mapper`接口和`entity`,`service`等类，以及映射文件。通过`main()`方法运行。

## 测试

2. 测试地址

2.1 数据库查询  
访问地址`http://localhost:8088/h2-console `  
JDBC URL,username和password在配置文件里。
