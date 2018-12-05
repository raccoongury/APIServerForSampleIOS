<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<div id="listdisplay"></div>
</body>
<!-- jquery 링크 추가 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
//ajax로 memo/memolist 요청을 수행해주는 함수
function memolist(){
	$.ajax({
		url:'memo/memolist',
	    dataType:'json',
		success: function(memolist){
			//listdisplay라는 id를 가진 DOM객체를 찾아오는 것
			//value 속성 입력한 값을 가져오는 속성
			//innerHTML은 태그 와 태그 사아의 내용을 가져오거나 설정하는 속성
			var listdisplay = 
				document.getElementById("listdisplay")
			//제목 출력
			listdisplay.innerHTML = 
				"<h3 align='center'>메모 목록</h3>"
			//데이터 개수 출력
			listdisplay.innerHTML += 
				"<p>메모 개수:" + memolist.totalcount + "<p>"
			//테이블 생성 태그
			var display = "<table border='1'>"
			//테이블의 제목 셀 만들기
			display += 
				"<tr><th>메모번호</th><th>메모제목</th><th>작성일</th></tr>";
				
			var ar = memolist.memos;
			//배열 순회 - 임시변수에 인덱스가 대입됩니다.
			for(i in ar){
				record = ar[i]
				display += "<tr><td>" + record.NUM +"</td>";
				//상세보기를 구현할려면 기본키 값을 넘겨주는 방법을 고민해야 합니다.
				display += "<td><a href='#' onclick='detail(" + record.NUM +
						")'>"+ record.TITLE +"</a></td>";
				display += "<td>" + record.REGDATE +"</td></tr>";
			}
			
			
			display += "</table>"
			
			listdisplay.innerHTML += display
		}
	})
}

//상세보기를 위한 함수
function detail(num){
	$.ajax({
		url:"memo/memodetail",
		data:{"num":num},
		dataType:"json",
		success:function(memo){
			alert(memo)
		}
	});
}

//jquery에서 문서가 시작되자 마자 수행
$(function(){
	memolist()
})
</script>

</html>
