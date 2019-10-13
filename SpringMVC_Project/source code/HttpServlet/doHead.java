protected void doHead(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException
{
	if (DispatcherType.INCLUDE.equals(req.getDispatcherType())) {
		doGet(req, resp);
	} else {
		NoBodyResponse response = new NoBodyResponse(resp);
		
		// 重用doGet（）方法
		doGet(req, response);
		
		// 设置响应体字节大小
		response.setContentLength();
	}
}
