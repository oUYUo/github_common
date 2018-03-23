package beans;

public class Users {
	public Users(){};
	private int UserId;
	private String UserName;
	private int UserAge;
	private String UserSex;
	private String UserLocation;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getUserAge() {
		return UserAge;
	}
	public void setUserAge(int userAge) {
		UserAge = userAge;
	}
	public String getUserSex() {
		return UserSex;
	}
	public void setUserSex(String userSex) {
		UserSex = userSex;
	}
	public String getUserLocation() {
		return UserLocation;
	}
	public void setUserLocation(String userLocation) {
		UserLocation = userLocation;
	}

}
