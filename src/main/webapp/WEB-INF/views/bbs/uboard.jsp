<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
</head>
<body>
<h1>게시글을 수정해주세요</h1>
${bbsVO }
<form action="/bbs/update">
제목<textarea rows="1" cols="50" name="title">${vo.title }</textarea><br>
본문<textarea rows="1" cols="50" name="cont">${vo.cont }</textarea><br>
<input type="hidden" name="bno" value=${vo.bno }>
<input type="submit" value="수정">
</form>
</body>
</html>