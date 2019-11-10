package com.mvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class UserExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex) {
		// 首先解析出异常的类型
		UserException userException = null;
		if (ex instanceof UserException) {
			// 如果异常类型是UserException,则直接创建该类型的异常信息
			userException = (UserException) ex;
		} else {
			// 否则创建一个自定义的异常类型
			userException = new UserException("发生未知错误。");
		}
		
		// 取出错误信息
		String errorMessage = userException.getExceptionMessage();
		ModelAndView modelAndView = new ModelAndView();
		// 错误信息传送到前端页面
		modelAndView.addObject("errorMessage", errorMessage);
		// 定向到错误提示页面
		modelAndView.setViewName("errorPage/userError");
		
		return modelAndView;
	}
	
}
