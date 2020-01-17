package com.github.chenqimiao.aop;

/**
 * @Auther: chenqimiao
 * @Date: 2020/1/17 16:22
 * @Description:
 */
public class DefaultUsageTracked implements UsageTracked {

	@Override
	public void incrementUseCount() {
		System.out.println("i ++");
	}
}
