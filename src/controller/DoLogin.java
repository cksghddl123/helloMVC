package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin") // url은 doLogin이다.
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Post형식
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 입력값들을 받음.
		String page = null;

		CustomerService service = (CustomerService) CustomerService.getInstance();

		/*
		 * Customer customerId = service.findCustomer(id); if(customerId ==
		 * null) page = "/view/loginFail.jsp";
		 * 
		 * ID가 없을때의 상황도 고려해보았는데 잘 되질 않았습니다. 알려주시면 감사하겠습니다.
		 */

		Customer customer = service.login(id, password);
		// login 함수 사용 하여 입력된 회원이 있는지 확인

		if (customer == null) {
			page = "/view/loginFail.jsp";
			request.setAttribute("id", id);
		} // 없다면 login 실패
		else {
			page = "/view/loginSuccess.jsp";
			request.setAttribute("customer", customer);
		} // 있다면 login 성공
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
