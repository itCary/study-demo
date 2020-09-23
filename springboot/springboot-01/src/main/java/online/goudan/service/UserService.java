package online.goudan.service;

import online.goudan.mapper.TbUserMapper;
import online.goudan.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/23 17:04
 */
@Service
public class UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    public TbUser queryById(Long id) {
        return tbUserMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void saveTbUser(TbUser tbUser) {
        tbUserMapper.insertSelective(tbUser);
    }
}
