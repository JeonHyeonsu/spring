<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!--Import Bootstrap-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.8/js/solid.js"
	integrity="sha384-+Ga2s7YBbhOD6nie0DzrZpJes+b2K1xkpKxTFFcx59QmVPaSA8c7pycsNaFwUK6l"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.8/js/fontawesome.js"
	integrity="sha384-7ox8Q2yzO/uWircfojVuCQOZl+ZZBg2D2J5nkpLqzH1HY0C1dHlTKIbpRz/LG23c"
	crossorigin="anonymous"></script>

<!--Import Static files-->
<script src="/resources/front/js/redirect.js"></script>
<link href="/resources/front/css/global.css" rel="stylesheet">

<!--Meta tag Definition-->
<title>The Unofficial Pok&eacute;mon Website</title>
<link rel="shortcut icon" href="/resources/img/favicon.ico" />
<meta property="og:image"
	content="http://ync.jupiterflow.com/pokemon-web/static/image/logo-pokemon-400x400.png">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/"><img
			src="/resources/img/quizlogo.jpg" alt="Logo"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Quiz </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="/front/quiz_jp">日本語</a>
						<!-- <div class="dropdown-divider"></div> -->
						<a class="dropdown-item" href="/front/quiz_ns">Nonsense</a>
						<a class="dropdown-item" href="/front/quiz_cm">Commonsense</a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="/front/userRegister">Quiz Make</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/front/rank">Ranking</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fa fa-user fa-fw"></i>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<sec:authorize access="hasRole('ROLE_USER')">
							<a class="dropdown-item"><i class="fa fa-user fa-fw"></i>&nbsp;<sec:authentication
									property="principal.username" />&nbsp; 님</a>
							<a class="dropdown-item move"
								href='<sec:authentication property="principal.username"/>'><i
								class="fas fa-user-edit"></i>&nbsp; 유저정보</a>
						</sec:authorize>

						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a class="dropdown-item"><i class="fa fa-user fa-fw"></i>&nbsp;<sec:authentication
									property="principal.username" />&nbsp; 님</a>
							<a class="dropdown-item move"
								href='<sec:authentication property="principal.username"/>'><i
								class="fas fa-user-edit"></i>&nbsp; 유저정보</a>
							<a class="dropdown-item" href="/front/list2"><i
								class="fas fa-user-cog"></i>&nbsp; 관리자 페이지 </a>
						</sec:authorize>



						<div class="dropdown-divider"></div>
						<sec:authorize access="isAnonymous()">
							<a class="dropdown-item" href="/front/membermake"><i
								class="fas fa-user-plus"></i>&nbsp; 회원가입 </a>
						</sec:authorize>
						<sec:authorize access="isAuthenticated()">
							<a class="dropdown-item" href="/front/logout"><i
								class="fas fa-sign-out-alt"></i>&nbsp; Logout</a>
						</sec:authorize>

						<sec:authorize access="isAnonymous()">
							<a class="dropdown-item" href="/front/login"><i
								class="fas fa-sign-in-alt"></i>&nbsp; Login</a>
						</sec:authorize>
					</div></li>
			</ul>
		</div>
		<form id='actionForm1' action="/front/index" method="get"></form>
	</nav>
	<script type="text/javascript">
		var actionForm = $("#actionForm1");
		$(".move").on(
				"click",
				function(e) {
					e.preventDefault();
					actionForm.append("<input type='hidden' name='id' value='"
							+ $(this).attr("href") + "'>");
					actionForm.attr("action", "/front/userprofile");
					actionForm.submit();
				});
	</script>