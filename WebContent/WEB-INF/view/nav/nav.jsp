<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #dee2e6;">
  <div class="container-fluid">
    <a class="navbar-brand home" href="#">Semi Project</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active home" aria-current="page" href="#">메인 페이지</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
      	<c:if test="${empty lgnss}">
	        <button class="btn btnsign" type="button">회원가입</button>
	        <button class="btn btnlogin" type="button">로그인</button>
	    </c:if>
	    <c:if test="${not empty lgnss}"> 
	    	<button class="btn btnmypage" type="button">마이페이지</button>
	    	<button class="btn btnlogout" type="button">로그아웃</button>
	    </c:if>
      </form>
  	 </div>
  </div>
</nav>
<script>
$(".btnsign").on("click",handlerSign);
function handlerSign (){
	location.href="<%=request.getContextPath()%>"+"/sign";
}

$(".btnlogin").on("click",handlerlogin);
function handlerlogin (){
	location.href="<%=request.getContextPath()%>"+"/login";
}

$(".btnlogout").on("click",handlerlogout);
function handlerlogout(){
	location.href="<%=request.getContextPath()%>"+"/logout";
}

$(".home").on("click",gohomewithnav);
function gohomewithnav(){
	location.href="<%=request.getContextPath()%>";
}

$(".btnmypage").on("click", btnmypage);
function btnmypage(){
	location.href="<%=request.getContextPath()%>"+"/myInfo";
}
</script>
