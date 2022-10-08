<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="com.goodee.vo.UserCommentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	textarea {
		width:99.8%;
	}
	form{
		display : inline;
	}
	button {
		display : block;
		height : 40px;
		margin : 5px;
		margin-left : 94%;
	}
	div {
		border : 1px solid black;
		width : 99.1%;
		padding : 10px;
	}
	.recomm {
		padding-left : 50px;
		width : 96.8%;
	}
	.rerecomm {
		padding-left : 100px;
		width : 94%;
	}
</style>
</head>
<body>
	<h4>제목 : ${vo.title }</h4>
	<hr />
	<textarea name="" id="" cols="100" rows="15" >${vo.content}</textarea>
	<form action="${pageContext.request.contextPath }/back3" method="get">
		<button>뒤로가기</button>
	</form>

	<c:forEach var="item" items="${comment}">
		<div class="comm">
			<h4>${item.owner}</h4>
			<p>${item.content}</p>
		</div>	
			<c:forEach var="item2" items="${recomment}">
				<c:if test="${item.id eq item2.orderId}">
					 <div id="comm" class="recomm">
						<h4>${item2.owner}</h4>
						<p> ↳ ${item2.content}</p>
					</div>
					 <c:forEach var="item3" items="${recomment}">
						<c:if test="${item2.id eq item3.orderId}">
							 <div class="rerecomm">
								<h4>${item3.owner}</h4>
								<p> ↳ ${item3.content}</p>
							</div>
						</c:if>
					</c:forEach> 
				</c:if>
			</c:forEach>
	</c:forEach>


</body>
</html>