package online.goudan.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import online.goudan.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenglongliu
 * @date 2021/3/8 11:22
 * @desc HelloController
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Reference
    private HelloService helloService;

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(String name) {
        System.out.println(name);
        return helloService.sayHello(name);
    }

}
