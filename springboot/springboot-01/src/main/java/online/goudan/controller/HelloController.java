package online.goudan.controller;

import online.goudan.config.JdbcProperties;
import online.goudan.pojo.TbUser;
import online.goudan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/23 15:36
 */
@RestController
public class HelloController {


    @Autowired
    private UserService userService;


    @GetMapping("/user/{uid}")
    public TbUser queryById(@PathVariable("uid") Long id) {
        return userService.queryById(id);
    }
}
