package semi.common.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.comment.service.CommentService;

/**
 * Servlet implementation class DeleteCommentController
 */
@WebServlet("/deletecomment")
public class DeleteCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int commentNum= Integer.parseInt(req.getParameter("commentNum"));
		int boardNum= Integer.parseInt(req.getParameter("boardNum"));
		System.out.println("commentNum: "+ commentNum);
		System.out.println("boardNum: "+ boardNum);
		int result = -1;
		
		result = new CommentService().deletecomment(commentNum);
		
		if(result < 1) {
			System.out.println("댓글 삭제 실패");
		}else {
			System.out.println("댓글 삭제 성공");
		}
		
		resp.sendRedirect(req.getContextPath()+"/content.co?urlNum="+ boardNum);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
