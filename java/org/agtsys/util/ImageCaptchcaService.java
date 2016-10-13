package org.agtsys.util;

import java.awt.Color;

import com.github.bingoohuang.patchca.background.SingleColorBackgroundFactory;
import com.github.bingoohuang.patchca.color.SingleColorFactory;
import com.github.bingoohuang.patchca.filter.predefined.CurvesRippleFilterFactory;
import com.github.bingoohuang.patchca.font.RandomFontFactory;
import com.github.bingoohuang.patchca.service.AbstractCaptchaService;
import com.github.bingoohuang.patchca.text.renderer.BestFitTextRenderer;
import com.github.bingoohuang.patchca.word.RandomWordFactory;

public class ImageCaptchcaService extends AbstractCaptchaService{
	
	public ImageCaptchcaService(){
		//设置字体大小
		RandomFontFactory font=new RandomFontFactory();
		font.setMaxSize(20);
		font.setMinSize(20);	
		fontFactory=font;
		//设置内容
		RandomWordFactory word=new RandomWordFactory();
		word.setMaxLength(4);
		word.setMinLength(4);
		wordFactory=word;
		//设置字体颜色
		colorFactory=new SingleColorFactory(Color.BLUE);
		//设置背景颜色
	    backgroundFactory=new SingleColorBackgroundFactory();
	    //设置文本渲染效果
	    textRenderer=new BestFitTextRenderer();
	    //设置干扰线
	    CurvesRippleFilterFactory filter=new CurvesRippleFilterFactory();
	    filter.setColorFactory(colorFactory);
	    filter.setStrokeMin(width);
	    filterFactory=filter;
	    
	    //设置图片大小
	    width=70;
	    height=28;
	}

}
