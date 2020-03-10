/**
 * Spring's variant of the AOP Alliance interfaces.
 *
 * MethodInterceptor 最终会以chain的形式封装到MethodInvocation,
 * 此外，一般情况下Advice会被适配成MethodInterceptor
 */
package org.aopalliance;
