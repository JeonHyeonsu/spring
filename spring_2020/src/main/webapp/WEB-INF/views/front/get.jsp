<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@include file="../includes/header.jsp"%>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Read   </h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Read Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group">
          <label>번호</label> <input class="form-control" name='quiz_idx'
            value='<c:out value="${quiz.quiz_idx }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>문제</label> <input class="form-control" name='question'
            value='<c:out value="${quiz.question }"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>정답</label> <input class="form-control" name='answer'
            value='<c:out value="${quiz.answer }"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>보기1</label> <input class="form-control" name='example1'
            value='<c:out value="${quiz.example1 }"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>보기2</label> <input class="form-control" name='example2'
            value='<c:out value="${quiz.example2 }"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>보기3</label> <input class="form-control" name='example3'
            value='<c:out value="${quiz.example3 }"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>퀴즈 타입</label> <input class="form-control" name='type_idx'
            value='<c:out value="${quiz.type_idx }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>ID</label> <input class="form-control" name='id'
            value='<c:out value="${quiz.id }"/>' readonly="readonly">
        </div>

<sec:authentication property="principal" var="pinfo"/>
<sec:authorize access="isAuthenticated()">
   <c:if test="${pinfo.username eq quiz.id}">
      <button data-oper='modify' class="btn btn-default">Modify</button>
   </c:if>
</sec:authorize>
<button data-oper='list' class="btn btn-info">List</button>

<form id='operForm' action="/boad/modify" method="get">
  <input type='hidden' id='quiz_idx' name='quiz_idx' value='<c:out value="${quiz.quiz_idx}"/>'>
  <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
  <input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
  <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
  <input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>  
</form>

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
  
  $("button[data-oper='modify']").on("click", function(e){
    
    operForm.attr("action","/front/quizmodify").submit();
    
  });
  
    
  $("button[data-oper='list']").on("click", function(e){
    
    operForm.find("#quiz_idx").remove();
    operForm.attr("action","/front/list2")
    operForm.submit();
    
  });  
});
</script>


<%@include file="../includes/footer.jsp"%>