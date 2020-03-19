/**
 * This package builds on the beans package to add support for
 * message sources and for the Observer design pattern, and the
 * ability for application objects to obtain resources using a
 * consistent API.
 *
 * <p>There is no necessity for Spring applications to depend
 * on ApplicationContext or even BeanFactory functionality
 * explicitly. One of the strengths of the Spring architecture
 * is that application objects can often be configured without
 * any dependency on Spring-specific APIs.
 *
 *
 * Spring IOC生命周期
 *
 * Xml/Annotation class/Properties -> BeanFactory/ApplicationContext -> XmlBeanDefinitionReader -> Register BeanDefinition
 * -> BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry(BeanDefinitionRegistry)
 *    -> Register BeanDefinition(通过解析@Configuration class)
 * -> BeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)
 *
 * [
 * -> Register BeanPostProcessors
 * -> initMessageSource
 * -> initApplicationEventMulticaster
 * -> Register Listeners
 * ]
 *
 * -> Register BeanDefinition
 * -> getMergedBeanDefinition
 * -> AbstractBeanFactory#resolveBeanClass(RootBeanDefinition, String, Class[])
 *   （最终将beanClass由String类型转化成Class类型的对象）
 * -> InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation(Class, String)
 *   （可以用来替换Spring实例化Bean的过程，该方法返回值不为空，则绕开后续Spring实例化操作，将返回值作为最终容器中的Bean）
 * -> Instantiate Bean Object (可能会发生构造器注入)
 * -> MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition(RootBeanDefinition, Class, String)
 *    (对MergedBeanDefinition做一些后处理或者说解析)
 * -> InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation(Object, String)
 *	 （可以用来忽略后置属性注入/赋值，以及后续的InstantiationAwareBeanPostProcessor的方法调用）
 *
 * -> 自动注入属性解析
 *
 * -> InstantiationAwareBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)
 *    (可以在这里对PropertyValues属性集做一些改造或者增强)
 *
 * -> 属性注入（自动注入解析出来的属性也在此处进行注入）
 *
 * -> aware接口回调
 *
 * -> BeanPostProcessor#postProcessBeforeInitialization(Object, String)[包括@PostConstruct注解驱动回调、ApplicationContextAware回调]
 *
 * -> InitializingBean#AfterPropertiesSet
 *
 * -> custom init method
 *
 * -> AbstractAutowireCapableBeanFactory#invokeInitMethods(String, Object, RootBeanDefinition)
 *
 * -> BeanPostProcessor#postProcessAfterInitialization(Object, String)
 *
 * -> SmartInitializingSingleton#afterSingletonsInstantiated()[通常在Spring ApplicationContext场景下使用]
 *
 * -> DestructionAwareBeanPostProcessor#postProcessBeforeDestruction[包括@PreDestory注解驱动回调]
 *
 * -> DisposableBean#destroy
 *
 * -> custom destroy method
 */
@NonNullApi
@NonNullFields
package org.springframework.context;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
