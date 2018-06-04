<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8"> 
<title>首页</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<body>
<a href="${pageContext.request.contextPath }/index">springmvc首页</a><br>
<a href="${pageContext.request.contextPath }/testPathVarivable/999">带有占位符的请求</a>
<hr>
<a href="${pageContext.request.contextPath }/testReqParam?age=10">带有请求参数age=10的请求</a><br>
<a href="${pageContext.request.contextPath }/testReqParam?age=10&name=罗">带有请求参数age=10,name=luo的请求</a><br>
<form action="${pageContext.request.contextPath }/testPojo" method="POST">
   name: <input type="text" id="sname" name="sname"><br>
    age: <input type="text" id="sage" name="sage"><br>
  birth: <input type="datetime" name="sbirth"><br>
  <input type="submit" value="提交">
</form>
<br>
<a href="${pageContext.request.contextPath }/testRetMap">testRetMap首页</a><br>
${requestScope.map}
<hr>
<button id="testAjax">发送ajax请求</button>
</body>
<script type="text/javascript">
$(function(){
	$("#testAjax").click(function(){
		var url = "${pageContext.request.contextPath }/testAjax";
		var data = {"sname":$("#sname").val(),"ssex":$("#sage").val()};
		$.post(url,data,function(data){
			alert("返回数据"+data.sname);
			console.log(data);
		},"json")
	})
})
</script>
</html>