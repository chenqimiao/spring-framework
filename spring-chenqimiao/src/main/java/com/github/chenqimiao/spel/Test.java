package com.github.chenqimiao.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/12 13:43
 * @Description:
 */
public class Test {

	public static void main(String args[]){
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("'Hello World'");
		System.out.println(expression.getValue());

		Expression exp = parser.parseExpression("'Hello World'.concat('!')");
		System.out.println(exp.getValue());

	}

}
