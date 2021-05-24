package board.vo;

public class User {
	
	private String id;
	private String name;
	private String password;
	
	
	
	public User() {
		super();
	}
	public User(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public User setId(String id) {
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		return this;
	}
	public String getName() {
		return name;
	}
	public User setName(String name) {
		return this;
	}
	
	
	
	

}
