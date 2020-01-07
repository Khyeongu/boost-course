<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="kr.or.connect.todo.dto.Todo"%>
<%@page import="kr.or.connect.todo.dao.TodoDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>TODO LIST</title>
	<link rel = "stylesheet" href="./style.css">
	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Noto+Sans+KR&display=swap" rel="stylesheet">
	<script src="http://http://code.jquery.com/jquery-1.11.0.js"></script>
  	<script src="../res/js/jquery-1.11.0.js"></script>
</head>
<body>
	<span id="main"> 나의 해야할 일들 </span>
	<button id="upload" onclick="location.href='./todoForm.jsp'"> 새로운 TODO 등록 </button>
	<section class="section" id="todo">
		<div class="list"> TODO </div>
		<%
		TodoDao tododao = new TodoDao();
		List<Todo> todo_list = tododao.getTodos("TODO");
		
		request.setAttribute("todo_list", todo_list);
		%>
		<c:forEach items="${todo_list}" var="item">
			<div class="content">
				<div class="title">${item.title }</div>
				<span class="detail">등록날짜 : ${fn:split(item.redate, ' ')[0]}, ${item.name }, 우선순위${item.sequence }</span>
				<button class="arrow" onclick="altertodo('${item.id}')">▶</button>
			</div>
		</c:forEach>
	</section>
	<section class="section" id="doing">
		<div class="list"> DOING </div>
		<%
		TodoDao doingdao = new TodoDao();
		List<Todo> doing_list = doingdao.getTodos("DOING");
		
		request.setAttribute("doing_list", doing_list);
		%>
		<c:forEach items="${doing_list}" var="item">
			<div class="content">
				<div class="title">${item.title }</div>
				<span class="detail">등록날짜 : ${fn:split(item.redate, ' ')[0]}, ${item.name }, 우선순위${item.sequence }</span>
				<button class="arrow" onclick="alterdoing('${item.id}')">▶</button>
			</div>
		</c:forEach>
	</section>
	<section class="section" id="done">
		<div class="list"> DONE </div>
		<%
		TodoDao donedao = new TodoDao();
		List<Todo> done_list = donedao.getTodos("DONE");
		
		request.setAttribute("done_list", done_list);
		%>
		<c:forEach items="${done_list}" var="item">
			<div class="content">
				<div class="title">${item.title }</div>
				<span class="detail">등록날짜 : ${fn:split(item.redate, ' ')[0]}, ${item.name }, 우선순위${item.sequence }</span>
			</div>
		</c:forEach>
	</section>
	
	<script>
	function altertodo(id) {
		 var oReq = new XMLHttpRequest();
		 oReq.addEventListener("load", function() {
		   console.log(this.responseText);
		 });    
		 oReq.open("GET", "altertodo?data=id");//parameter를 붙여서 보낼수있음. 
		 oReq.send();
	}
	function alterdoing(data) {
		 var oReq = new XMLHttpRequest();
		 oReq.addEventListener("load", function() {
		   console.log(this.responseText);
		 });    
		 oReq.open("GET", "altertodoing/data");//parameter를 붙여서 보낼수있음. 
		 oReq.send();
	}
	</script>
</body>

</html>