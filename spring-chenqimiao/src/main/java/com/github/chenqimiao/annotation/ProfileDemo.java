package com.github.chenqimiao.annotation;

import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description: @Profile 示例
 * @Author: Qimiao Chen
 * @Create: 2020-07-10 22:02
 **/
@Configuration
public class ProfileDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(ProfileDemo.class);
		ConfigurableEnvironment environment = ac.getEnvironment();
		environment.setDefaultProfiles("odd");
		environment.addActiveProfile("even");
		ac.refresh();
		Integer num = ac.getBean("number", Integer.class);
		System.out.println(num);
	}

	@Bean(name = "number")
	@Profile("odd")
	public Integer odd() {
		return 1;
	}
	@Bean(name = "number")
	//@Profile("even")
	@Conditional(value = EvenProfileCondition.class)
	public Integer even() {
		return 2;
	}

	public static class EvenProfileCondition implements Condition{

		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			//return context.getEnvironment().acceptsProfiles("even");
			//return context.getEnvironment().acceptsProfiles(Profiles.of("even"));
			return context.getEnvironment().acceptsProfiles(Profiles.of("!odd"));
		}
	}
}
