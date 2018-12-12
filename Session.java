import java.io.Serializable;

public class Session implements Serializable {
	private static final long serialVersionUID = -6745473220581903527L;
	//Instance for User class.
	private User user;
	/*
	 * Constructor Session
	 * @param userType
	 */
	public Session(String userType) {
		user = new User(userType);
	}
	public User getUser() {
		return user;
	}
}