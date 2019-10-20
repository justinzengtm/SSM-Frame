private void initHandlerMappings(ApplicationContext context) {
	this.initHandlerMappings = null;
	
	if (this.detectAllhandlerMappings) {
		// 如果配置为自动检测所有的处理器映射器,则在加载的Web应用程序环境中查找
		// 所有实现处理器映射器接口的Bean
		Map<String, HandlerMapping> matchingBeans = 
				BeanFactoryUtils.beansOfTypeIncludingAncestors(context, 
						HandlerMapping.class, true, false);
		if (!matchingBeans.isEmpty()) {
			this.handlerMappings = new 
					ArratList<HandlerMapping>(matchingBeans.values());
					
			// 根据这些Bean所实现的Order接口进行排序
			orderComparator.sort(this.handlerMappings);
		}
	} else {
		// 如果没有配置为自动检测所有的处理器映射器,则在Web应用程序环境中查找名为
		// "handlerMapping"的Bean作为处理器映射器
		try {
			HandlerMapping hm = context.getBean(HANDLER_MAPPING_BEAN_NAME, 
					HandlerMapping.class);
			
			// 构造单个Bean集合
			this.handlerMappings = Collections.singletonList(hm);
		} catch (NoSuchBeanDefinitionException ex) {
			// 忽略已成,后面讲根据引用是否为空判断是否查找成功
		}
	}
	
	if (this.handlerMappings == null) {
		// 如果仍然没有查找到注册的处理器映射器的实现,则使用默认的配置加载处理器映射器
		this.handlerMappings = getDefaultStrategies(context, HandlerMapping.class);
		if (logger.isDebugEnabled()) {
			logger.debug("No HandlerMappings found in servlet '" + getServletName() + 
					"': using default");
		}
	}
}
