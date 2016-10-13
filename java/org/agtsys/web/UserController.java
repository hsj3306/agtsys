package org.agtsys.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.agtsys.entity.AsUser;
import org.agtsys.service.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.agtsys.constants.WebConstants.*;

@Controller
@RequestMapping("user/")
public class UserController {
	
	@Autowired
	private UserMapperService userMapperService;
	
	@RequestMapping(value="login",method=RequestMethod.GET)//主界面
	public String tologin(){
		return "login";	
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String dologin(String captchca,@Validated AsUser users,BindingResult result,HttpServletRequest request){
		String captchca_session=(String) request.getSession().getAttribute(SESSION_CAPTCHCA_KEY);
		if(!captchca_session.equalsIgnoreCase(captchca)){
			request.setAttribute("captchca_error", CAPTCHCA_ERROR_MESSAGE);
			return "login";
		}
		//验证
		if(result.hasErrors()){
			List<ObjectError> errors=result.getAllErrors();
			request.setAttribute("user_validate_errors", errors);
			return "login";
		}else{
			//验证登录
			users=userMapperService.getUserByUser(users);
			if(users!=null){
				return "main";
			}else{
				request.setAttribute("user_login_errors", USER_LOGIN_ERROR);
				return "login";
			}
		}
	}

}

