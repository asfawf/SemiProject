package semi.common.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.board.VO.BoardVo;
import semi.board.service.BoardService;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int urlNum= Integer.parseInt(req.getParameter("urlNum"));
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		BoardVo vo= new BoardVo();
		vo.setBoardSubject(subject);
		vo.setBoardContent(content);
		vo.setBoardNum(urlNum);
		vo.setBoardWriter(writer);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/view/update.jsp").forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int urlNum= Integer.parseInt(req.getParameter("urlNum"));
		String updatedsubject = req.getParameter("updatedsubject");
		String updatedcontent = req.getParameter("updatedcontent");

		System.out.println("urlNum: "+ urlNum);
		System.out.println("updatedsubject: "+ updatedsubject);
		System.out.println("updatedcontent: "+ updatedcontent);
		
		int result = -1;
		
		BoardVo vo = new BoardVo();
		vo.setBoardContent(updatedcontent);
		vo.setBoardSubject(updatedsubject);
		vo.setBoardNum(urlNum);
		
		result = new BoardService().updateContent(vo);
		
		if(result < 1) {
			System.out.println("수정 실패");
		}else {
			System.out.println("수정 성공");
			resp.sendRedirect(req.getContextPath()+"/content.co?urlNum="+urlNum);
		}
		
		//result = new BoardService().updateContent(vo);
		
		//if()
	}

}
