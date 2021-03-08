package online.goudan.controller;

import lombok.extern.slf4j.Slf4j;
import online.goudan.pojo.TbUser;
import online.goudan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/23 15:36
 */
@RestController
@Slf4j
public class HelloController {


    @Autowired
    private UserService userService;


    @GetMapping("/user/{uid}")
    public TbUser queryById(@PathVariable("uid") Long id) {
        TbUser tbUser = userService.queryById(id);
        log.debug(tbUser.toString());
        return tbUser;
    }
}
