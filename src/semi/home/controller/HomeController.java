package semi.home.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.board.service.BoardService;

/**getBoardList
 * Servlet implementation class HomeController
 */
@WebServlet({"/","/index"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String currpage = req.getParameter("currpage");
		
		// 1. 전체 글 개수
		int cnt = 0;
		cnt = new BoardService().getCountBoard();
		System.out.println("게시글의 총 개수: "+cnt);
		
		// 2. 한 페이지당 나타낼 글 개수
		int pageSize= 4;
		
		// 3. 페이지 수 정하기
		int pageBlock= 3;
		
		// 4. 현재 페이지
		int currentPage= 1;
		
		try {
			currentPage = Integer.parseInt(currpage);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// 5. row num
		int startRnum= 0;
		int endRnum= 0;
		startRnum= ((currentPage -1)* pageSize)+ 1;
		endRnum= (startRnum + pageSize > cnt) ? cnt : startRnum + pageSize -1 ;
		
		System.out.println("starRnum: "+ startRnum);
		System.out.println("endRnum: "+ endRnum);
		req.setAttribute("boardlist", new BoardService().getBoardList(startRnum, endRnum));
		
		// 범위 정하기
		int startPageNum= 0;
		int endPageNum= 0;
		
		startPageNum=(currentPage % pageBlock == 0) ? ((currentPage/ pageBlock -1)* pageBlock +1) : ((currentPage/ pageBlock)* pageBlock +1) ;
		int pageCnt= (cnt/ pageSize)+ (cnt % pageSize == 0 ? 0: 1);
		endPageNum= (startPageNum + pageBlock -1 > pageCnt) ? pageCnt : startPageNum + pageBlock -1 ;
		
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageCnt", pageCnt);
		
		//req.setAttribute("boardlist", new BoardService().getBoardList());
		System.out.println("DB 갔다오기 From HOmeController");
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
