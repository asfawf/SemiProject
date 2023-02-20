package semi.board.VO;

import java.sql.Date;

public class BoardVo {
	private int boardNum;
	private String boardWriter;
	private String boardSubject;
	private String boardContent;
	private Date boardDate;
	private int boardView;
	
	public int getBoardView() {
		return boardView;
	}
	public void setBoardView(int boardView) {
		this.boardView = boardView;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	@Override
	public String toString() {
		return "BoardVo [boardNum=" + boardNum + ", boardWriter=" + boardWriter + ", boardSubject=" + boardSubject
				+ ", boardContent=" + boardContent + ", boardDate=" + boardDate + ", boardView=" + boardView + "]";
	}
	
	

}
