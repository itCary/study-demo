package online.goudan.mapper;

import online.goudan.pojo.TbResources;

import java.util.List;

public interface TbResourcesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbResources record);

    int insertSelective(TbResources record);

    TbResources selectByPrimaryKey(Long id);

    List<TbResources> selectAll();

    int updateByPrimaryKeySelective(TbResources record);

    int updateByPrimaryKey(TbResources record);
}