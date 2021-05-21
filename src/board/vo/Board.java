package board.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Board {
	
	private int no;
	private String name;
	private String title;
	private String content;
	private Timestamp date;
	private int readCount;
	private String password;
	
	public Board(String name, String title, String content, Timestamp date, int readCount) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
		this.readCount = readCount;
	}
	
	
	
	public Board(String name, String title, String content, String password) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
		this.password = password;
	}



	public Board() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public Board setNo(int no) {
		return this;
	}

	public String getName() {
		return name;
	}

	public Board setName(String name) {
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Board setTitle(String title) {
		return this;
	}

	public String getContent() {
		return content;
	}

	public Board setContent(String content) {
		return this;
	}

	public Timestamp getDate() {
		return date;
	}

	public Board setDate(Timestamp date) {
		return this;
	}

	public int getReadCount() {
		return readCount;
	}

	public Board setReadCount(int readCount) {
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Board setPassword(String password) {
		return this;
	}

	
	

}
