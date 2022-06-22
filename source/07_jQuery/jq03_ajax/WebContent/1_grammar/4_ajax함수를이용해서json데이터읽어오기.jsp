<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table {
			border-collapse: : collapse;
		}
		tr {
			border-bottom: 1px solid blue;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
	    $.ajax({
				url: "ex.json",
				dataType : 'json',
				success : function (data) {
					out = '<tr><th>id</th><th>name</th><th>price</th><th>description</th></tr>';
					$.each(data, function (idx, item) {
						out += '<tr><th>'+item.id+'</th><th>'+item.name+'</th><th>'+item.price+'</th><th>'+item.description+'</th></tr>';
					});//each
					$('#dataShow').html(out);
				}//success
				
	    });
		});
	</script>
</head>
<body>
	<table id="dataShow">
		
	</table>
</body>
</html>