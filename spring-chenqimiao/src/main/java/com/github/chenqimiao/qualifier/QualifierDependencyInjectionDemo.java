package com.github.chenqimiao.qualifier;

import java.util.Collection;
import javax.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/13 18:14
 * @Description:
 */
@Configuration
public class QualifierDependencyInjectionDemo {



	@Priority(0)
	public static class User1 extends User  {

		public User1(Long id) {
			super(id);
		}


	}

	@Autowired
	private User user;

	@Bean

	public User1 userx(){
		return new User1(100L);
	};


	//@Qualifier 除了可以与Autowired搭配使用，进行限定依赖注入，还可以与@Bean搭配使用，用于对Bean进行分组
	@Autowired
	@Qualifier("u1")
	private Collection<User> u1Users;


	@Autowired
	@Qualifier("u1")
	private Collection<User> u2Users;



	@Autowired
	private Collection<User> allUsers;

	@Autowired
	@UserGroup
	private Collection<User> userGroupUsers;

	@Bean
	@Qualifier("u1")
	public User user1(){
		return new User(1L);
	}

	@Bean
	@Qualifier("u1")
	public User user2(){
		return new User(2L);
	}

	@Bean
	@Qualifier("u2")
	public User user3(){
		return new User(3L);
	}


	@Bean
	@Qualifier
	public User user4(){

		return new User(4L);
	}


	@Bean
	@UserGroup
	public User user5(){
		return new User(5L);

	}
	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(QualifierDependencyInjectionDemo.class);

//		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(ac);
//		xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/config/user-definition.xml");
		ac.refresh();
		QualifierDependencyInjectionDemo demo = ac.getBean(QualifierDependencyInjectionDemo.class);

		//输出 user1 user2
		System.out.println(demo.u1Users);

		//输出 user3
		System.out.println(demo.u2Users);

		//输出user1 user2 user3 user4
		System.out.println(demo.allUsers);
		//输出 user5
		System.out.println(demo.userGroupUsers);


	}
}
