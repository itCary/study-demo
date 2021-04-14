package online.goudan.service;

import lombok.extern.slf4j.Slf4j;
import online.goudan.mapper.UserMapper;
import online.goudan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenglongliu
 * @date 2021/4/14 16:15
 * @desc UserService
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Transactional
    public void saveUser(User user) {
        log.debug("saveUser: 新增用户=" + user);
        userMapper.insert(user);
    }
}
