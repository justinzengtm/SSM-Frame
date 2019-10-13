public void service(ServletRequest req, ServletResponse res)
   throws ServletException, IOException
{
   HttpServletRequest request;
   HttpServletResponse response;
   
   try {
   		request = (HttpServletRequest) req;
		response = (HttpServletResponse) res;
   } catch (ClassCastException e) {
   		throw new ServletException("non-HTTP request or response");
   }
   
   service(request, response);
}
