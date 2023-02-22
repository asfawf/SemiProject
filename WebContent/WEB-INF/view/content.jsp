<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<%@ page import="semi.board.service.BoardService" %>
<%@ page import="semi.board.dao.BoardDao"%>
<%@ page import="kh.common.jdbc.JdbcTemplet" %>
<%@ page import="semi.board.VO.BoardVo" %>
<%@ page import="semi.commentvo.CommentVo" %>
<%@ page import="semi.member.vo.MemberVo" %>
<%@ page import="semi.member.dao.MemberDao" %>
<%@ page import="semi.member.service.MemberService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<title>본문 보기 담당</title>
</head>
<body>
		쓸 거면 이렇게 출력해라 :${comments[0].commentNum}
		
	<jsp:include page="/WEB-INF/view/nav/nav.jsp"></jsp:include>
	<div class="container" style="padding-top: 60px">
		<div class="row">
			<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">${vo.boardSubject} </th>
				      <th scope="col"></th>
				      <th scope="col"></th>
				      <th scope="col"  style="text-align: right;"><c:if test="${lgnss.userId eq  vo.boardWriter}"><button class="btnDelete btn btn-danger" type="button">삭제하기</button><button type="button" class="btnUpdate btn btn-primary" style="margin-left:3px;">수정하기</button></c:if><button type="button" class="gotolist btn btn-secondary" style="margin-left:3px;">목록으로</button></th>
				    </tr>
				  </thead>
				  <tbody class="table-group-divider">
				    <tr>
				      <th scope="row">${vo.boardWriter }</th>
				      <td></td>
				      <td></td>
				      <td style="text-align: right;">작성일자: ${vo.boardDate } 조회수: ${vo.boardView }</td>
				    </tr>
				    <tr>
				      <th scope="row" style="height: 500px; text-align: left;">${vo.boardContent }</th>
				      
				    </tr>
				  </tbody>
			</table>

		</div>
	</div>
	
	<table style="margin-left:auto;margin-right:auto; border: solid; border-collapse: collapse; width: 80%; ">
		<c:forEach items="${comments }" var="comments">
			<tr style=" border: none; padding: 10px;  text-align:center"> 
				<td style=" border: 1px solid #444444; padding: 10px; text-align: left"><span> ${comments.commentNum} / ${comments.commentWriter} / ${comments.commentContent} / ${comments.commentDate}  <c:if test="${lgnss.userId eq comments.commentWriter }"> / <a href="deletecomment?commentNum=${comments.commentNum }&boardNum=${vo.boardNum}">삭제하기</a> </c:if> </span> </td>
			</tr>
		</c:forEach>
	</table>
	
	
	<script>
	
		$(".gotolist").on("click", gotoClicklist);
		function gotoClicklist(){
			location.href="<%=request.getContextPath()%>";
		}
		$(".btnDelete").on("click", btnClickDelete);
		function btnClickDelete(){
			location.href="<%=request.getContextPath()%>"+"/boarddelete?urlNum=${vo.boardNum}";
		}
		$(".btnUpdate").on("click", btnClickUpdate);
		function btnClickUpdate(){
			location.href="<%=request.getContextPath()%>"+"/update?urlNum=${vo.boardNum}&subject=${vo.boardSubject}&content=${vo.boardContent}&writer=${vo.boardWriter }";
			
		}
	
	</script>
	
	
</body>
</html>