package presenter.operate;

import java.sql.SQLException;

public interface Reception {
	public String[][] getRoomStatus() throws Exception;
	public void checkInRoom() throws Exception;
	public void checkOutRoom() throws SQLException;
}
