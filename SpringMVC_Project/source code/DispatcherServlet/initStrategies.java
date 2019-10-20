protected void initStrategies(ApplicationContext context) {
	// 初始化多部(multipart)请求解析器,没有默认的实现
	initMultipartResolver(context);
	
	// 初始化地域解析器,默认的实现是AcceptHeaderLocaleResolver
	initLocaleResolver(context);
	
	// 初始化主题解析器,默认的实现是FixedThemeResolver
	initThemeResolver(context);
	
	// 初始化处理器映射器集合,默认的实现是BeanNameUrlHandlerMapping和
	// DefaultAnnotationHandlerMapping
	initHandlerMappings(context);
	
	// 初始化处理器适配器集合,默认的实现是HttpRequestHandlerAdapter，
	// SimpleControllerHandlerAdapter和AnnotationMethodHandlerAdapter
	initHandlerAdapters(context);
	
	// 初始化处理器异常解析器集合,默认的实现是AnnotationMethodHandlerExceptionResolver、
	// ResponseStatusExceptionResolver和DefaultHandlerExceptionResolver
	initHandlerExceptionResolvers(context);
	
	// 初始化请求视图名解析器,默认的实现是DefaultRequestToViewNameTranslator
	initRequestToViewNameTranslator(context);
	
	// 初始化视图解析器集合,默认的实现是InternalResourceViewResolver
	initViewResolvers(context);
}
