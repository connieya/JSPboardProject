package board.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class BoardDto {
	
	private int no;
	private String name;
	private String title;
	private String content;
	private Timestamp date;
	private int readCount;
	private String password;
	
	public BoardDto(String name, String title, String content, Timestamp date, int readCount) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
		this.readCount = readCount;
	}
	
	
	
	public BoardDto(String name, String title, String content, String password) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
		this.password = password;
	}



	public BoardDto() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
