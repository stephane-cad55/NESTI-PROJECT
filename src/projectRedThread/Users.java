package projectRedThread;

/**
 * @author Stephane Cadeck
 */

public class Users {

	private String userName;
	private String userFirstName;
	private String userCity;
	private String userMail;
	private String userPseudo;
	private String userPassword;

	/**
	 * @constructor
	 */
	public Users() {

		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userCity = userCity;
		this.userMail = userMail;
		this.userPseudo = userPseudo;
		this.userPassword = userPassword;
	}

	/**
	 * @getters and setters
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPseudo() {
		return userPseudo;
	}

	public void setUserPseudo(String userPseudo) {
		this.userPseudo = userPseudo;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", userFirstName=" + userFirstName + ", userCity=" + userCity
				+ ", userMail=" + userMail + ", userPseudo=" + userPseudo + ", userPassword=" + userPassword + "]";
	}
}