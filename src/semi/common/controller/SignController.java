package semi.common.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.member.service.MemberService;
import semi.member.vo.MemberVo;

/**
 * Servlet implementation class Sign
 */
@WebServlet("/sign")
public class SignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/view/sign/sign.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userPasswd = req.getParameter("userPasswd");
		String userName = req.getParameter("userName");
		String userGender = req.getParameter("userGender");
		String userEmail = req.getParameter("userEmail");
		
		MemberVo vo = new MemberVo();
		int result = -1;
		
		vo.setUserId(userId);
		vo.setUserPasswd(userPasswd);
		vo.setUserName(userName);
		vo.setUserGender(userGender);
		vo.setUserEmail(userEmail);
		
		System.out.println(userId);
		System.out.println(vo);
		
		result = new MemberService().getSign(vo);
		
		if(result < 1 ) {
			System.out.println("회원가입 실패");
			resp.sendRedirect(req.getContextPath()+ "/sign");
		}else {
			System.out.println("회원가입 성공");
			resp.sendRedirect(req.getContextPath());
		}
		
	}

}
