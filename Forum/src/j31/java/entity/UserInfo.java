package j31.java.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", nickname="
				+ nickname + ", pwd=" + pwd + "]";
	}
	private int id;
	private String username;
	private String nickname;
	private String pwd;
	public UserInfo() {
		super();
	}
	public UserInfo(int id, String username, String nickname, String pwd) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
