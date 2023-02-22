<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>메인페이지</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/nav/nav.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/board/boardlist.jsp"></jsp:include>
<section style="padding-top: 30px;">
		<c:if test="${not empty lgnss }">
			<div style=" text-align:right; ;padding-right: 192px;">
				<button  type="button" class=" btn btn-primary writeBoard">글쓰기</button>
			</div>
		</c:if>
		
		<ul class="pagination justify-content-center" style="padding-top: 30px">	
			<c:forEach begin="${startPageNum }" end="${endPageNum }" step="1" var="page">
				<c:choose>
					<c:when test="${page == currentPage }">
						<span><b>&nbsp;&nbsp;${page }&nbsp;&nbsp;</b></span>
					</c:when>
					<c:otherwise>
						<span style="text-align:center"><a href="<%=request.getContextPath()%>/?currpage=${page }" style="text-decoration: none; color: black;">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a></span>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
		
		<script>
			$(".writeBoard").on("click", btnWriteBoard);
			function btnWriteBoard (){
				location.href="<%=request.getContextPath()%>"+"/writeboard ";
			};
		</script>

</section>

</body>
</html>