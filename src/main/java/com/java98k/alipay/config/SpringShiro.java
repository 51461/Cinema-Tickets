package com.java98k.alipay.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.java98k.alipay.service.relm.ShiroUserRealm;


@Configuration
public class SpringShiro {
	/**
	 * 配置SecurityManager（安全管理器）
	 * @param realm
	 * @return
	 */
	@Bean("securityManager")
	public SecurityManager securityManager(ShiroUserRealm realm ,RememberMeManager manager,SessionManager session) {
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		securityManager.setRealm(realm);
		CacheManager cache=new MemoryConstrainedCacheManager();
		securityManager.setCacheManager(cache);
		securityManager.setRememberMeManager(manager);
		securityManager.setSessionManager(session);
		return securityManager;
	}
	/**
	 * 设置工厂对象
	 * @param manager
	 * @return
	 */
	@Bean("shiroFilterFactory")
	public ShiroFilterFactoryBean filterFactory(SecurityManager manager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setLoginUrl("/doLoginUI");
		shiroFilterFactoryBean.setSuccessUrl("/doIndexUI");
		shiroFilterFactoryBean.setSecurityManager(manager);
		Map<String,String> map=new LinkedHashMap<String, String>();
		map.put("/css/**", "anon");
		map.put("/js/**", "anon");
		map.put("/images/**", "anon");
		map.put("/doRegisterUI/**", "anon");
		map.put("/doLogin/**", "anon");
		map.put("/doZhuCe/**", "anon");
		map.put("/doYanZheng/**", "anon");
		map.put("/doDLYanZheng/**", "anon");
		map.put("/doQiTaUI/**", "anon");
		map.put("/error/**", "anon");
		map.put("/index/**", "anon");
		map.put("/order/**", "anon");
		map.put("/doWangJiMiMa/**", "anon");
		map.put("/", "anon");
		map.put("/sccess/**", "anon");
		map.put("/doForgetPwdUI/**", "anon");
		map.put("/doUpdatePwd/**", "anon");
		map.put("/doLogin2/**", "anon");
		map.put("/doIndexUI4/**", "anon");
		map.put("/doLogin5/**", "anon");
		map.put("/doFindAll/**", "anon");
		map.put("/doIndexUI", "anon");
		map.put("/doLogout", "logout");
		map.put("/**", "user");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}
	/**
	 * 设置rememberMe
	 * @return
	 */
	@Bean("rememberMeManager")
	public CookieRememberMeManager meManager() {
		Cookie cookie=new SimpleCookie("remeberMe");
		cookie.setMaxAge(3000000);
		CookieRememberMeManager manager=new CookieRememberMeManager();
		manager.setCookie(cookie);
		return manager;
	}
	/**
	 * 设置session生命周期
	 * @return
	 */
	@Bean("sessionManager")
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
		sessionManager.setGlobalSessionTimeout(216000000);
		//删除无效session
		sessionManager.setDeleteInvalidSessions(true);
		//开启session校验功能
		sessionManager.setSessionValidationSchedulerEnabled(true);
		return sessionManager;
	}
	/**
	 * 权限认证和授权
	 * @return
	 */
	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor postProcessor() {
		LifecycleBeanPostProcessor processor=new LifecycleBeanPostProcessor();
		return processor;
	}
	@DependsOn("lifecycleBeanPostProcessor")
	@Bean
	public DefaultAdvisorAutoProxyCreator proxyCreator() {
		DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}
	@Bean
	public AuthorizationAttributeSourceAdvisor sourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
}
