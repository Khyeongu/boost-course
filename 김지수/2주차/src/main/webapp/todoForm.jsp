<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>UPLOAD LIST</title>
	<link rel = "stylesheet" href="./style.css">
	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Noto+Sans+KR&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div id="upload_box">
    <div id="upload_title">할 일 등록 </div>
    <form id="form" action='add' method='post'>
      <div class="form-group">
        <label for="exampleInputEmail1">어떤 일인가요?</label>
        <input type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="24자까지 등록 가능" name="title">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">누가 할 일인가요?</label>
        <input type="text" class="form-control" id="name" placeholder="홍길동" name="name">
      </div>
      <label for="exampleInputEmail1">우선 순위</label>
      <div class="form-check">       
        <input class="form-check-input" type="radio" name="sequence" id="exampleRadios1" value="1" checked>
        <label class="form-check-label" for="exampleRadios1">
          1순위
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="sequence" id="exampleRadios2" value="2">
        <label class="form-check-label" for="exampleRadios2">
          2순위
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="sequence" id="exampleRadios3" value="3">
        <label class="form-check-label" for="exampleRadios3">
          3순위
        </label>
      </div>
      <div id="button_group">
        <button type="button" class="btn btn-outline-secondary" onclick="location.href='./index.jsp' ">이전</button>
        <button type="reset" class="btn btn-primary button">내용 지우기</button>
        <button type="submit" class="btn btn-primary button" id="submit_button">제출</button>
      </div>
    </form>
  </div>
</body>
</html>