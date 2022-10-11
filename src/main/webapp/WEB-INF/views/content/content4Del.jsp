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
	#form {
		width:98%;
		display : flex;
	}
	#form textarea {
		width : 88%;
		height : 150px;
	}
	#form button {
		height : 150px;
		width:10%;
		margin-left : 20px;
	}
	#list{
		border : none;
		width : 99.1%;
		padding : 0;
	}
	.del {
	
	}
</style>
</head>
<body>
	<h4>제목 : ${vo.title }</h4>
	<hr />
	<textarea name="" id="" cols="100" rows="15" >${vo.content}</textarea>
	<form action="${pageContext.request.contextPath }/back4_1" method="get">
		<button>뒤로가기</button>
	</form>
	<div id="list">
	<c:forEach var="item" items="${comment}">
		<div class="comm" id="comm">
			<h4>${item.owner}</h4>
			<p>${item.content}</p>
			<c:if test="${item.ownerId eq session.id}">
				<button id="${item.id }" class="del">삭제버튼</button>
			</c:if>
		</div>	
			<c:forEach var="item2" items="${recomment}">
				<c:if test="${item.id eq item2.orderId}">
					 <div id="recomm" class="recomm">
						<h4>${item2.owner}</h4>
						<p> ↳ ${item2.content}</p>
						<c:if test="${item2.ownerId eq session.id}">
							<button id="${item2.id }" class="del">삭제</button>
						</c:if>
					</div>
					 <c:forEach var="item3" items="${recomment}">
						<c:if test="${item2.id eq item3.orderId}">
							 <div class="rerecomm">
								<h4>${item3.owner}</h4>
								<p> ↳ ${item3.content}</p>
								<c:if test="${item3.ownerId eq session.id}">
									<button id="${item3.id }" class="del">삭제</button>
								</c:if>
							</div>
						</c:if>
					</c:forEach> 
				</c:if>
			</c:forEach>
	</c:forEach>
	</div>
	<div class="Put">
	<form action="putcomm4" method="post" id="form">
		<textarea name="putcomm" id="content"></textarea>
		<button id="btn">댓글달기</button>
	</form>
	</div>
	<script type="text/javascript">
	document.getElementById("btn").addEventListener("click", function(e) {
		e.preventDefault();
		let content = document.getElementById("content").value;
		let simple_data = { content };
		
		fetch("${pageContext.request.contextPath}/putcomm4_1/${vo.id}",{
   		 	method : "POST",
			headers : {"Content-Type" : "application/json"},
			body : JSON.stringify(simple_data)
		}).then(response => response.json(), e => console.log("error!!"))
		.then(data => {
			//console.log(data.content);
			//console.log(data.owner);
			const div = document.createElement("div");
			div.setAttribute("class", "comm");

			let h4 = document.createElement("h4");
			h4.innerText = data.owner;
			let p = document.createElement("p");
			p.innerText = data.content;
			div.append(h4);
			div.append(p);
			document.getElementById("list").append(div);
		})
	});
	
	<% 
	Object comment = request.getAttribute("comment");
	for(int i=0; i<comment.length; i++) { %>
		console.log(${comment[<%=i%>].id});
		document.getElementById("${comment[0].id}").addEventListener("click", function() {
		if(confirm("댓글을 삭제하시겠습니까?")) {
			
			let simple_data =  {id : ${comment[0].id} } ;
			
			fetch("${pageContext.request.contextPath}/delcomm",{
	   		 	method : "POST",
				headers : {"Content-Type" : "application/json"},
				body : JSON.stringify(simple_data)
			}).then(response => response.json(), e => console.log("error!!"))
			.then(data => {
				if(data > 0) {
				document.getElementById("${comment[0].id}").parentElement.remove();
				}
			})
		};
		
	});
		<% }%>
	
	</script>

</body>
</html>