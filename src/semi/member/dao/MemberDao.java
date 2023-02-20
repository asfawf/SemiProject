package semi.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.common.jdbc.JdbcTemplet;
import semi.member.vo.MemberVo;

public class MemberDao {
	public MemberVo login(MemberVo vo ,Connection conn) {
		MemberVo result= null;
		PreparedStatement pstmt = null;
		String sql= "SELECT userId, userPasswd, userName, userEmail, userNo from semi_User where userId=? and userPasswd=?";
		
		ResultSet rs= null;
		
		System.out.println("DAO: "+ vo);
		System.out.println("DAO(voId): "+ vo.getUserId());
		System.out.println("DAO(voPw): "+ vo.getUserPasswd());
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPasswd());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("Rest.next()");
				result= new MemberVo();
				result.setUserId(rs.getString("userId"));
				result.setUserPasswd(rs.getString("userPasswd"));
				result.setUserEmail(rs.getString("userEmail"));
				result.setUserName(rs.getString("userName"));
				result.setUserNo(rs.getInt("userNo"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTemplet.close(pstmt);
			JdbcTemplet.close(rs);
		}
		
		System.out.println("DAO(Result): "+ result);
		return result;
	}

	public int getSign(MemberVo vo, Connection conn) {
		String sql= "insert into SEMI_USER(userId, userPasswd, userName, userGender, userEmail) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		int result = -1;
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPasswd());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getUserGender());
			pstmt.setString(5, vo.getUserEmail());
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcTemplet.close(pstmt);
			
		}
		
		System.out.println("DAO(result): "+ result);
		
		return result;
	}

	public int dupchk(String userId, Connection conn) {
		int result = -1;
		PreparedStatement pstmt= null;
		String sql="select count(*) cnt from SEMI_USER where userId = ?";
		ResultSet rs = null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("rs.next()");
				result= rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcTemplet.close(pstmt);
			JdbcTemplet.close(rs);
		}
		
		System.out.println("DAO(result): "+ result);
		
		return result;
	}
}
