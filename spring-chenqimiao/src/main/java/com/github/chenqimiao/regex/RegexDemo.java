package com.github.chenqimiao.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 正则表达式 Demo
 * @Author: Qimiao Chen
 * @Create: 2021-01-04 20:00
 **/
public class RegexDemo {

	public static void main(String[] args) {
		String str = "https://github.com:443/chenqimiao";
		Pattern pattern = Pattern.compile("(\\w+)://([^/:]+)(:\\d*)?([^#]*)");
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()){
			int count = matcher.groupCount();
			for (int i = 0; i <= count; i++) {
				String matchStr = matcher.group(i);
				System.out.println(matchStr);
			}
		}

	}
}
