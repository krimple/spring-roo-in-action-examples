package org.rooina.coursemanager.proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.util.ClassUtils;

public class AuditAnnotationPostProcessor implements BeanPostProcessor, BeanClassLoaderAware, Ordered {

	private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setBeanClassLoader(ClassLoader classLoader) {};
	
	public int getOrder() {
		// This should run after all other post-processors, so that it can just add
		// an advisor to existing proxies rather than double-proxy.
		return LOWEST_PRECEDENCE;
	}
}
