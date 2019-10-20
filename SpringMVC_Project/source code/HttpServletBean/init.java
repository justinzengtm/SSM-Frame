@Override
public final void init() throws ServletException {
	if (logger.isDebugEnabled()) {
		// 从Servlet配置中获取名字,这个Servlet配置来自GenericServlet
		Logger.debug("Initializing servlet '" + getServletName() + "'");
	}
		
	// 设置Servlet的初始化参数作为Servlet Bean的属性
	try {
		// PropertyValues是一个容器类,存放从web.xml配置文件中配置的参数
		PropertyValues pvs = new ServletConfigPropertyValues(getServletConfig(), 
				this.requiredProperties);
		
		// 把当前的Servlet作为一个Bean,把Bean的属性和属性的存取方法信息放入BeanWrapper中
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(this);
		
		// 注册一个可以在资源和路径之间进行转化的用户化编辑器,这些资源是这个Web应用的内部资源,例如一个文件或图片等
		ResourceLoader resourceLoader = new ServletContextResourceLoader(getServletContext());
		bw.registerCustomEditor(Resource.class, new ResourceEditor(resourceLoader));
		
		// 提供一个模板方法initServletBean(),供子类去实现更多的初始化
		initBeanWrapper(bw);
		
		// 把初始化指定的参数都赋值到Serlvet的属性中,第二个参数true表示忽略位置属性
		bw.setPropertyValues(pvs, true);
	} catch (BeansException ex) {
		logger.error("Failed to set bean properties on servlet '" + getServletName() + 
				"'", ex);
	}
	
	// 提供一个模板方法initServletBean(),供子类去初始化其他资源
	initServletBean();
	
	if (logger.isDebugEnabled()) {
		logger.debug("Servlet '" + getServletName() + "' configured successfully");
	}
}
