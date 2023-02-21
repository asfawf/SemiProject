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
 * Servlet implementation class WriteController
 */
@WebServlet("/writeboard")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/write/write.jsp").forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/***
		 * 	boardWriter varchar2(20), - 이건 session 으로 처리
    		boardSubject varchar2(255), - 
    		boardContent varchar2(2000),
		 */
		
		String boardWriter= req.getParameter("boardWriter");
		String boardSubject= req.getParameter("boardSubject");
		String boardContent= req.getParameter("boardContent");
		
		BoardVo vo = new BoardVo();
		
		vo.setBoardWriter(boardWriter);
		vo.setBoardContent(boardContent);
		vo.setBoardSubject(boardSubject);
		
		int result = -1;
		
		result = new BoardService().writeContext(vo);
		System.out.println(boardWriter+ " " + boardSubject +" "+ boardContent);
		
		if(result < 1) {
			System.out.println("Insert 실패");
			resp.sendRedirect(req.getContextPath());
		}else {
			System.out.println("Insert 성공");
			resp.sendRedirect(req.getContextPath());
		}
		
		
	}

}
