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
		// 입력받은 정보들을 받는다.
		String page = null;
		
		if(!id.isEmpty() && !password.isEmpty() && !name.isEmpty() && !gender.isEmpty() && !email.isEmpty()){
			// 각각의 정보들이 저장된 값이 모두 있다면
			Customer customer = new Customer(id,password,name,gender,email);
			request.setAttribute("customer", customer);  
			// customer 을 생성 후 값을 전달
			
			CustomerService service = (CustomerService) CustomerService.getInstance();
			service.addCustomer(customer);
			//CustomerService에 인스턴스를 생성한 후, customer를 추가한다.
		
			page = "/view/registerSuccess.jsp";
			//등록이 완료됐기에 registerSuccess 로 이동
		}
		else
			page = "/view/error.jsp";
		// 그렇지 않은 경우 error로 이동
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}