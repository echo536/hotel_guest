package model.client;

public class Client {
	private String id_type;
	private String id_num;
	private String name;
	private String sex;
	private String phone;
	
	public Client() { }

	/**
	 * @param id_type
	 * @param id_num
	 * @param name
	 * @param sex
	 * @param phone
	 */
	public Client(String id_type, String id_num, String name, String sex, String phone) {
		super();
		this.id_type = id_type;
		this.id_num = id_num;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getId_num() {
		return id_num;
	}

	public void setId_num(String id_num) {
		this.id_num = id_num;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
