package model.room;

import java.sql.Timestamp;

public class Manager {
	int employee_id;
	int room_num;
	String id_type;
	String id_num;
	Timestamp check_in_date;
	Timestamp expected_check_out_date;
	Timestamp check_out_date;
	float sum_owing;
	
	public Manager() { }

	/**
	 * @param employee_id
	 * @param room_num
	 * @param id_type
	 * @param id_num
	 * @param check_in_date
	 * @param expected_check_out_date
	 * @param check_out_date
	 * @param sum_owing
	 */
	public Manager(int employee_id, int room_num, String id_type, String id_num, Timestamp check_in_date,
			Timestamp expected_check_out_date, Timestamp check_out_date, float sum_owing) {
		super();
		this.employee_id = employee_id;
		this.room_num = room_num;
		this.id_type = id_type;
		this.id_num = id_num;
		this.check_in_date = check_in_date;
		this.expected_check_out_date = expected_check_out_date;
		this.check_out_date = check_out_date;
		this.sum_owing = sum_owing;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getRoom_num() {
		return room_num;
	}

	public void setRoom_num(int room_num) {
		this.room_num = room_num;
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

	public Timestamp getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(Timestamp check_in_date) {
		this.check_in_date = check_in_date;
	}

	public Timestamp getExpected_check_out_date() {
		return expected_check_out_date;
	}

	public void setExpected_check_out_date(Timestamp expected_check_out_date) {
		this.expected_check_out_date = expected_check_out_date;
	}

	public Timestamp getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(Timestamp check_out_date) {
		this.check_out_date = check_out_date;
	}

	public float getSum_owin() {
		return sum_owing;
	}

	public void setSum_owin(float sum_owing) {
		this.sum_owing = sum_owing;
	}

}
