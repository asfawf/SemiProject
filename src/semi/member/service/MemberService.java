package semi.member.service;

import java.sql.Connection;

import kh.common.jdbc.JdbcTemplet;
import semi.member.dao.MemberDao;
import semi.member.vo.MemberVo;

public class MemberService {
	
	
	
	public MemberVo login(MemberVo vo) {
		MemberVo result = null;
		Connection conn = JdbcTemplet.getConnection();
		
		result = new MemberDao().login(vo, conn);
		
		JdbcTemplet.close(conn);
		
		return result;
	}

	public int getSign(MemberVo vo) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = JdbcTemplet.getConnection();
		
		result = new MemberDao().getSign(vo, conn);
		
		JdbcTemplet.close(conn);
		return result;
	}

	public int dupchk(String userId) {
		int result = 0 ;
		Connection conn = JdbcTemplet.getConnection();
		
		result =new MemberDao().dupchk(userId, conn);
		
		JdbcTemplet.close(conn);
		
		return result;
	}
}
