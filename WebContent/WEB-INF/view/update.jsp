<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>          
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/nav/nav.jsp"></jsp:include>
	<!-- setAttribute로 보낸거
		vo.setBoardSubject(subject);
		vo.setBoardContent(content);
		vo.setBoardNum(urlNum);
	-->
	<form action="update?urlNum=${vo.boardNum }&subject=${vo.boardSubject }&content=${vo.boardContent }&writer=${vo.boardWriter }" method="post">
		<div class="container" style="padding-top: 60px">
			<div class="row">
				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">  <input type="text" class="form-control" name="updatedsubject"  value="${vo.boardSubject}" aria-label="Username" aria-describedby="basic-addon1"></th>
					      <th scope="col"></th>
					      <th scope="col"  style="text-align: right;"></th>
					    </tr>
					  </thead>
					  <tbody class="table-group-divider">
					    <tr>
					      <th scope="row">${vo.boardWriter }</th>
					      <td></td>
					      <td></td>
					      <td style="text-align: right;"></td>
					    </tr>
					    <tr>
					      <th scope="row" style="height: 500px; text-align: left;"><textarea class="form-control" name="updatedcontent" style="height: 500px; width: 1100px" id="exampleFormControlTextarea1"rows="3"> ${vo.boardContent} </textarea>
					      </th>
					    </tr>
					    <tr> 
					    	<th></th>
					    	<td> <button style="text-align: right;"   class="btn btn-primary" type="submit">수정하기</button> </td>
					    </tr>
					  </tbody>
				</table>	
			</div>
		</div>
	</form>

</body>
</html>