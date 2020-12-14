<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">Board Modify</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/front/quizmodify" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="form-group">
						<label>번호</label> <input class="form-control" name='quiz_idx'
							value='<c:out value="${quiz.quiz_idx }"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>문제</label> <input class="form-control" name='question'
							value='<c:out value="${quiz.question }"/>'>
					</div>

					<div class="form-group">
						<label>정답</label> <input class="form-control" name='answer'
							value='<c:out value="${quiz.answer }"/>'>
					</div>

					<div class="form-group">
						<label>보기1</label> <input class="form-control" name='example1'
							value='<c:out value="${quiz.example1 }"/>'>
					</div>

					<div class="form-group">
						<label>보기2</label> <input class="form-control" name='example2'
							value='<c:out value="${quiz.example2 }"/>'>
					</div>

					<div class="form-group">
						<label>보기3</label> <input class="form-control" name='example3'
							value='<c:out value="${quiz.example3 }"/>'>
					</div>

					<div class="form-group">
						<label>퀴즈 타입</label> </br> <input type="radio" value="1"
							name='type_idx'>일본어 퀴즈</input></br> <input type="radio" value="2"
							name='type_idx'>넌센스 퀴즈</input></br> <input type="radio" value="3"
							name='type_idx'>상식 퀴즈</input></br>
					</div>

					<div class="form-group">
						<label>ID</label> <input class="form-control" name='id'
							value='<c:out value="${quiz.id }"/>' readonly="readonly">
					</div>

					<sec:authentication property="principal" var="pinfo" />
					<sec:authorize access="isAuthenticated()">
						<c:if test="${pinfo.username eq quiz.id}">
							<button data-oper='modify' class="btn btn-success">Success</button>
							<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
						</c:if>
					</sec:authorize>
					<button data-oper='list' class="btn btn-info">List</button>

			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>

<script type="text/javascript">
	$(document).ready(function() {

		var operForm = $("#operForm");

		$("button[data-oper='modify']").on("click", function(e) {

			operForm.attr("action", "/front/quizmodify").submit();

		});

		$("button[data-oper='list']").on("click", function(e) {

			operForm.attr("action", "/front/list2").submit();

		});

		$("button[data-oper='remove']").on("click", function(e) {

			operForm.find("#quiz_idx").remove();
			operForm.attr("action", "/front/remove")
			operForm.submit();

		});
	});
</script>


<%@include file="../includes/footer.jsp"%>