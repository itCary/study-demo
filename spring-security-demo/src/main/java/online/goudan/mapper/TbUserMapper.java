package online.goudan.mapper;

import online.goudan.pojo.TbUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TbUserMapper {
    int deleteByPrimaryKey(@Param("id") Long id, @Param("username") String username);

    int insert(TbUser record);

    int insertSelective(TbUser record);


    TbUser selectByPrimaryKey(@Param("id") Long id, @Param("username") String username);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);


}