<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@include file="header.jsp"%>
<script>
//썸네일 파일명을 가져오는 함수
function getThumbFileName(fullFilePath) {
   var arrString = fullFilePath.split("/");
   console.log(arrString);
   arrString.splice(-1, 1, "s_" + arrString[arrString.length - 1]);
   return arrString.join("/");
}
</script>
<section class="container">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">

				<h2 class="post-title">UserProfile</h2>
				<!-- /.panel-heading -->
				<div class="panel-body">

					<div class="form-group">
						<label>유저 아이디</label> <input class="form-control" name='id'
							value='<c:out value="${user.id }"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>유저 닉네임</label> <input class="form-control" name='username'
							value='<c:out value="${user.username }"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>이메일</label> <input class="form-control" name='email'
							value='<c:out value="${user.email }"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>유저 프로필사진</label>
						<div class="form-img">
							<img class="form-controller" src="/resources/upload/<c:out value="${user.profile_img }"/>"/>
						</div>
					</div>

					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name='profile'
							readonly="readonly"><c:out value="${user.profile}" /></textarea>
					</div>

					<div class="form-group">
						<label>Point</label> <input class="form-control" name='username'
							value='<c:out value="${user.point }"/>' readonly="readonly">
					</div>


					<sec:authentication property="principal" var="pinfo" />
					<sec:authorize access="isAuthenticated()">
						<c:if test="${pinfo.username eq user.id}">
							<button type="submit" data-oper='modify' class="btn btn-danger">Modify</button>
							<button type="submit" data-oper='made' class="btn btn-warning">MadeQuiz</button>
						</c:if>
					</sec:authorize>
					<button data-oper='list' class="btn btn-info">List</button>

					<form id='operForm' action="/front/usermodify" method="get">
						<input type='hidden' id='id' name='id'
							value='<c:out value="${user.id}"/>'>
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
//	var actionForm = $("#actionForm");

	//페이지 번호 클릭 이벤트
//	$(".paginate_button a").on("click", function(e) {
//		e.preventDefault();
		// console.log('click');
//		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
//		actionForm.submit();
//	});

	//상세보기 클릭 이벤트
//	$(".move").on(
//			"click",
//			function(e) {
//				e.preventDefault();
//				actionForm.append("<input type='hidden' name='id' value='"
//						+ $(this).attr("href") + "'>");
//				actionForm.attr("action", "/front/userprofile");
//				actionForm.submit();
//			});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		var operForm = $("#operForm");

		$("button[data-oper='modify']").on("click", function(e) {

			operForm.attr("action", "/front/usermodify").submit();

		});

		$("button[data-oper='made']").on("click", function(e) {

			operForm.attr("action", "/front/userMadequiz").submit();

		});

		$("button[data-oper='list']").on("click", function(e) {

			operForm.find("#id").remove();
			operForm.attr("action", "/front/rank")
			operForm.submit();

		});
	});
</script>
<%@include file="footer.jsp"%>
