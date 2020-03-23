package model.room;

import java.sql.Timestamp;

public class Reservation {
	int id;
	int employee_id;
	int room_num;
	String id_type;
	String id_num;
	Timestamp check_in_date;
	Timestamp expected_check_out_date;
	String status;
	
	public Reservation() { }
	
	/**
	 * @param id
	 * @param employee_id
	 * @param room_num
	 * @param id_type
	 * @param id_num
	 * @param check_in_date
	 * @param expected_check_out_date
	 * @param status
	 */
	public Reservation(int id, int employee_id, int room_num, String id_type, String id_num, Timestamp check_in_date,
			Timestamp expected_check_out_date, String status) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.room_num = room_num;
		this.id_type = id_type;
		this.id_num = id_num;
		this.check_in_date = check_in_date;
		this.expected_check_out_date = expected_check_out_date;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
