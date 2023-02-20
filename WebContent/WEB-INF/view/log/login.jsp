<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/nav/nav.jsp"></jsp:include>
	
	<div class="container" style="padding-top: 20px;" >
		<div>
			<div >
				<form action="login" method="post">
					<h2 style="text-align:center;">로그인</h2>
					<div>
						<input type="text" name="userId" placeholder="아이디" class="form-control" maxlength="20">
					</div>
					<div style="padding-top: 20px;">
						<input type="password" name="userPasswd" placeholder="비밀번호" class="form-control" maxlength="20">
					</div>
					<div class="d-grid gap-2" style="padding-top: 20px;">
  						<button class="btn btn-primary" type="submit">로그인</button>
  						<button class="btn btn-primary buttonsign" type="button">회원가입하러가기</button>
					</div>		
				</form>					
			</div>
		</div>
	</div>
	
	<script>
	$(".buttonsign").on("click",handlerSign);
	function handlerSign (){
		location.href="<%=request.getContextPath()%>"+"/sign";
	}

	</script>
</body>
</html>