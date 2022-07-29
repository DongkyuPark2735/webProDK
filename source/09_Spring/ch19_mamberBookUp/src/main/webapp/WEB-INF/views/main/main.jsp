<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
#content {
	width: 800px;
	height: 350px;
	margin: 50px auto;
}
img {
	width: 100px;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<c:if test="${not empty modifyResult }">
		<script>
			alert("정보 수정이 돤료 되었습니다");
		</script>
	</c:if>
	<jsp:include page="header.jsp" />
	<div id="content">
		<table>
			<caption>신규 도서 BEST 5</caption>
			<tr>
				<th>1</th>
				<th>2</th>
				<th>3</th>
				<th>4</th>
				<th>5</th>
			</tr>
			<tr>
				<c:forEach var="book" items="${mainList }" begin="0" end="4">
					<td>${book.btitle }<br> 
					<a href="${conPath }/book.do?method=detail&bnum=${book.bnum}&pageNum=1">
							<img src="${conPath }/bookImgFileUpload/${book.bimg1}">
					</a><br> ${book.bwriter } 著 <br> 출판일 : ${book.brdate }
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	
	<div>
		<input type="text" id="message" />
		<input type="button" id="sendBtn" value="submit"/>
		<div id="messageArea"></div>	
	</div>
	
	
	<jsp:include page="footer.jsp" />

</body>
<script type="text/javascript">
	$("#sendBtn").click(function() {
		sendMessage();
		$('#message').val('')
	});

	let sock = new SockJS("http://localhost:8090/chatting");
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	// 메시지 전송
	function sendMessage() {
		sock.send($("#message").val());
	}
	// 서버로부터 메시지를 받았을 때
	function onMessage(msg) {
		var data = msg.data;
		$("#messageArea").append(data + "<br/>");
	}
	// 서버와 연결을 끊었을 때
	function onClose(evt) {
		$("#messageArea").append("연결 끊김");

	}
</script>
</html>









