<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>STEP 2</title>
</head>
<body>
	<h1>한잔해의 게시판 step2</h1>

	<button type="button"><a href="cboard">글쓰기</a></button>
	
	<c:if test="${pm.cnt == 0}">
		<p>검색된 게시물이 없습니다.</p>
		<a href="list">[메인페이지로]</a>
	</c:if>
	<c:forEach items="${list}" var="vo">
		<li>[글번호:${vo.bno}] <a href="read?bno=${vo.bno}">[제목:${vo.title}]</a> [작성자:${vo.userid}] [게시일:${vo.regdate}] [조회수:${vo.vcount}]</li>
	</c:forEach>
	<br>
	<c:if test="${pageMaker.hasPrev}">
		<a href="javascript:_goPage(${pageMaker.first-1})">[이전]</a>
	</c:if>
	<c:forEach begin="${pageMaker.first }" end="${pageMaker.last }" var="idx">
	 	<a href="javascript:_goPage(${idx})">[${idx}]</a>
	</c:forEach>
	<c:if test="${pageMaker.hasNext}">
		<a href="javascript:_goPage(${pageMaker.last+1})">[다음]</a>
	</c:if>
	<form name="searchForm">
		<input type="hidden" name="page" value="${pageMaker.page }">
		<input type="text" name="keyword" value="${pageMaker.keyword }">
		<input type="checkbox" name="types" value="t" ${pageMaker.checked("t") }>제목
		<input type="checkbox" name="types" value="w" ${pageMaker.checked("w") }>작성자
		<input type="checkbox" name="types" value="c" ${pageMaker.checked("c") }>본문
		<button onclick="_goPage(1)">검색</button>
	</form>
	
	<br>
	${pageMaker}
	
	<script>
		function _goPage(num){
			document.searchForm.page.value = num;
			document.searchForm.submit();
		}
	</script>
</body>
</html>