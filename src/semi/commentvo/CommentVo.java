package semi.commentvo;

import java.sql.Date;

public class CommentVo {
	/**
	 *  commentNum number not null,
	    commentFrom number,
	    commentWriter varchar2(20),
	    boardContent varchar2(2000),
	    boardDate Date default SYSDATE,
	    primary key(commentNum)
	 */
	
	private int commentNum;
	private int commentFrom;
	private String commentWriter;
	private String commentContent;
	private Date commentDate;
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getCommentFrom() {
		return commentFrom;
	}
	public void setCommentFrom(int commentFrom) {
		this.commentFrom = commentFrom;
	}
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	@Override
	public String toString() {
		return "CommentVo [commentNum=" + commentNum + ", commentFrom=" + commentFrom + ", commentWriter="
				+ commentWriter + ", commentContent=" + commentContent + ", commentDate=" + commentDate + "]";
	}
	
	
	
	
}
