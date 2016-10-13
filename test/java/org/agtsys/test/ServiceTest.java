package org.agtsys.test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;

import org.agtsys.entity.AsUser;
import org.agtsys.mapper.AsUserMapper;
import org.agtsys.service.UserMapperService;
import org.agtsys.service.UserMapperServiceImpl;
import org.junit.Before;
import org.junit.Test;


public class ServiceTest {
	
	@Tested
	UserMapperService ums;
	@Injectable
	AsUserMapper asuserMapper;
	
	@Before
	public void setUp() throws Exception{
		ums=new UserMapperServiceImpl();
	}
	
	@Test
	public void testService(){
		//录制
		new Expectations() {
			{
				asuserMapper.getUserByUser(withInstanceOf(AsUser.class));
				times=1;
			}
		};
		//回放
		ums.getUserByUser(new AsUser());
		//验证
		new Verifications() {
			{
				asuserMapper.getUserByUser(withInstanceOf(AsUser.class));
				times=1;
			}
		};
	}

}
