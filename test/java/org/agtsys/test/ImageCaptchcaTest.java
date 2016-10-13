package org.agtsys.test;

import java.io.FileOutputStream;

import org.agtsys.util.ImageCaptchca;
import org.junit.Before;
import org.junit.Test;

public class ImageCaptchcaTest {
	
	private ImageCaptchca ic;
	
	@Before
	public void setUp() throws Exception{
		ic=new ImageCaptchca();
	}
	
	@Test
	public void TestImageCaptchca() throws Exception{
		FileOutputStream fos = new FileOutputStream("patcha_demo.png");
		String cp=ic.generate_captchca(fos);
		System.out.println(cp);
	}
	
	

}
