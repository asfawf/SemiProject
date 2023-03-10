package semi.comment.service;

import java.sql.Connection;
import java.util.List;

import kh.common.jdbc.JdbcTemplet;
import semi.comment.dao.CommentDao;
import semi.commentvo.CommentVo;

public class CommentService {

	public int UpdateCommentController(CommentVo vo) {
		int result = -1;
		Connection conn = JdbcTemplet.getConnection();
		
		result= new CommentDao().UpdateCommentController(conn, vo);
		JdbcTemplet.close(conn);
		
		return result;
	}

	public int deletecomment(int commentNum) {
		int result = -1;
		Connection conn= JdbcTemplet.getConnection();
		result = new CommentDao().deletecomment(conn, commentNum);
		JdbcTemplet.close(conn);
		
		return result;
	}
	
	public List<CommentVo> getCommentList(int urlNum) {
		List<CommentVo> result = null;
		
		Connection conn= JdbcTemplet.getConnection();
		
		System.out.println("CommentList Before: "+ result);
		
		result= new CommentDao().getCommentList(conn, urlNum);
		
		JdbcTemplet.close(conn);
		
		System.out.println("CommentList After: "+ result);
		
		return result;
	}



}
