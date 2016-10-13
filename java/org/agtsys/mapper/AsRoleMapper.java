package org.agtsys.mapper;

import org.agtsys.entity.AsRole;

public interface AsRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AsRole record);

    int insertSelective(AsRole record);

    AsRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AsRole record);

    int updateByPrimaryKey(AsRole record);
}