package board.dto;

import java.sql.Date;

public class BoardDto {
	
	private String name;
	private String title;
	private String content;
	private Date date;
	private int readCount;
	
	public BoardDto(String name, String title, String content, Date date, int readCount) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
		this.readCount = readCount;
	}
	
	

}
