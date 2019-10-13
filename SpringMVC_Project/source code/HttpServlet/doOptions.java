protected void doOptions(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException
{
	// 获取当前Servlet和它的父类Servlet声明的所有方法,不包括本类HttpServlet声明的方法
	Method[] methods = getAllDeclareMethods(this.getClass());
	
	// 初始化状态,除了OPTIONS和TRACE方法（HttpServlet为其提供了具体实现）,假设其他HTTP方法都不支持
	boolean ALLOW_GET = false;
	boolean ALLOW_PUT = false;
	boolean ALLOW_POST = false;
	boolean ALLOW_DELETE = false;
	boolean ALLOW_HEAD = false;
	boolean ALLOW_OPTIONS = true;
	boolean ALLOW_TRACE = true;
	
	// 根据子类Servlet是否重写了HttpServlet的模板方法,判断这个Servlet是否支持这个HTTP方法
	for (int i=0; i<methods.length; i++) {
		// 遍历得到所有声明的方法
		Method m = methods[i];
		
		if (m.getName().equals("doGet")) {
			ALLOW_GET = true;
			ALLOW_HEAD = true;
		}
		if (m.getName().equals("doPut"))
			ALLOW_PUT = true;
		if (m.getName().equals("doPost"))
			ALLOW_POST = true;
		if (m.getName().equals("doDelete"))
			ALLOW_DELETE = true;
		
	}
	
	//把Servlet支持的HTTP方法名拼接成字符串
	String allow = null;
	if (ALLOW_GET)
		if (allow == null) allow = METHOD_GET;
	if (ALLOW_PUT)
		if (allow == null) allow = METHOD_PUT;
		else allow += ", " + METHOD_PUT;
	if (ALLOW_POST)
		if (allow == null) allow = METHOD_POST;
		else allow += ", " + METHOD_POST;
	if (ALLOW_DELETE)
		if (allow == null) allow = METHOD_DELETE;
		else allow += ", " + METHOD_DELETE;
	if (ALLOW_HEAD)
		if (allow == null) allow = METHOD_HEAD;
		else allow += ", " + METHOD_HEAD;
	if (ALLOW_TRACE)
		if (allow == null) allow = METHOD_TRACE;
		else allow += ", " + METHOD_TRACE;
	if (ALLOW_OPTIONS)
		if (allow == null) allow = METHOD_OPTIONS;
		else allow += ", " + METHOD_OPTIONS;
	
	// 将字符串设置到HTTP响应头中
	resp.setHeader("Allow", allow);
}

protected void doTrace(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException
{
	// 保存字符串的字节长度
	int responseLength;
	
	// 连接URI和版本信息字符串
	String CRLF = "\r\n";
	String responseString = "TRACE " + req.getRequestURI + 
			" " + req.getProtocol();
	
	// 枚举(一次获得一个)对象集合中的元素
	Enumeration reqHeaderEnum = req.getHeaderNames();
	// 遍历所有的请求头信息
	while (reqHeaderEnum.hasMoreElements()) {
		String headerName = (String)reqHeaderEnum.nextElement();
		
		// 将所有请求头拼接到字符串中,请求头信息之间使用回车换行分隔
		responseString += CRLF + headerName + ":" + req.getHeader(headerName);
		
		// 回车换行
		responseString += CRLF;
		
		// 获取字符串的字节长度
		responseLength = responseString.length();
		
		// 设置响应类型为message/http
		resp.setContentType("message/http");
		
		// 设置响应体的长度
		resp.setContentLength(responseLength);
		
		// 输出字符串信息到响应中
		ServletOutputStream out = resp.getOutputStream();
		out.print(responseString);
		
		// 关闭响应
		out.close();
		return;
	}
}
