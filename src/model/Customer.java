package model;

/*
 * 현재 저의 pc에서 pom.xml이 오류가 발생 되어서 lombok을 추가 할 수 없는 상황입니다.
 * 때문에 source에서  생성자와 getter, setter를  직접 생성할 수 밖에 없는 상황이었습니다.
 * 제 pc로 처음엔 이상이 없었는데 지우고 다시 할때부터 문제가 생겼습니다.
 * maven폴더에 문제가 있는 것 같은데 추후에 제 pc의 문제점을  교수님께 여쭤봐도 되겠습니까? 
 * */
public class Customer {
	
	private String id;
	private String password;
	private String name;
	private String gender;
	private String email;
	
	public Customer(String id, String password, String name, String gender, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
