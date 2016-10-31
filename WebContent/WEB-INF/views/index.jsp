<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<fieldset>
			<legend>查询</legend>
			<form action="toQuery">
				<input type="text" name="my_key" />
				<input type="submit" name="提交" />
			</form>
		</fieldset>
		<fieldset>
			<legend>新增</legend>
			<form action="saveWord">
				Key：<input type="text" name="word_key" />
				value：<input type="text" name="word_value" />
				<input type="submit" name="提交" />
			</form>
		</fieldset>
		<!-- 查询结果 -->
		<c:if test="${wordList!=null}">
			<c:forEach items="${wordList }" var="word">
				 key：${word.key }   --  value：${ word.value } &nbsp;&nbsp;&nbsp; <a href="deleteKey/${word.key}">delete key</a>
				 <br/>
			</c:forEach>
		</c:if>
	</body>
</html>