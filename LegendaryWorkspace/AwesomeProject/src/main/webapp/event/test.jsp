<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/MyTopic/Bootstrap/css/bootstrap.min.css">
<!-- href：里面的路径是你导入在static文件夹里面下面bootstrap.min.css所在的路径，下面两个属性一样 -->



</head>
<body>
	<h1>你好，世界！</h1>
	<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>

	<nav aria-label="Page navigation">
	<ul class="pagination">
		<li><a href="#" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
	</nav>
	<!-- Standard button -->
	<button type="button" class="btn btn-default">（默认样式）Default</button>

	<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
	<button type="button" class="btn btn-primary">（首选项）Primary</button>

	<!-- Indicates a successful or positive action -->
	<button type="button" class="btn btn-success">（成功）Success</button>

	<!-- Contextual button for informational alert messages -->
	<button type="button" class="btn btn-info">（一般信息）Info</button>

	<!-- Indicates caution should be taken with this action -->
	<button type="button" class="btn btn-warning">（警告）Warning</button>

	<!-- Indicates a dangerous or potentially negative action -->
	<button type="button" class="btn btn-danger">（危险）Danger</button>

	<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
	<button type="button" class="btn btn-link">（链接）Link</button>

	<table class="table table-hover">
		<tr>
			<td>aaa</td>
		</tr>
	</table>
</body>
</html>