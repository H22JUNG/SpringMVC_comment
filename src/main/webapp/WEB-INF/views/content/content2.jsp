<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<div id="firstDiv">
	<h4>${comment.owner}</h4>
	<p>${comment.content}</p>
	</div>
	<div>
	<h4>댓글쓴이</h4>
	<p>댓글내용</p>
	</div>
</body>
</html>