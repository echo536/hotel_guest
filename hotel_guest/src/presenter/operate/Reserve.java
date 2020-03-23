package presenter.operate;

import java.sql.SQLException;

public interface Reserve {
	public void removeReservation() throws SQLException;
	public void reserveCheckingIn() throws SQLException;
	public void reserveRoom() throws SQLException;
}
