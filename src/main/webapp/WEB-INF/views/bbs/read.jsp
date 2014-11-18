<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${vo.title}</title>
	<!-- <style>
		.thumb {
			/* float: left; */
			width: 100px;
			height: 100px;
		}
	</style> -->
</head>
<body>
	<h1>${vo.title }</h1>
	글쓴이 : ${vo.userid }   작성일 : ${vo.regdate }
	<br>
	<p>${vo.cont }</p>
	<br>
	
	<div id="downloadUL"></div>
	<br>
	<%-- <a href="javascript:_list('${vo.contfile }')">첨부파일 미리보기</a>
	<br> --%>
	<!-- <button onclick="updateBtn();">수정</button>
	<button onclick="delBtn();">삭제</button> -->
	<div>
	<button><a href="uboard?bno=${vo.bno }">수정</a></button>
	<button><a href="delete?bno=${vo.bno }">삭제</a></button>
	</div>
	<form class="replyForm" name="replyForm">
		<p>덧글을 작성하세요</p>
		작성자<input type="text" name="userid">
		덧글내용<input type="text" name="cont">
		<input type="hidden" name="bno" value=${vo.bno }>
		<input type="hidden" name="rno">
	</form>
		<button class="putReply">리플달긔</button>
	<div class="reply"></div>
	
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script>
		$(document).ready(function(){
			list('${vo.contfile }');
			replyList();
			
		});
		
		$(".putReply").on("click", replyCreate);
		
		function replyList(){
			var url = "reply/list";
			//var postData = $(".replyForm").serialize();
			replyAction(url);
		}
		
		function updateBtn(){
			alert('aaa');
			//내부 로직 정의
		}
		
		function delBtn(){
			alert('delete');
		}

		function replyCreate(){
			var url = "reply/create";
			replyAction(url);
			document.replyForm.userid.value = "";
			document.replyForm.cont.value = "";
		}
		
		function replyDelete(num){
			document.replyForm.rno.value = num;
			var url = "reply/delete";
			replyAction(url);
		}
		
		function replyUpdate(){
			document.replyForm.rno.value = document.getElementById("modifyReplyRno").value;
			document.replyForm.cont.value = document.getElementById("modifyReplyCont").value;
			var url = "reply/update";
			replyAction(url);
			document.replyForm.rno.value = "";
			document.replyForm.cont.value = "";
		}

		function changeForm(num, msg){
			var target = document.getElementById('reply_' + num);
			target.innerHTML ="<div>덧글을 수정해주세요."
				+"<textarea id='modifyReplyCont' name='cont' rows='1' cols='50'>"+msg+"</textarea>"
				+"<input id='modifyReplyRno' type='hidden' name='rno' value='"+num+"'>"
				+"<input type='button' value='수정' onclick='replyUpdate()'>"
				+"</div>"
		}
		
		function replyAction(url){
		    var target = $(".reply");
		    $.post(url, $(".replyForm").serialize(), function(data){
		    	// $(".replyForm").serialize() - 목표가 되는 form의 파라미터들을 a=1&b=2&c=3 식으로 get이나 post방식에 적용하기 편하게 만들어줌
		    	console.log(data);
		    	var items = [];
		    	var content = "";
				$.each(data, function (key, val) {
					console.log(key, val);
					//items.push("<ul><li>"+val.cont+"</li></ul>") // 배열사용
					content += "<ul><li id='reply_"+val.rno+"' name='reply_"+val.rno+"'>"+val.cont
						+"<input type='button' value='수정' onclick='changeForm(" + val.rno + ",\"" + val.cont +"\""
						+")'>"
						+"<input type='button' value='삭제' onclick='replyDelete("+val.rno
						+")'></li></ul>"; // 문자열 사용
				});
				
				// content += "<script>function replyDelete(num){document.replyForm.rno.value = num\; var url = "reply/delete"\; replyAction(url)\;}<"+"/script>";
				// 배열을 사용한 방식은 items.join("")으로 문자열을 만들어주고
				// 문자열을 사용한 방식은 문자열에 계속 붙여주는 방식임. getSql할때 StringBuilder를 사용했던것과 같음
				
				/* $("<div/>", {
					"class": "line",
					html: items.join("")
				}).appendTo(target); */
				// div가 append로 추가됨. 무한덧글할때 사용하면 될듯
				
				target.html(content);
				// target에 innerHTML로 덮어써주는 방식
		    });
		}
		
		function list(file){
			
			console.log(file)
			if(file.length ==0 || file == null){
				$("#downloadUL").append("첨부파일 없음");
			}else{
			/* 첨부파일보기 다시 눌렀을 때 중복으로 보여짐 막음 */
				var element = document.getElementById("downloadUL");
				while (element.firstChild) {
					element.removeChild(element.firstChild);
				}
			
				var name = file.split(",");
				for(var i=0 ; len=i<name.length,len; i++){
					/* -1은 존재하지 않는다면을 뜻함 */
					if (name[i].indexOf('.jpg')!= -1 || name[i].indexOf('.png')!= -1 || name[i].indexOf('.gif')!= -1){
						$("#downloadUL").append("<p><a href='/bbs/file/down?src="+name[i]+"'><image class='thumb' data-src='"+name[i]+"' src='/bbs/file/view?img="+name[i]+"'/></a></p>");
					}else{
						$("#downloadUL").append("<p><a href='/bbs/file/down?src="+name[i]+"'>"+name[i].slice((name[i].indexOf('_')+1))+"</a></p>");
					}
				}
			}
		}
	</script>
</body>
</html>