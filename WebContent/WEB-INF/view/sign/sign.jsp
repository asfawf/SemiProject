<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/nav/nav.jsp"></jsp:include>	
	
	<div class="container" style="padding-top: 20px;" >
		<div class="row">
			<div >
				<form action="sign" method="post">
					<h2 style="text-align:center;">회원가입</h2>
					<div calss="row">
						<div class="input-group mb-3">
  							<input type="text" name="userId" class="form-control" placeholder="아이디" aria-label="Recipient's username" aria-describedby="button-addon2">
  							<button class="btn btn-outline-secondary btndupchk" type="button" id="button-addon2">중복 체크</button>
  						</div>
  						<span class="dupmsg"></span>
							
					</div>
					<div style="padding-top: 20px;">
						<input type="password" name="userPasswd" placeholder="비밀번호" class="form-control" maxlength="20">
					</div>
					<div style="padding-top: 20px;">
						<input type="text" name="userName" placeholder="이름" class="form-control" maxlength="20">
					</div>
					<div  style="padding-top: 20px;">
						<select class="form-select" aria-label="Default select example" name="userGender">
  							<option selected>성별을 고르시오</option>
  							<option value="F">여자</option>
  							<option value="M">남자</option>
						</select>
					</div>
					<div style="padding-top: 20px;">
						<input type="text" name="userEmail" placeholder="이메일" class="form-control" maxlength="20">
					</div>
					
					<div class="d-grid gap-2" style="padding-top: 20px;">
  						<button class="btn btn-primary" type="submit">회원가입</button>
					</div>		
				</form>					
			</div>
		</div>
	</div>
	
	<script>
		$(".btndupchk").on("click", handlerdupbtn);
		function handlerdupbtn(){
			console.log("실행 ");
			$.ajax(
					{ 
						url:"<%=request.getContextPath()%>/dupck",
						type:"post",
						data:{userId:$("input[type=text]").first().val()}, // data:{userId:$("input[type=text]").first().val()} 여기서 userId 는 지칭어 Servlet 에서 부르는
						success: function(result){
							console.log(result);
							if(result == 1){
								$("span").last().html("중복 존재");
								$("span").last().css("color", "red");
							}else{
								$("span").last().html("사용가능");
								$("span").last().css("color", "blue");
							}
						}, 
						error: function(request, state, error){
								alert(request.status);
						}
						
					} 
				
					
			);
			
		}
	</script>
</body>
</html>