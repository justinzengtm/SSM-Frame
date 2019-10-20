private void initMultipartResolver(ApplicationContext context) {
	try {
		// 从配置的Web应用程序环境中查找多部请求解析器
		this.multipartResolver = context.getBean(MULTIPART_RESOLVER_BEAN_NAME, 
				MultipartResolver.class);
		if (logger.isDebugEnabled()) {
			logger.debug("Using MultipartResolver [" + this.multipartResolver + "]");
		}
	} catch (NoSuchBeanDefinitionException ex) {
		// 如果没有查找到多部请求解析器,则忽略它,因为不是所有的应用程序都需要它,多部请求
		// 通常用在文件上传中
		this.multipartResolver = null;
		if (logger.isDebugEnabled()) {
			logger.debug("Unable to locate MultipartResolver with name '" + 
					MULTIPART_RESOLVER_BEAN_NAME + "': no multipart request handling provided");
		}
	}
}
