package org.agtsys.test;

import org.agtsys.entity.AsUser;
import org.agtsys.mapper.AsUserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MapperTest {
	
	private AsUserMapper asUserMapper;
	
	@Before
	public void setUp() throws Exception{
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		asUserMapper=ac.getBean(AsUserMapper.class);
	}
	
	@Test
	public void testMapper(){
		AsUser asUser=new AsUser();
		asUser.setIsstart(1);
		asUser.setUsercode("admin");
		AsUser user=asUserMapper.getUserByUser(asUser);
//		System.out.println(user.getUsername());
		Assert.assertNotNull(user);
	}

}
