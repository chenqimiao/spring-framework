package com.github.chenqimiao.validation;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/14 13:54
 * @Description:
 */
public class ValidatorDemo {

	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		Validator validator = new UserValidator();
		if(validator.supports(user.getClass())){
			Errors errors = new BeanPropertyBindingResult(user, "user");
			validator.validate(user, errors);
			MessageSource messageSource = createMessageSource();

			for (ObjectError error : errors.getAllErrors()){
				String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
				System.out.println(message);
			}
		}
	}

	private static MessageSource createMessageSource() {
		StaticMessageSource messageSource = new StaticMessageSource();
		messageSource.addMessage("id.required", Locale.getDefault(), "id 不能为 null");
		messageSource.addMessage("name.required", Locale.getDefault(), "name 不能为 null");
		return messageSource;
	}


	static class User {
		private Integer id ;
		private String name;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	static class UserValidator implements Validator {

		@Override
		public boolean supports(Class<?> clazz) {
			return User.class.isAssignableFrom(clazz);
		}

		@Override
		public void validate(Object target, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		}
	}
}
