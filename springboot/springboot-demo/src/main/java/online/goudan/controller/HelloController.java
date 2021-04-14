package online.goudan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author chenglongliu
 * @date 2021/4/14 15:38
 * @desc HelloController
 */
@RestController
@Slf4j
public class HelloController {


    @Autowired
    private DataSource dataSource;

    @GetMapping("/hello")
    public String hello() {
        log.debug("hello: " + dataSource);
        return "hello!!!";
    }
}
