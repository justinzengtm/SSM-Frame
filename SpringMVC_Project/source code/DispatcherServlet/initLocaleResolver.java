private void initLocaleResolver(ApplicationContext context) {
	try {
		// 从配置的Web应用程序环境中查找地域请求解析器
		this.localeResolver = context.getBean(LOCALE_RESOLVER_BEAN_NAME, 
				LocaleResolver.class);
		if (logger.isDebugEnabled()) {
			logger.debug("Using LocaleResolver [" + this.localeResolver + "]");
		}
	} catch (NoSuchBeanDefinitionException ex) {
		// 如果没有查找到低于请求解析器,则查找默认的配置,并根据默认配置初始化地域解析器
		this.localResolver = getDefaultStrategy(context, LocaleResolver.class);
		if (logger.isDebugEnabled()) {
			logger.debug("Unable to locate LocaleResolver with name '" + 
					LOCALE_RESOLVER_BEAN_NAME + "': using default [" + this.localResolver + 
					"]");
		}
	}
}
