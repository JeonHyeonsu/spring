<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="header.jsp"%>
<section class="container">
    <div class="row">
        <div class="col-md-10 offset-md-1 post-content">
            <h2 class="post-title">日本語クイズ</h2>
            <article class="full-article-body">
                <!-- /.panel-heading -->

         	<table class="table table-striped table-bordered table-hover">
                <c:forEach items="${quiz}" var="quiz">
                <div>
                <c:out value="${quiz.question}" /></br></br>
                </div>
                
                <div>
                <li>
                <button class="btnimg btnsize" ><input type="hidden" data-oper='question' name="question" value="jp0" >&nbsp;<img src="/resources/img/1.PNG"></button> : <span id="quiz0"></span></input>
                </li>
                
                <li>
                <input type="hidden" data-oper='question' name="question"><button class="btnimg btnsize" >&nbsp;<img src="/resources/img/2.PNG"></button> : <span id="quiz1"></span></input>
                </li>
                
                <li>
                <input type="hidden" data-oper='question' name="question"><button class="btnimg btnsize" >&nbsp;<img src="/resources/img/3.PNG"></button> : <span id="quiz2"></span></input>
                </li>
                
                <li>
                <input type="hidden" data-oper='question' name="question"><button class="btnimg btnsize" >&nbsp;<img src="/resources/img/4.PNG"></button> : <span id="quiz3"></span></input>
                </li>
                </div>
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
            <form id='actionForm' action="/front/quiz_jp" method='get'>
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

var quizArray = new Array();
<c:forEach items="${quiz}" var="quiz">

quizArray[0] = '${quiz.answer}';
quizArray[1] = '${quiz.example1}';
quizArray[2] = '${quiz.example2}';
quizArray[3] = '${quiz.example3}';
</c:forEach>
/* const shuffleArray = arr => arr.sort(() => Math.random() - 0.5); */


const shuffleArray = arr => arr
.map(a => [Math.random(), a])
.sort((a, b) => a[0] - b[0])
.map(a => a[1]);

var arr_shuffle = shuffleArray(quizArray);
console.log(shuffleArray(quizArray));

var str = [];
for(var i = 0; i < 4; i++ ){
	str += arr_shuffle[i];
	document.getElementById("quiz"+ [i]).innerHTML = str;
	str = [];
}

$("button[data-oper='question']").on("click", function(e) {
	var answer = document.getElementById("question").value;
	console.log(answer);

});



</script>
<%@include file="footer.jsp"%>
