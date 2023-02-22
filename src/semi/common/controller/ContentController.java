package semi.common.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.board.VO.BoardVo;
import semi.board.service.BoardService;

/**
 * Servlet implementation class ContentController
 */
@WebServlet("/content.co")
public class ContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int urlNum= 0;
		int result = -1; 

		urlNum= Integer.parseInt(req.getParameter("urlNum")); // 해당 페이지의 글 번호 변수
		System.out.println("ContentController: "+urlNum);
		
		result = new BoardService().plusBoardview(urlNum); // 조회수 추가
		System.out.println("ContentController 조회수 추가: "+result);
		
		String me = new BoardService().getUserInfo(urlNum);// 해당 글의 유저 정보 얻기
		
		BoardVo vo = new BoardService().getContent(urlNum); // 이건 해당 페이지의 글 정보 담기
		System.out.println("ContentController 해당글의 관련 모든 정보 : "+vo);
		
		req.setAttribute("urlNum", urlNum);
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/WEB-INF/view/content.jsp").forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
