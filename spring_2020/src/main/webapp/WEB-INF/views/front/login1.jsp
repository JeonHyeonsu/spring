<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="header.jsp"%>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext" rel="stylesheet" />
         
<script src="/resources/front/js/script.js"></script>


<div class="materialContainer">
    <form role="form" method='post' action="/front/login">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<div class="box">

		<div class="title">LOGIN</div>

		<div class="input">
			<label for="userid">ID</label> <input type="text" name="id"
				id="id"> <span class="spin"></span>
		</div>

		<div class="input">
			<label for="userpwd">Password</label> <input type="password" name="userpwd"
				id="userpwd"> <span class="spin"></span>
		</div>

		<div class="button login">
			<button>
				<span>GO</span> <i class="fa fa-check"></i>
			</button>
		</div>

		<a href="" class="pass-forgot">Forgot your password?</a>

	</div>
	</form>
    <form role="form" action="/front/login" method="post" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<div class="overbox">
		<div class="material-button alt-2">
			<span class="shape"></span>
		</div>

		<div class="title">REGISTER</div>

		<div class="input">
			<label for="id">ID</label> <input type="text" name="id"
				id="id"> <span class="spin"></span>
		</div>

		<div class="input">
			<label for="pwd">Password</label> <input type="password"
				name="pwd" id="pwd"> <span class="spin"></span>
		</div>

		<div class="input">
			<label for="repwd">Repeat Password</label> <input type="password"
				name="repwd" id="repwd"> <span class="spin"></span>
		</div>

		<div class="input">
			<label for="email">Email</label> <input type="text"
				name="email" id="email"> <span class="spin"></span>
		</div>

		<div class="input">
			<label for="username">Name</label> <input type="text" name="username"
				id="username"> <span class="spin"></span>
		</div>

		<div class="button">
			<button class="submit">
				<span>Submit</span>
			</button>
		</div>
	</div>
	</form>
</div>
</body>
</html>