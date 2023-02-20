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
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/log/login.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId= req.getParameter("userId");
		String userPasswd= req.getParameter("userPasswd");
		System.out.println(userId + " " + userPasswd );
		
		MemberVo vo = new MemberVo();
		vo.setUserId(req.getParameter("userId"));
		vo.setUserPasswd(req.getParameter("userPasswd"));
		
		MemberVo result = new MemberService().login(vo);
		
		if(result == null) {
			System.out.println("로그인 실패");
		}else {
			System.out.println("로그인 성공");
			req.getSession().setAttribute("lgnss", result);
			System.out.println("lgnss 생성");
		}
		
		resp.sendRedirect(req.getContextPath());
	}
	

}
