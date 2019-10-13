public void init(Servlet config) throws ServletException{
	//保存Servlet的配置信息
	this.config = config;
	
	//另一个无参数的init（）方法，该方法是GenericServlet类中的一个抽象方法，
	//提供给子类重写，实现初始化。
	this.init();
}
