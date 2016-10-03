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
 * Servlet implementation class DoRegister
 */
@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		// �Է¹��� �������� �޴´�.
		String page = null;
		
		if(!id.isEmpty() && !password.isEmpty() && !name.isEmpty() && !gender.isEmpty() && !email.isEmpty()){
			// ������ �������� ����� ���� ��� �ִٸ�
			Customer customer = new Customer(id,password,name,gender,email);
			request.setAttribute("customer", customer);  
			// customer �� ���� �� ���� ����
			
			CustomerService service = (CustomerService) CustomerService.getInstance();
			service.addCustomer(customer);
			//CustomerService�� �ν��Ͻ��� ������ ��, customer�� �߰��Ѵ�.
		
			page = "/view/registerSuccess.jsp";
			//����� �Ϸ�Ʊ⿡ registerSuccess �� �̵�
		}
		else
			page = "/view/error.jsp";
		// �׷��� ���� ��� error�� �̵�
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}