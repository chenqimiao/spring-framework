package com.github.chenqimiao.databinder;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/14 16:18
 * @Description:
 */
public class DataBinderDemo {

	public static void main(String[] args) {

		User user = new User();
		Map<String, Object> source = new HashMap<>();
		source.put("id", 1);
		source.put("name", "陈其苗");

		//默认会忽略未知字段
		source.put("age", 26);

		// 默认会自动生成嵌套对象
		// Company company = new Company; company.setName("github"); user.setCompany(company);
		source.put("company.name", "github");

		PropertyValues pvs = new MutablePropertyValues(source);
		DataBinder dataBinder = new DataBinder(user, "user");

		// 关闭忽略未知字段，pvs 中若存在未知字段，则会抛出异常
		// dataBinder.setIgnoreUnknownFields(false);

		// 关闭自动增长嵌套路径， 仅source.put("company.name", "github"); 则会抛出异常
		// dataBinder.setAutoGrowNestedPaths(false);

		// 设置 required fields
		dataBinder.setRequiredFields("city");

		// 设置忽略无效字段
		// dataBinder.setIgnoreInvalidFields(true);

		// 设置允许注入的字段（白名单）
		// dataBinder.setAllowedFields("id");

		// 设置不允许注入的字段（黑名单）, 若黑白名单冲突，黑名单的优先级会高一些
		// dataBinder.setDisallowedFields("name");

		dataBinder.bind(pvs);

		System.out.println(user);

		BindingResult result = dataBinder.getBindingResult();
		for (ObjectError objectError : result.getAllErrors()) {
			// 利用 objectError.getCodes()/getArguments(), 再结合 MessageSource 可实现 i18n
			System.out.println(objectError);
			MessageSource messageSource = createMessageSource();
			Object[] arguments = objectError.getArguments();
			if(!ObjectUtils.isEmpty(arguments)){
				for (Object arg : arguments){
					if(arg instanceof MessageSourceResolvable){
						String msg = messageSource.getMessage((MessageSourceResolvable)arg, Locale.getDefault());
						System.out.println(msg);
					}
				}
			}

		}
	}

	private static MessageSource createMessageSource() {
		StaticMessageSource messageSource = new StaticMessageSource();
		messageSource.addMessage("user.city", Locale.getDefault(), "city 不能为 null");
		return messageSource;
	}

	static class Company {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Company{" +
					"name='" + name + '\'' +
					'}';
		}
	}
	static class User {

		private Integer id;

		private String name;

		private String city;

		private Company company;

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

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

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

		@Override
		public String toString() {
			return "User{" +
					"id=" + id +
					", name='" + name + '\'' +
					", company=" + company +
					'}';
		}
	}
}
