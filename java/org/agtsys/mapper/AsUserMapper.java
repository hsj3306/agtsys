package org.agtsys.mapper;

import org.agtsys.entity.AsUser;

public interface AsUserMapper {
//    int deleteByPrimaryKey(Long id);
//
//    int insert(AsUser record);
//
//    int insertSelective(AsUser record);
//
//    AsUser selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(AsUser record);
//
//    int updateByPrimaryKey(AsUser record);
	
	AsUser getUserByUser(AsUser asUser);
	
}