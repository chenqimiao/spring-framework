package com.github.chenqimiao.resource;

import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;
/**
 * @Auther: chenqimiao
 * @Date: 2020/5/1 17:30
 * @Description:
 */
@Configuration
public class SpringResourceDemo {

	@Autowired
	private ResourceLoader resourceLoader;

	@Value("${user.dir}")
	private String projectRootPath;

	@PostConstruct
	public void init() throws IOException {
		Resource resource = resourceLoader.getResource("file://" + projectRootPath + "/spring-chenqimiao/src/main/java/com/github/chenqimiao/resource/SpringResourceDemo.java");
		System.out.println(StreamUtils.copyToString(resource.getInputStream(), Charset.forName("UTF-8")));
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringResourceDemo.class);

	}
}
