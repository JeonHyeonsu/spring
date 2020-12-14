<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="header.jsp"%>
<section class="container">
    <div class="row">
        <div class="col-md-10 offset-md-1 post-content">
            <h2 class="post-title">Ranking</h2>
            <article class="full-article-body">
                <!-- /.panel-heading -->

         	<table class="table table-striped table-bordered table-hover">
               <thead>
                  <tr>
                     <th>#번호</th>
                     <th>퀴즈 질문</th>
                     <th>정답</th>
                     <th>퀴즈타입</th>
                     <th>작성자</th>
                     <th>등록일</th>
                     <th>수정일</th>
                  </tr>
               </thead>

               <c:forEach items="${quiz}" var="quiz">
                  <tr>
                     <td><c:out value="${quiz.quiz_idx}" /></td>
                     <td><a class='move' href='<c:out value="${quiz.quiz_idx}"/>'><c:out value="${quiz.question}" /></td>
                     <td><c:out value="${quiz.answer}" /></td>
                     <td><c:out value="${quiz.type_idx}" /></td>
                     <td><c:out value="${quiz.id}" /></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${quiz.reg_date}" /></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${quiz.updatedate}" /></td>
                  </tr>
               </c:forEach>
            </table>
            
            <!--  Pagination 시작 -->
            <div class='pull-left'>
               <ul class="pagination">
                  
                  <c:if test="${pageMaker.prev}">
                     <li class="paginate_button previous"><a href="${pageMaker.startPage -1}">Previous</a></li>
                  </c:if>

                  <c:forEach var="num" begin="${pageMaker.startPage}"   end="${pageMaker.endPage}">
                     <li class="paginate_button  ${pageMaker.cri.pageNum == num ? "active":""} ">
                        <a href="${num}">${num}</a>
                     </li>
                  </c:forEach>

                  <c:if test="${pageMaker.next}">
                     <li class="paginate_button next"><a href="${pageMaker.endPage +1 }">Next</a></li>
                  </c:if>

               </ul>
            </div>
            <!--  Pagination 끝 -->
            
            <!-- 페이징 Form 시작 -->
            <form id='actionForm' action="/front/rank" method='get'>
            <input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
            <input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
            <input type='hidden' name='type' value='<c:out value="${ pageMaker.cri.type }"/>'>
            <input type='hidden' name='keyword'   value='<c:out value="${ pageMaker.cri.keyword }"/>'>
            </form>
            <!-- 페이징 Form 끝 -->
            </article>
        </div>
    </div>
</section>
<script type="text/javascript">

var actionForm = $("#actionForm");

//페이지 번호 클릭 이벤트
$(".paginate_button a").on("click", function(e) {
   e.preventDefault();
   // console.log('click');
   actionForm.find("input[name='pageNum']").val($(this).attr("href"));
   actionForm.submit();
});

//상세보기 클릭 이벤트
$(".move").on("click",function(e) {
   e.preventDefault();
   actionForm.append("<input type='hidden' name='id' value='" + $(this).attr("href")   + "'>");
   actionForm.attr("action", "/front/userprofile");
   actionForm.submit();
});

</script>
<%@include file="footer.jsp"%>
