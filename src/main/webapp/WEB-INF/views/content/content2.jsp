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
		width : 99.8%;
		padding : 10px;
	}
	
</style>
</head>
<body>
	<h4>제목 : ${vo.title }</h4>
	<hr />
	<textarea name="" id="" cols="100" rows="15" >${vo.content}</textarea>
	<form action="${pageContext.request.contextPath }/back2" method="get">
		<button>뒤로가기</button>
	</form>

	<c:forEach var="item" items="${comment}">
		<div>
		<h4>${item.owner}</h4>
		<p>${item.content}</p>
		</div>
	</c:forEach>
</body>
</html>