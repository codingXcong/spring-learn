1、知识点
    RESTFul API（RESTful风格就是url+动作）
    JsonView
    Hibernate Validator(基本使用、自定义校验注解)
    mockMVC测试（HTTP接口测试）
    RESTful API错误处理
        Spring Boot默认的错误处理机制（浏览器返回一个错误页面，APP返回JSON字符串），源码参考BasicErrorController类
        自定义异常处理
            错误页面：400.html 500html
            APP JSON:见ControllerExceptionHandler
    RESTful API的拦截
        filter
        interceptor
        aspect
    SpringBoot文件上传下载
    异步处理REST服务
        使用Runnable异步处理Rest服务
        使用DeferredResult异步处理Rest服务
        异步处理配置