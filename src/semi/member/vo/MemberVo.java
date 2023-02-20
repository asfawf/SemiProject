package semi.member.vo;

public class MemberVo {

	/***
	 *  userId varchar(20),
    	userPasswd varchar(20),
    	userName varchar(20),
    	userGender varchar(20),
    	userEmail varchar(20),
	 */
	
	private String userId;
	private String userPasswd;
	private String userName;
	private String userGender;
	private String userEmail;
	private int userNo;
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "MemberVo [userId=" + userId + ", userPasswd=" + userPasswd + ", userName=" + userName + ", userGender="
				+ userGender + ", userEmail=" + userEmail + ", userNo=" + userNo + "]";
	}
	
	
	
}
