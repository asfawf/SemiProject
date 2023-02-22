package semi.comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.common.jdbc.JdbcTemplet;
import semi.commentvo.CommentVo;

public class CommentDao {

	public List<CommentVo> getCommentList(Connection conn, int urlNum) {
		List<CommentVo> result = null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		String sql= "select commentNum, commentFrom, commentWriter, commentContent, commentDate from comment_tbl where commentFrom= ?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, urlNum);
			rs= pstmt.executeQuery();
			result= new ArrayList<CommentVo>();
			while(rs.next()) {
				CommentVo vo = new CommentVo();
				vo.setCommentNum(rs.getInt("commentNum"));
				vo.setCommentFrom(rs.getInt("commentFrom"));
				vo.setCommentWriter(rs.getString("commentWriter"));
				vo.setCommentContent(rs.getString("commentContent"));
				vo.setCommentDate(rs.getDate("commentDate"));
				result.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcTemplet.close(pstmt);
			JdbcTemplet.close(rs);
		}
		
		return result;
	}

}
