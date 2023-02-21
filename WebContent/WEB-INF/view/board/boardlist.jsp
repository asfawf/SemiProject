<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<section>
	<h1 style="padding-top:30px ; text-align: center">게시글 목록</h1>
	
	<div class="d-grid gap-2 d-md-flex justify-content-md-end" style=" border-collapse: collapse; width: 60%; padding-bottom:10px; right: 30px">
		
	</div>

	<table style="margin-left:auto;margin-right:auto; border: 1px solid #444444; border-collapse: collapse; width: 80%; ">
		<tr style="border: 1px solid #444444; text-align:center"> 
			<td style="border: 1px solid #444444;">&nbsp;&nbsp;번호&nbsp;&nbsp;</td>
			<td style="border: 1px solid #444444;">&nbsp;&nbsp;작성자&nbsp;&nbsp;</td>
			<td style="border: 1px solid #444444;">&nbsp;&nbsp;제목&nbsp;&nbsp;</td>
			<td style="border: 1px solid #444444;">&nbsp;&nbsp;작성일&nbsp;&nbsp;</td>
			<td style="border: 1px solid #444444;">&nbsp;&nbsp;조회수&nbsp;&nbsp;</td>
		</tr>
		<c:forEach items="${boardlist }" var="vo">
			<tr style=" border: 1px solid #444444; padding: 10px;  text-align:center"> 
				<td style=" border: 1px solid #444444; padding: 10px;"><a href="content.jsp?urlNum=${vo.boardNum }" style="text-decoration: none; color: black;"> ${vo.boardNum } </a></td>
				<td style=" border: 1px solid #444444; padding: 10px;"><a href="urlNum=${vo.boardNum }" style="text-decoration: none; color: black;"> ${vo.boardWriter } </a></td>
				<td style=" border: 1px solid #444444; padding: 10px;"><a href="urlNum=${vo.boardNum }" style="text-decoration: none; color: black;"> ${vo.boardSubject } </a></td>
				<td style=" border: 1px solid #444444; padding: 10px;"><a href="urlNum=${vo.boardNum }" style="text-decoration: none; color: black;"> ${vo.boardDate } </a></td>
				<td style=" border: 1px solid #444444; padding: 10px;"><a href="urlNum=${vo.boardNum }" style="text-decoration: none; color: black;"> ${vo.boardView } </a></td>
			</tr>
		</c:forEach>
	</table>


</section>



