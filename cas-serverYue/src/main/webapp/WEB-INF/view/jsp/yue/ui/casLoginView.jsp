<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en" class="login_page">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>悦.欢迎您登录</title>

<!-- 自定义登录页面样式css加载,begin -->
<link rel="stylesheet" href="/cas/css/yue/bootstrap.min.css">
<link rel="stylesheet" href="/cas/css/yue/font-awesome.min.css">
<link rel="stylesheet" href="/cas/css/yue/animate.min.css">
<link rel="stylesheet" href="/cas/css/yue/login.css">

<!-- 自定义登录页面样式css加载,end -->

<!-- favicon -->
<link rel="shortcut icon" href="favicon.ico" />
</head>
<body>

	<div id="loginpage">
		<div class="container animated fadeInDown">
			<h2 class="page-header">悦.欢迎登录</h2>
			<%
				final String queryString = request.getQueryString() == null ? ""
						: request.getQueryString().replaceAll(
								"&locale=([A-Za-z][A-Za-z]_)?[A-Za-z][A-Za-z]|^locale=([A-Za-z][A-Za-z]_)?[A-Za-z][A-Za-z]",
								"");
			%>
			<c:set var='query' value='<%=queryString%>' />
			<c:set var="xquery" value="${fn:escapeXml(query)}" />
			<form action="login?${xquery}&locale=zh_CN" method="post"
				id="signinForm">
				<input type="hidden" name="_eventId" value="submit" /> <input
					type="hidden" name="lt" value="${loginTicket}" /> <input
					type="hidden" name="execution" value="${flowExecutionKey}" />
				<spring:hasBindErrors name="credential">
					<div class="alert alert-info alert-login">
						<c:forEach var="error" items="${errors.allErrors}">
							<spring:message code="${error.code}"
								text="${error.defaultMessage}" />
						</c:forEach>
					</div>
				</spring:hasBindErrors>
				<div class="form-group">
					<input type="text" id="username" name="username"
						class="form-control" placeholder="请输入已注册的手机号码/邮箱" /> <span
						class="fa fa-check"></span>
				</div>
				<div class="form-group">
					<input type="password" name="password" id="password"
						class="form-control" placeholder="请输入密码" /> <span
						class="fa fa-check"></span>
				</div>
				<div class="form-group row">
					<div class="col-md-8">
						<input type="text" id="authcode" name="authcode"
							class="form-control" placeholder="请输入验证码" />
					</div>
					<div class="col-md-4">
						<canvas id="canvas" class="canvas-code" width="100%" height="35px"
							onClick="drawCode()"></canvas>
					</div>
				</div>
				<button type="submit" id="btnSignIn"
					class="btn btn-primary btn-block">立即登录</button>
			</form>
			<div class="login-footer text-center">
				<p>
					<a href="signup.html">尚未注册？</a> <span class="line">|</span> <a
						data-toggle="modal" href="signin.html#myModal">忘记密码</a>
				</p>
			</div>
		</div>
	</div>
	<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
		tabindex="-1" id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">忘记密码 ?</h4>
				</div>
				<div class="modal-body">
					<p>请输入邮箱号重置密码</p>
					<input type="text" name="email" placeholder="邮箱号"
						autocomplete="off" class="form-control placeholder-no-fix">

				</div>
				<div class="modal-footer">
					<button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
					<button class="btn btn-theme" type="button">提交</button>
				</div>
			</div>
		</div>
	</div>
	<script src="/cas/js/yue/jquery.min.js"></script>
	<script src="/cas/js/yue/bootstrap.min.js"></script>
	<script src="/cas/js/yue/login.js"></script>
</body>
</html>


