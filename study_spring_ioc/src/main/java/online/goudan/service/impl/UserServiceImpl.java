package online.goudan.service.impl;

import online.goudan.dao.UserDao;
import online.goudan.service.UserService;

/**
 * @author 刘成龙
 * @description
 * @date 2020/9/10 22:19
 */
public class UserServiceImpl implements UserService {


    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
