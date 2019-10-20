@Override
public final void initServletBean() throws ServletException {
	// 输出初始化信息到日志中
	getServletContext().log("Initializing Spring FrameworkServlet '" + 
			getServletName() + "'");
	
	if (this.logger.isInfoEnabled()) {
		this.logger.info("FrameworkServlet '" + getServletName() + 
				"': initializationstarted");
	}
	
	// 初始化环境开始时间
	long startTime = System.currentTimeMillis();
	try {
		// 初始化Servlet环境
		this.webApplicationContext = initWebApplicationContext();
		
		// 调用模板方法,供子类实现,初始化指定的资源(例如具体实现在DispatcherServlet中)
		initFrameworkServlet();
	} catch (ServletException ex) {
		this.logger.error("Context initialization failed", ex);
		throws ex;
	} catch (RuntimeException ex) {
		this.logger.error("Context initialization failed", ex);
		throws ex;
	}
	
	if (this.logger.isInfoEnabled()) {
		// 初始化环境用时
		long elapsedTime = System.currentTimeMillis() - startTime;
		// 输出到日志信息中
		this.logger.info("FrameworkServlet '" + getServletName() + 
				"': initializationcomplete in " + elapsedTime + "ms");
	}
	
}
