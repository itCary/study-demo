package online.goudan.dao.impl;

import com.sun.org.apache.xml.internal.security.Init;
import online.goudan.dao.UserDao;

/**
 * @author 刘成龙
 * @description
 * @date 2020/9/10 22:01
 */
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running............");
    }

    public void init() {
        System.out.println("init running.......");
    }

    public void destory() {
        System.out.println("destory running.......");
    }
}
