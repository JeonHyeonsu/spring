<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@include file="../includes/header.jsp"%>
<div class="row">
   <div class="col-lg-12">
      <h1 class="page-header">Tables</h1>
   </div>
   <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
         <div class="panel-heading">
            Board List Page
            <button id='regBtn' type="button" class="btn btn-xs pull-right">Register
               New Board</button>
         </div>

         <!-- /.panel-heading -->
         <div class="panel-body">
         	<table class="table table-striped table-bordered table-hover">
               <h3>넌센스 퀴즈</h3>

                <c:forEach items="${quiz}" var="quiz">
                <div>
                <c:out value="${quiz.question}" /></br></br>
                </div>
                <div>
                <input type="radio" name="answer"><c:out value="${quiz.answer}" /></input></br>
                <input type="radio" name="answer"><c:out value="${quiz.example1}" /></input></br>
                <input type="radio" name="answer"><c:out value="${quiz.example2}" /></input></br>
                <input type="radio" name="answer"><c:out value="${quiz.example3}" /></input>
                </div>


               </c:forEach>
               
            </table>
            <!-- <table class="table table-striped table-bordered table-hover">
               <thead>
                  <tr>
                     <th>#번호</th>
                     <th>퀴즈명</th>
                     <th>정답</th>
                     <th>작성자</th>
                     <th>작성일</th>
                     <th>수정일</th>
                  </tr>
               </thead>

                <c:forEach items="${quiz}" var="quiz">
                  <tr>
                     <td><c:out value="${quiz.quiz_idx}" /></td>
                     <td><a class='move' href='<c:out value="${quiz.quiz_idx}"/>'><c:out value="${quiz.question}" />
                     </a> </td>
                     <td><c:out value="${quiz.id}" /></td>
                 
                  </tr>
               </c:forEach>
               
            </table>-->
            
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
            <form id='actionForm' action="/front/quiz_jp" method='get'>
            <input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
            <input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
            <input type='hidden' name='type' value='<c:out value="${ pageMaker.cri.type }"/>'>
            <input type='hidden' name='keyword'   value='<c:out value="${ pageMaker.cri.keyword }"/>'>
            </form>
            <!-- 페이징 Form 끝 -->
            
         
         <!-- Modal  추가 -->
         <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
            aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
               <div class="modal-content">
                  <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</button>
                     <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                  </div>
                  <div class="modal-body">처리가 완료되었습니다.</div>
                  <div class="modal-footer">
                     <button type="button" class="btn btn-default"
                        data-dismiss="modal">Close</button>
                     <button type="button" class="btn btn-primary" data-dismiss="modal">Save
                        changes</button>
                  </div>
               </div>
               <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
         </div>
         <!-- /.modal -->
         
      </div>
      <!--  end panel-body -->
   </div>
   <!-- end panel -->
</div>
</div>
<!-- /.row -->

<script type="text/javascript">
   $(document).ready(function() {
      var result = '<c:out value="${result}"/>';
      
      checkModal(result);
      // replaceState(data, title [, url ]) 히스토리를 수정
      history.replaceState({}, null, null);

      function checkModal(result) {
         // alert(history.state);
         // 글 등록 후 리스트 화면에서 model창이 나온 뒤 새로고침을 해도 model창이 안나오도록
         // result값 체크
         // result값은 controller에서 넘어온 1회성 값으로 페이지를 다시 읽으면 null이된다.
         // history.state 는 조회에서 back 했을때 history객체의 현재 정보를 읽어 값이 있다면 
         // modal창을 띄우지 않는다.
         if (result === '' || history.state) {
            return;
         }

         if (parseInt(result) > 0) {
            $(".modal-body").html("게시글 " + parseInt(result)   + " 번이 등록되었습니다.");
         }

         $("#myModal").modal("show");
      }
      
      $("#regBtn").on("click", function() {
         self.location = "/admin/register";
      });
      
      var actionForm = $("#actionForm");

      // 페이지 번호 클릭 이벤트
      $(".paginate_button a").on("click", function(e) {
         e.preventDefault();
         // console.log('click');
         actionForm.find("input[name='pageNum']").val($(this).attr("href"));
         actionForm.submit();
      });
      
      // 상세보기 클릭 이벤트
      $(".move").on("click",function(e) {
         e.preventDefault();
         actionForm.append("<input type='hidden' name='bno' value='" + $(this).attr("href")   + "'>");
         actionForm.attr("action", "/admin/get");
         actionForm.submit();
      });
      
      // 검색 버튼 클릭 이벤트
      var searchForm = $("#searchForm");
      $("#searchForm button").on("click",   function(e) {
         if (!searchForm.find("option:selected").val()) {
            alert("검색종류를 선택하세요");
            return false;
         }

         if (!searchForm.find("input[name='keyword']").val()) {
            alert("키워드를 입력하세요");
            return false;
         }
         
         searchForm.find("input[name='pageNum']").val("1");
         e.preventDefault();
         searchForm.submit();
      });
   });
</script>

<%@include file="../includes/footer.jsp"%>