package com.github.chenqimiao.resource;

import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;
import org.springframework.util.StreamUtils;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/1 18:10
 * @Description:
 */
public class CustomizedProtocolResolverDemo {
	@Autowired
	private ResourceLoader resourceLoader;

	@PostConstruct
	public void init() throws IOException {
		if(resourceLoader instanceof DefaultResourceLoader){
			DefaultResourceLoader defaultResourceLoader = (DefaultResourceLoader)resourceLoader;
			defaultResourceLoader.addProtocolResolver(new XProtocolResolver());
		}
		Resource resource = resourceLoader.getResource("x:///META-INF/properties/xxx.properties");
		System.out.println(StreamUtils.copyToString(resource.getInputStream(), Charset.forName("UTF-8")));
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(CustomizedProtocolResolverDemo.class);

	}

	static class XProtocolResolver implements ProtocolResolver {

		public static final String X_PROTOCOL_PREFIX = "x://";

		@Override
		public Resource resolve(String location, ResourceLoader resourceLoader) {
			if(location.startsWith(X_PROTOCOL_PREFIX)){
				return new ClassPathResource(location.substring(X_PROTOCOL_PREFIX.length()),
						ClassUtils.getDefaultClassLoader());
			}
			return null;
		}
	}
}
