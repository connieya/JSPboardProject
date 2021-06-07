package board.vo;

import java.time.LocalDateTime;

public class User {
	
	private int no;
	private String id;
	private String name;
	private String password;
	private LocalDateTime create_Date;
	private LocalDateTime mod_date;
	
	
	
	
	public User setNo(int no) {
		this.no = no;
		return this;
	}
	public int getNo() {
		return no;
	}
	public String getId() {
		return id;
	}
	public User setId(String id) {
		this.id =id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
	

}
