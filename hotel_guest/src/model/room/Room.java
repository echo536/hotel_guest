package model.room;

public class Room {
	private int room_num;
	private String type;
	private float price;
	private float guarantee_deposit;
	private String status;
	
	public Room() {}

	/**
	 * @param room_num
	 * @param type
	 * @param price
	 * @param guarantee_deposit
	 * @param status
	 */
	public Room(int room_num, String type, float price, float guarantee_deposit, String status) {
		super();
		this.room_num = room_num;
		this.type = type;
		this.price = price;
		this.guarantee_deposit = guarantee_deposit;
		this.status = status;
	}

	public int getRoom_num() {
		return room_num;
	}

	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getGuarantee_deposit() {
		return guarantee_deposit;
	}

	public void setGuarantee_deposit(float guarantee_deposit) {
		this.guarantee_deposit = guarantee_deposit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
}
