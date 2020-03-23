package model.user;

public class User {
	private int employee_id;
	private String name;
	private String sex;
	private String occupation;
	private String phone;
	
	public User() { }

	/**
	 * @param employee_id
	 * @param name
	 * @param sex
	 * @param occupation
	 * @param phone
	 */
	public User(int employee_id, String name, String sex, String occupation, String phone) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.sex = sex;
		this.occupation = occupation;
		this.phone = phone;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
