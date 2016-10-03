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
@WebServlet("/doLogin") // url�� doLogin�̴�.
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
		// Post����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// �Է°����� ����.
		String page = null;

		CustomerService service = (CustomerService) CustomerService.getInstance();

		/*
		 * Customer customerId = service.findCustomer(id); if(customerId ==
		 * null) page = "/view/loginFail.jsp";
		 * 
		 * ID�� �������� ��Ȳ�� ����غ��Ҵµ� �� ���� �ʾҽ��ϴ�. �˷��ֽø� �����ϰڽ��ϴ�.
		 */

		Customer customer = service.login(id, password);
		// login �Լ� ��� �Ͽ� �Էµ� ȸ���� �ִ��� Ȯ��

		if (customer == null) {
			page = "/view/loginFail.jsp";
			request.setAttribute("id", id);
		} // ���ٸ� login ����
		else {
			page = "/view/loginSuccess.jsp";
			request.setAttribute("customer", customer);
		} // �ִٸ� login ����
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
