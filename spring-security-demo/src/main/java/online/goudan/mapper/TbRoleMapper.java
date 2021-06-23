package online.goudan.mapper;

import online.goudan.pojo.TbRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbRole record);

    int insertSelective(TbRole record);

    TbRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRole record);

    int updateByPrimaryKey(TbRole record);

}