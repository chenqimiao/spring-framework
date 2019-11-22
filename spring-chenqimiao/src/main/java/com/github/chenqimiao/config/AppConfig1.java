package com.github.chenqimiao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/21 15:19
 * @Description:
 */
@Configuration
public class AppConfig1 implements ImportAware {

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		System.out.println(importMetadata);
	}
}
