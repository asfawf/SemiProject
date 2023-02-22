package semi.board.service;

import java.sql.Connection;
import java.util.List;

import kh.common.jdbc.JdbcTemplet;
import semi.board.VO.BoardVo;
import semi.board.dao.BoardDao;

public class BoardService {


	public int deleteList(int urlNum) {
		int result = -1;
		Connection conn= JdbcTemplet.getConnection();
		
		result = new BoardDao().deleteList(conn, urlNum);
		JdbcTemplet.close(conn);
		
		return result;
	}

	
	public int updateContent(BoardVo vo) {
		int result = -1;
		Connection conn = JdbcTemplet.getConnection();
		result= new BoardDao().updateContent(conn, vo);
		
		JdbcTemplet.close(conn);
		
		return result;
	}
	
	public String getUserInfo(int urlNum) {
		String result= null;
		Connection conn= JdbcTemplet.getConnection();
		
		result = new BoardDao().getUserInfo(conn, urlNum);
		
		JdbcTemplet.close(conn);
		System.out.println("해당글의 작성자: "+ result);
		return result ;
	}
	
	public int plusBoardview(int urlNum) {
		int result = -1;
		Connection conn = JdbcTemplet.getConnection();
		
		result= new BoardDao().plusBoardview(conn, urlNum); 
		
		if(urlNum < 1) {
			System.out.println("조회수 추가 실패");
		}else {
			System.out.println("조회수 추가 성공");
		}
		
		JdbcTemplet.close(conn);
		
		return result;
		
	}
	
	public BoardVo getContent(int urlNum) {
		BoardVo vo = null;
		Connection conn = JdbcTemplet.getConnection();
		
		vo= new BoardDao().getContent(conn, urlNum);
		JdbcTemplet.close(conn);
		System.out.println("VO From BoardService: "+ vo);
		
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
