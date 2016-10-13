package org.agtsys.service;

import org.agtsys.entity.AsUser;
import org.agtsys.mapper.AsUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapperServiceImpl implements UserMapperService {
	
	@Autowired
	private AsUserMapper asUserMapper;

	@Override
	public AsUser getUserByUser(AsUser asUser) {
		// TODO Auto-generated method stub
		return asUserMapper.getUserByUser(asUser);
	}

	

}
