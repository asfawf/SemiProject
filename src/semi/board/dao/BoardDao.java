package semi.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.common.jdbc.JdbcTemplet;
import semi.board.VO.BoardVo;
import semi.member.vo.MemberVo;

public class BoardDao {
	
	// 글 목록에서 누르면 해당 글로 이동시켜주는거
	public BoardVo getContent(Connection conn, int urlNum) {
		PreparedStatement pstmt;
		ResultSet rs= null;
		String sql="select * from BOARDTBL where boardNum = ?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, urlNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				BoardVo vo= new BoardVo();
				vo.setBoardNum(rs.getInt(1));
				vo.setBoardWriter(rs.getString(2));
				vo.setBoardSubject(rs.getString(3));
				vo.setBoardContent(rs.getString(4));
				vo.setBoardDate(rs.getDate(5));
				vo.setBoardView(rs.getInt(6));
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public List<BoardVo> getBoardList(Connection conn){
		List<BoardVo> result = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql="select boardNum, boardWriter, boardSubject, boardContent, boardDate,boardView from BOARDTBL order by boardNum desc";
		
		try {
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			result= new ArrayList<BoardVo>();
			while(rs.next()) {
				BoardVo vo= new BoardVo();
				vo.setBoardNum(rs.getInt("boardNum"));
				vo.setBoardWriter(rs.getString("boardWriter"));
				vo.setBoardContent(rs.getString("boardContent"));
				vo.setBoardSubject(rs.getString("boardSubject"));
				vo.setBoardDate(rs.getDate("boardDate"));
				vo.setBoardView(rs.getInt("boardView"));
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
	
	public List<BoardVo> getBoardList(Connection conn, int startRnum, int endRnum){
		List<BoardVo> result = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql="select * "
				+ "    from (select rownum rn, test1.* "
				+ "        from (select boardNum, boardWriter, boardSubject, boardContent, boardDate,boardView "
				+ "            from BOARDTBL "
				+ "            order by boardNum desc) test1"
				+ "            ) test2"
				+ "            where rn between ? and ? ";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rs= pstmt.executeQuery();
			result= new ArrayList<BoardVo>();
			while(rs.next()) {
				BoardVo vo= new BoardVo();
				vo.setBoardNum(rs.getInt("boardNum"));
				vo.setBoardWriter(rs.getString("boardWriter"));
				vo.setBoardContent(rs.getString("boardContent"));
				vo.setBoardSubject(rs.getString("boardSubject"));
				vo.setBoardDate(rs.getDate("boardDate"));
				vo.setBoardView(rs.getInt("boardView"));
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

	public int getCountBoard(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql= "select count(*) cnt from BOARDTBL";
		int result = 0;
		
		try {
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int writeContext(Connection conn, BoardVo vo) {
		PreparedStatement pstmt= null;
		int result = -1;
		String sql= "Insert Into boardTbl values ((select NVL(MAX(boardNum), 0)+1 from BOARDTBL), ?, ?, ?, default, default )";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBoardWriter());
			pstmt.setString(2, vo.getBoardSubject());
			pstmt.setString(3, vo.getBoardContent());
			
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcTemplet.close(pstmt);
		}
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
