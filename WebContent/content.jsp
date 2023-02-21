<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<%@ page import="semi.board.service.BoardService" %>
<%@ page import="semi.board.dao.BoardDao"%>
<%@ page import="kh.common.jdbc.JdbcTemplet" %>
<%@ page import="semi.board.VO.BoardVo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<title>Insert title here</title>
</head>
<body>

	<% 
		int urlNum= 0;
		urlNum= Integer.parseInt(request.getParameter("urlNum"));
		PrintWriter script= response.getWriter();
		script.println("urlNum: "+urlNum);	 
		BoardVo vo = new BoardService().getContent(urlNum);
		
		//https://www.youtube.com/watch?v=SC7EP8ID9D8&t=6s 이거 참조
	%>
	
	 <jsp:include page="/WEB-INF/view/nav/nav.jsp"></jsp:include>
	
	<div class="container" style="padding-top: 50px ">
		<div class="row">
			<form action="writeboard" method="post" >
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="글 제목" name="boardSubject" maxlength="50"></td>
							<td><input type="hidden" class="form-control" placeholder="작성자" name="boardWriter" maxlength="50" value="${lgnss.userId }"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용" name="boardContent" maxlength="2048" style="height: 350px;"></textarea></td>
							
						</tr>
					</tbody>
				</table>
				<!-- 글쓰기 버튼 생성 -->
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
			</form>
		</div>
	</div>
</body>
</html>