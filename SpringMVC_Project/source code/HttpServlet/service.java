protected void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		// 从HTTP请求中获取请求方法
		String method = req.getMethod();
		
		if (method.equals(METHOD_GET)) {
			// 如果请求的是GET方法,先获取这个Servlet的最后修改时间
			long lastModified = getLastModified(req);
			
			if (lastModified == -1) {
				// -1表示Servlet不支持修改最后的修改时间,则直接调用doGet()方法处理这个HTTP请求
				doGet(req, resp);
			} else {
				// 如果支持修改最后的修改时间,则修改为HTTP请求头中的最后修改时间
				// 先获取HTTP请求头中的最后修改时间
				long ifModifiedSince = req.getDateHeader(HEADER_IFMODSINCE);
				
				if (ifModifiedSince < (lastModified /1000 * 1000)) {
					// 如果HTTP请求头中的修改时间早于Servlet的修改时间,表明这个Servlet在用户进行
					// 上一次HTTP请求时已被修改,则将最新的修改时间放到响应头中
					maybeSetLastModified(resp, lastModified);
					
					// 调用doGet()方法处理HTTP请求
					doGet(req, resp);
				} else {
					// 如果HTTP请求头中的修改时间晚于Servlet的修改时间,表明这个Servlet在请求的最后
					// 修改时间后都没有被修改,则返回一个HTTP响应SC_NOT_MODIFIED
					resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
				}
			}
		} else if (method.equals(METHOD_HEAD)) {
			// 如果请求的时HEAD方法
			// HEAD方法无论HTTP请求头中的修改时间是早于还是晚于Servlet的最后修改时间,都会将Servlet的
			// 最后修改时间修改到响应头中(如果这个Servlet支持最后修改时间的修改操作)
			
			long lastModified = getLastModified(req);
			maybeSetLastModified(resp, lastModified);
			
			doHead(req, resp);
		} else if (method.equals(METHOD_POST)) {
			// 请求使用POST方法
			doPost(req, resp);
		} else if (method.equals(METHOD_PUT)) {
			// 请求使用PUT方法
			doPut(req, resp);
		} else if (method.equals(METHOD_DELETE)) {
			// 请求使用DELETE方法
			doDelete(req, resp);
		} else if (method.equals(METHOD_OPTIONS)) {
			// 请求使用OPTIONS方法
			doOptions(req, resp);
		} else if (method.equals(METHOD_TRACE)) {
			// 请求使用TRACE方法
			doTrace(req, resp);
		} else {
			// 如果请求使用了未定义方法,则返回错误代码SC_NOT_IMPLEMENTED响应,并且显示错误信息
			String errMsg = Strings.getString("http.method_not_implemented");
			Object[] errArgs = new Object[1];
			errArgs[0] = method;
			errMsg = MessageFormat.format(errMsg, errArgs);
			
			resp.sendError(HttpServletResponse.SC_NOT_TMPLEMENTED, errMsg);
		}
	} 
