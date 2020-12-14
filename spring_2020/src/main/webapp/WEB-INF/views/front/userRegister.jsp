<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="header.jsp"%>
<section class="container">
	<div class="row">
		<div class="col-md-10 offset-md-1 post-content">
			<h2 class="post-title">퀴즈 제작</h2>
			<article class="full-article-body">
				<!-- /.panel-heading -->
				<form role="form" action="/front/userRegister" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

					<div class="form-group">
						<label>문제</label> <input class="form-control" name='question'>
					</div>

					<div class="form-group">
						<label>정답</label> <input class="form-control" name='answer'>
					</div>

					<div class="form-group">
						<label>보기1</label> <input class="form-control" name='example1'>
					</div>

					<div class="form-group">
						<label>보기2</label> <input class="form-control" name='example2'>
					</div>

					<div class="form-group">
						<label>보기3</label> <input class="form-control" name='example3'>
					</div>

					<div class="form-group">
						<label>퀴즈 타입</label></br> 
						<input type="radio" value="1" name='type_idx'>일본어 퀴즈</input></br> 
						<input type="radio" value="2" name='type_idx'>넌센스 퀴즈</input></br> 
						<input type="radio" value="3" name='type_idx'>상식 퀴즈</input></br>
					</div>

					<div class="form-group">
						<label>ID</label> <input class="form-control" name='id'
							value='<sec:authentication property="principal.username"/>'
							readonly="readonly">
					</div>

					<button type="submit" class="btn btn-success">Submit
						Button</button>
					<button type="reset" class="btn btn-danger">Reset Button</button>
				</form>
				</article>
		</div>
	</div>
</section>
<script type="text/javascript">

</script>
<%@include file="footer.jsp"%>
