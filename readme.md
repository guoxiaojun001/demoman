到项目目录
http://xdouble.cn:8888/  	idea软件激活地址
1. mvn spring-boot:run
2. mvn install 生成 jar包 ，然后执行jar包，java -jar test.jar
此方式可以带参数，动态选择配置文件
java -jar test.jar --spring.profiles.active=prod
3. 生成war包 放到tomcat下

springboot2.0版本配置项目路径有变更：
2.0以下版本：server.context-path
2.0版本开始：server.servlet.context-path

4. @Controller 需要模板来配合使用
@RestController = @Controller + @ResponseBody
@GetMapping(value = "/getparam") = @RequestMapping(value = "/getparam",method = RequestMethod.GET)

5.jpa:
  hibernate:
    ddl-auto: create //每次都会创建表，会把之前的删了重新创建
ddl-auto: update//每次都会创建表，会把之前的删了重新创建


2.0.0以上版本的spring boot实体的默认引擎为MyISAM，其不支持事务，需要配置引擎为为innoDB

需要在yml的spring:jpa下设置database-platform为org.hibernate.dialect.MySQL5InnoDBDialect即可


6. 如果测试用例已经写好，执行 mvn clean package 会自动执行测试用例，如果需要跳过测试用例
mvn clean package -Dmaven.test.skip=true