package com.github.chenqimiao.messageformat;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/2 19:27
 * @Description:
 */
public class MessageFormatDemo {

	public static void main(String[] args) {
		int planet = 7;
		String event = "a disturbance in the Force";
		String messagePattern = "At {1,time,full} on {1,date,long}, there was {2} on planet {0,number,integer}.";
		//静态方法
		String result = MessageFormat.format(messagePattern, planet, new Date(), event);
		System.out.println(result);


		//实例方法
		MessageFormat messageFormat = new MessageFormat(messagePattern);
		result = messageFormat.format(new Object[]{planet, new Date(), event});
		System.out.println(result);

		//重置pattern
		messageFormat.applyPattern("{0} in {1} now");
		result = messageFormat.format(new Object[]{"Qimiao Chen", "Hangzhou"});
		System.out.println(result);

		//重置格式
		messageFormat.applyPattern(messagePattern);
		messageFormat.setFormatByArgumentIndex(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		result = messageFormat.format(new Object[]{planet, new Date(), event});
		System.out.println(result);
	}

}
