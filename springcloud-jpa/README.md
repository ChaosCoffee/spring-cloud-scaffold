# springcloud-jpa脚手架  

## Maven依赖
### 引入JPA依赖  

``` xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
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

## 其他功能
仓库下`src/main/**/util/Sequence.java `  
调用方法可参考`src/test/**/SequenceTests.java`
``` java
Sequence sequence = new Sequence(0, 0);
Long id = sequence.nextId();
```
添加序列号生成方法，基于Twitter的Snowflake算法实现分布式高效有序ID。  
详见: [分布式高效ID生产黑科技(sequence)](https://gitee.com/yu120/sequence)

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
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update # update -> 比较JPARepository Entity是否和表一样，不一样则更新,create -> 每次启动重新创建表,validate -> 验证表结构
    properties:
      hibernate:
        show_sql: true #打印SQL
        use_sql_comments: true
        format_sql: true
  h2:
    console:
      enabled: true
      path: /h2-console #H2控制台访问路径
      settings:
        trace: false
        web-allow-others: true
```

## 测试
1. 返回数据遵循json规范  
json解析数据为null，则过滤key  
``` json
{
  "code": 0,
  "data": "{}",
  "message":"xxx"
}

```

2. 测试地址  

2.1 保存用户  

``` bash  
curl -H "Content-Type:application/json" -X POST -d '{"name": "张三","totalAmount":"100.00"}' http://localhost:8088/user/saveUser
```  

Return:  

``` json
{
    "code": 0,
    "data": {
        "userCode": 74583520122503168
    }
}
```

2.2 查询用户  

``` bash
curl http://localhost:8088/user/gerUser/userCode=74583520122503168
```

Return: 

``` json
{
    "code": 0,
    "data": {
        "id": 2,
        "userCode": 74583520122503168,
        "name": "李四",
        "totalAmount": 100,
        "createTime": "2018-09-21T17:41:14.705",
        "updateTime": "2018-09-21T17:41:14.74"
    }
}
```

2.3 数据库查询  
访问地址`http://localhost:8088/h2-console `  
JDBC URL,username和password在配置文件里。
