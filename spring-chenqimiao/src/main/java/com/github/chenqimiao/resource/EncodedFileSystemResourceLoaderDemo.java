package com.github.chenqimiao.resource;

import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StreamUtils;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/1 17:50
 * @Description:
 */
public class EncodedFileSystemResourceLoaderDemo {

	public static void main(String[] args) throws IOException {
		String projectRootPath = System.getProperty("user.dir");
		String currentJavaFilePath = projectRootPath + "/spring-chenqimiao/src/main/java/com/github/chenqimiao/resource/EncodedFileSystemResourceLoaderDemo.java";
		FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFilePath);
		EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");
		System.out.println(StreamUtils.copyToString(encodedResource.getInputStream(), Charset.forName("UTF-8")));
	}
}
