package online.goudan.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import online.goudan.service.HelloService;

/**
 * @author chenglongliu
 * @date 2021/3/8 11:06
 * @desc HelloServiceImpl
 */
@Service //发布为服务，必须使用dubbo提供的注解
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello," + name;
    }
}
