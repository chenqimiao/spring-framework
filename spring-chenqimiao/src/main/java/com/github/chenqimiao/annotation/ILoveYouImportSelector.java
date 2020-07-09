package com.github.chenqimiao.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-07-09 20:54
 **/
public class ILoveYouImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		//通过条件选择合适的Configuration
		if(true){
			return new String[]{"com.github.chenqimiao.annotation.ILoveYouConfiguration"};
		}else {
			return new String[0];
		}
	}
}
