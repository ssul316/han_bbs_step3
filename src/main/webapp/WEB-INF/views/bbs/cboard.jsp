<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 등록</title>
<style>
	.thumb {
		list-style: none;
		float: left;
		width: 100px;
		height: 100px;
	}
</style>
</head>
<body>
<h1>게시글을 작성해 주세요</h1>

<form action="/bbs/create">
	글 제목<input type="text" name="title"><br>
	작성자<input type="text" name="userid"><br>
	본문<textarea rows="3" cols="50" name="cont"></textarea><br>
	<ul class="uploadUL"> <!-- file upload  --></ul>
	<input type="submit" value="전송">
</form>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.js"></script>
<script>
function updateResult(data){
	
	$(".uploadUL").append("<input type='hidden' name='contfile' value='"+data.fileName+"'></p>");
	
	//$(".uploadUL").append("<li><image class='thumb' src='/web/file/view/"+ fileName+"'/></li>");
	if(data.suffix == '.jpg'){
		$(".uploadUL").append("<li><a href='/bbs/file/down?src="+data.fileName+"'><image class='thumb' data-src='"+data.fileName+"' src='/bbs/file/view?img="+ data.fileName+"'/></a></li>");
	}else{
		$(".uploadUL").append("<li><a href='/bbs/file/down?src="+data.fileName+"'><image class='thumb' data-src='"+data.fileName+"' src='/resources/img/cardFile.png'/></a></li>");
	}
}
</script>

<form target="zero" action="file/upload" method="post" enctype="multipart/form-data">
	<input type='file' name='file'><input type='submit' value="UPLOAD">
</form>

<iframe name="zero" width="0" height="0"></iframe>
</body>
</html>