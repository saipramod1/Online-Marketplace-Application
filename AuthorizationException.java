
/*
 * User-defined Exception
 * extends RuntimeException
 */
public class AuthorizationException extends RuntimeException {
	private static final long serialVersionUID = 5528415690278423524L;
/*
 * AuthorizationException Constructor
 * @param methodName
 */
	public AuthorizationException(String methodName) {
		super("Invalid Authorization - Access Denined to " + methodName + "() function!");
	}
}