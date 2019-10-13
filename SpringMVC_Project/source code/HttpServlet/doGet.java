protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException
{
	// 获取请求头中的HTTP版本
	String protocol = req.getProtocol();
	
	// 直接发送错误信息,因为这个方法是占位符,需要子类重写模板方法
	String msg = lStrings.getString("http.method_get_not_supported");
	if (protocol.endsWith("1.1")) {
		// 如果HTTP版本是1.1,则让HTTP回应发送错误信息SC_METHOD_NOT_ALLOWED
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, msg);
	} else {
		resp.sendError(HttpServletResponse.SC_BAD_REQUEST, msg);
	}
}
