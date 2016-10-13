package org.agtsys.util;

import java.io.OutputStream;

import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;

public class ImageCaptchca implements Captchca{
	
	private ImageCaptchcaService ics;

	public void setIcs(ImageCaptchcaService ics) {
		this.ics = ics;
	}
	
	public ImageCaptchca() {
		ics=new ImageCaptchcaService();
	}

	@Override
	public String generate_captchca(OutputStream os) throws Exception {

		String Captchca=EncoderHelper.getChallangeAndWriteImage(ics, "png", os);
		return Captchca;
	}

}
