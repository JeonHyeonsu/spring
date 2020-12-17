<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@include file="header.jsp"%>

<section class="container">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">

				<h2 class="post-title">UserProfile</h2>
				<!-- /.panel-heading -->
				<div class="panel-body">

					<form role="form" action="/front/usermodify" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-group">
							<label>유저 아이디</label> <input class="form-control" name='id'
								value='<c:out value="${user.id }"/>' readonly="readonly">
						</div>

						<div class="form-group">
							<label>유저 닉네임</label> <input class="form-control" name='username'
								value='<c:out value="${user.username }"/>'>
						</div>

						<div class="form-group">
							<label>이메일</label> <input class="form-control" name='email'
								value='<c:out value="${user.email }"/>'>
						</div>

						<input type="hidden" name="file_1" value="">

						<div class="form-group">
							<label>이미지 등록 1</label> <input type="file" class="form-control"
								name='uploadFile'>
						</div>
						
						<div class="form-group">
							<label>파일</label> <input class="form-control" name='profile_img'
								value='<c:out value="${user.profile_img }"/>' readonly="readonly">
						</div>

						<div class="form-group">
							<label>Profile</label>
							<textarea class="form-control" rows="3" name='profile'><c:out
									value="${user.profile}" /></textarea>
						</div>

						<div class="form-group">
							<label>Point</label> <input class="form-control" name='point'
								value='<c:out value="${user.point }"/>' readonly="readonly">
						</div>

						<sec:authentication property="principal" var="pinfo" />
						<sec:authorize access="isAuthenticated()">
							<c:if test="${pinfo.username eq user.id}">
								<button type="submit" data-oper='modify' class="btn btn-success">Success</button>
							</c:if>
						</sec:authorize>
						<button type="submit" data-oper='list' class="btn btn-info">List</button>

					</form>
				</div>
				<!--  end panel-body -->

			</div>
			<!--  end panel-body -->
		</div>
		<!-- end panel -->
	</div>
	<!-- /.row -->
</section>
<script type="text/javascript">
	$(document).ready(function() {

		var operForm = $("#operForm");

		$("button[data-oper='modify']").on("click", function(e) {

			operForm.attr("action", "/front/usermodify").submit();
			window.alert('수정 하였습니다');

		});

		$("button[data-oper='list']").on("click", function(e) {

			operForm.attr("action", "/front/userprofile")
			operForm.submit();

		});
	});
</script>
<%@include file="footer.jsp"%>
