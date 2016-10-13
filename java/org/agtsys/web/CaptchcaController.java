package org.agtsys.web;

import static org.agtsys.constants.WebConstants.*;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.agtsys.service.CaptchcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("captchca/")
public class CaptchcaController {
	
	@Autowired
	private CaptchcaService captchcaService;

	@RequestMapping(value="get",method=RequestMethod.GET)
	public void getCaptchca(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws Exception{
		OutputStream out=response.getOutputStream();
		String captchca=captchcaService.generate_captchca(out);
		//保存验证码字符串到session中,为了验证使用
		session.setAttribute(SESSION_CAPTCHCA_KEY, captchca);
		out.flush();
		out.close();
	}
	
	@ResponseBody
	@RequestMapping(value="check",method=RequestMethod.POST)
	public Object checkCaptchca(String captchca,HttpSession session){
		String cs=(String) session.getAttribute(SESSION_CAPTCHCA_KEY);
		if(cs.equalsIgnoreCase(captchca)){
			return "yes";
		}else{
			return "no";
		}
	}

}
