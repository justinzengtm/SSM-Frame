package com.mvc.validator.group;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mvc.model.User;

public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		// 反射机制通过类的class静态变量获得该类的实例
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// 错误信息放入errors对象
		ValidationUtils.rejectIfEmpty(errors, "username", "Username.is.empty", 
				"用户名不允许为空。");
		User user = (User) obj;
		if (user.getPassword() == null || user.getPassword().equals("")) {
			// rejectValue()参数：错误字段名，全局错误码，默认错误提示信息
			errors.rejectValue("password", "Password.is.empty", "密码不允许为空。");
		} else if (user.getPassword().length() < 8) {
			errors.rejectValue("password", "Length.too.short", "密码长度不能小于八位。");
		}
	}
}
