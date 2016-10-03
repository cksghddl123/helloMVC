package service;

import java.util.HashMap;

import java.util.Map;

import model.Customer;

public class CustomerService {
	
	private Map<String, Customer> customers;
	
	private static final CustomerService instance = new CustomerService();
	
	private CustomerService(){
		customers = new HashMap<String, Customer>();
	}
	
	public static CustomerService getInstance() {
		return instance;
	}
	
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}
	
	public Customer findCustomer(String id){
		if(id != null)
			return (customers.get(id.toLowerCase()));
		else
			return null;
	}
	
	public Customer login(String id, String password){
		Customer customer= findCustomer(id);
		if(customer.getPassword().equals(password))
			return customer;
		else return null;
	}//login 함수로, 가져온 id와  password를 먼저 id와 찾는 find함수 실행
	 // 존재하는 customer의 pw와 입력받은 pw를 대조
	 // 일치 시에 customer를 리턴, 아닐 시에 null을 리턴

}
