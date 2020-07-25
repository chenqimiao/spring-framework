package com.github.chenqimiao.environment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @Description: TestPropertySource 测试类
 * @Author: Qimiao Chen
 * @Create: 2020-07-25 14:13
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestPropertySourceTest.class)
@TestPropertySource(properties ="user.name=chenqimiao",
		value = {"classpath:/META-INF/test.properties"})
public class TestPropertySourceTest {

	@Value("${user.name}")
	private String username;

	@Autowired
	private ConfigurableEnvironment environment;

	@Test
	public void testUsername() {
		assertEquals("chenqimiao", username);

		for (PropertySource ps : environment.getPropertySources()) {
			System.out.printf("PropertySource(name=%s) 'user.name' 属性：%s\n", ps.getName(), ps.getProperty("user.name"));
		}

	}
}
