# FIRSTSB

#### 介绍
基于springboot的java服务端基础框架搭建。
仅供自己学习之用

1. lombok （pom.xml 依赖；idea lombak插件）https://blog.csdn.net/ThinkWon/article/details/101392808
2. mysql、mybatis接入
3. mybatis逆向工程接入（由mysql数据库表生成相应的mapper,xml,po）
4. mybatis分页插件的接入
5. redis接入
6. 文件上传 *待完善*
7. 全局异常处理（GlobalExceptionHandler）
8. 日志系统（slf4j）
9. 统一响应封装（Response）
10. 数据验证（一般注解和自定义注解）验证不通过会抛出异常，在GlobalExceptionHandler处理之后返回给客户端
11. http请求（RestTemplate，HttpClient）
12. Thymeleaf接入
13. RabbitMQ消息中间件接入(延迟消息需要 rabbitmq_delayed_message_exchange 插件，并启动该插件)
14. Shiro安全框架接入 *待完成*
15. 拦截器 
16. JWT