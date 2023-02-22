package semi.common.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.comment.service.CommentService;
import semi.commentvo.CommentVo;

/**
 * Servlet implementation class UpdateCommentController
 */
@WebServlet("/updateComment")
public class UpdateCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int urlNum = Integer.parseInt(req.getParameter("urlNum"));// 해당 댓글이 달리는 원본 글 
		String commentWriter= req.getParameter("commentWriter"); // 댓글 작성자
		String commentContent= req.getParameter("commentContent"); // 댓글 내용
		
		System.out.println("urlNum:"+ urlNum);
		System.out.println("commentWriter:"+ commentWriter);
		System.out.println("commentContent:"+ commentContent);
		
		CommentVo vo= new CommentVo();
		vo.setCommentFrom(urlNum);
		vo.setCommentWriter(commentWriter);
		vo.setCommentContent(commentContent);
		
		int result= -1;
		
		result = new CommentService().UpdateCommentController(vo);
		
		if(result < 1 ) {
			System.out.println("댓글 작성 실패");
		}else {
			System.out.println("댓글 작성 성공");
		}
		
		resp.sendRedirect(req.getContextPath()+"/content.co?urlNum="+urlNum);
		
	}

}
