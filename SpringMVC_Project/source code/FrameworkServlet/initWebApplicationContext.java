protected WebApplicationContext initWebApplicationContext() {
	// 首先查找这个Servlet（例如DispatcherServlet）是否配置有专用的根环境
	WebApplicationContext wac = findWebApplicationContext();
	
	// 如果没有,就加载默认的共享根环境
	if (wac == null) {
		// 加载默认的共享根环境,这个根环境通过关键字ROOT_WEB_APPLICATION
		// _CONTEXT_ATTRIBUTE保存在Servlet环境里
		WebApplicationContext parent = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		// 创建Servlet的子环境,并引用已经得到的著环境
		wac = createWebApplicationContext(parent);
	}
	
	// Servlet框架在初始化时为子类提供了初始化模板方法initFrameworkServlet()和onRefresh()
	if (!this.refreshEventReceived) {
		onRefresh(wac);
	}
	
	// 如果设置了发布环境属性,则把这个Web应用程序环境以ServletContextAttributeName的值
	// 作为关键字保存到Servlet环境里，以此来让其他Servlet共享这个Web应用程序环境
	if (this.publishContext) {
		// 将这个环境发布并存储到Servlet Context中
		String attrName = getServletContextAttributeName();
		getServletContext().setAttribute(attrName, wac);
		if (this,logger.isDebugEnabled()) {
			this.logger.debug("Published WebApplicationContext of servlet '" + 
		getServletName() + "' as ServletContext attribute with name [" + attrName + "]");
		}
	}
	
	return wac;
}
