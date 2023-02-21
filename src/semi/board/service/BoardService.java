package semi.board.service;

import java.sql.Connection;
import java.util.List;

import kh.common.jdbc.JdbcTemplet;
import semi.board.VO.BoardVo;
import semi.board.dao.BoardDao;

public class BoardService {
	
	public BoardVo getContent(int urlNum) {
		BoardVo vo = null;
		Connection conn = JdbcTemplet.getConnection();
		
		vo= new BoardDao().getContent(conn, urlNum);
		
		return vo;
	}
	
	public List<BoardVo> getBoardList(){
		List<BoardVo> result = null;
		Connection conn = JdbcTemplet.getConnection();
		result = new BoardDao().getBoardList(conn);
		JdbcTemplet.close(conn);
		
		return result;
	}
	
	public List<BoardVo> getBoardList(int startRnum , int endRnum){
		List<BoardVo> result = null;
		Connection conn = JdbcTemplet.getConnection();
		result = new BoardDao().getBoardList(conn, startRnum, endRnum);
		JdbcTemplet.close(conn);
		return result;
	}

	public int getCountBoard() {
		int result = 0;
		Connection conn = JdbcTemplet.getConnection();
		result = new BoardDao().getCountBoard(conn);
		JdbcTemplet.close(conn);
		
		return result;
	}

	public int writeContext(BoardVo vo) {
		int result = -1;
		Connection conn= JdbcTemplet.getConnection();
		
		result = new BoardDao().writeContext(conn, vo);
		
		JdbcTemplet.close(conn);
		
		return result;
	}
}
