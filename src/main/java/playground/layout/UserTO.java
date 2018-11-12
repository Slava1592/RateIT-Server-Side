package playground.layout;

import playground.logic.Constants;
import playground.logic.NewUserForm;
import playground.logic.UserEntity;

public class UserTO implements Constants {
	private String email;
	private String playground;
	private String userName;
	private String avatar;
	private String role;
	private long points;

	public UserTO() {

	}

	public UserTO(NewUserForm form) {
		this.email = form.getEmail();
		this.playground = PLAYGROUND;
		this.userName = form.getUsername();
		this.avatar = form.getAvatar();
		this.role = form.getRole();
		setStartingPoints();
	}
	
	public UserTO(UserEntity user) {
		this();
		if(user != null ) {
			this.email = user.getEmail();
			this.playground = user.getPlayground();
			this.userName = user.getUserName();
			this.avatar = user.getAvatar();
			this.role = user.getRole();
			this.points = user.getPoints();
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlayground() {
		return playground;
	}

	public void setPlayground(String playground) {
		this.playground = playground;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getPoints() {
		return points;
	}

	public void setStartingPoints() {
		if (this.role == MANAGER) {
			this.points = 0;
		} else if (this.role == REVIEWER) {
			this.points = 100;
		}
	}
	
	public void setPoints(long points) {
		this.points = points;
	}

	public void updatePoints(int amount) {
		this.points += amount;
	}

	public void setParams(UserTO newUser) {
		this.email = newUser.email;
		this.playground = newUser.playground;
		this.userName = newUser.userName;
		this.avatar = newUser.avatar;
		this.role = newUser.role;
		this.points = newUser.points;

	}

	public UserEntity toEntity() throws Exception {
		UserEntity rv = new UserEntity();
		rv.setAvatar(this.avatar);
		rv.setEmail(this.email);
		rv.setPlayground(this.playground);
		rv.setPoints(this.points);
		rv.setRole(this.role);
		
		return rv;
	}

}