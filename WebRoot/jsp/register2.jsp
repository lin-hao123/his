<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>主页</title>
    <link href="${pageContext.request.contextPath}/static/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/ie-emulation-modes-warning.js"></script>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">医院信息系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">${loginDoctor.name }</a></li>
            <li><a href="${pageContext.request.contextPath}/doctor/loginout">退出</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="${pageContext.request.contextPath}/department/list">科室管理</a></li>
            <li><a href="${pageContext.request.contextPath}/doctor/list">权限管理 </a></li>
            <li><a href="${pageContext.request.contextPath}/register/list">挂号管理</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/register/list2">收费管理<span class="sr-only">(current)</span></a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">收费管理</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>编号</th>
                  <th>社会保障卡号</th>
                  <th>挂号日期</th>
                  <th>医生编号</th>
                  <th>医生姓名</th>
                  <th>医生挂号费</th>
                  <th>是否缴费</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="v" items="${list}" >
				<tr>
				  <td>${v.id==null?'&nbsp;':v.id }</td>
				  <td>${v.number==null?'&nbsp;':v.number }</td>
				  <td>${v.date==null?'&nbsp;':v.date }</td>
				  <td>${v.doctor.id==null?'&nbsp;':v.doctor.id }</td>
				  <td>${v.doctor.name==null?'&nbsp;':v.doctor.name }</td>
				  <td>${v.doctor.fee==null?'&nbsp;':v.doctor.fee }</td>
				  <td>${v.ispaid==null?'&nbsp;':v.ispaid==0?'未缴费':v.ispaid==1?'已缴费':'未知' }</td>
				  <td><a href="${pageContext.request.contextPath}/register/update/${v.id==null?'&nbsp;':v.id }">缴费</a></td>
				</tr>
			  </c:forEach>
              </tbody>
            </table>
          </div>
          
          <div style="float: right">
			<nav aria-label="Page navigation">
			  <ul class="pagination">
			  	
				<c:choose>
				<c:when test="${pageIndex == 1}">
				<li class="disabled">
			      <span>
			        <span aria-hidden="true">&laquo;</span>
			      </span>
			    </li>
				</c:when>
				<c:otherwise>
				<li>
			      <a href="javascript:checkPrevious()" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
				</c:otherwise>
				</c:choose>
			    
			    <c:forEach items="${listStringPage }" var="varPage" varStatus="varStatusPage">
			    <c:choose>
				<c:when test="${pageIndex == varStatusPage.count}">
				<li class="active">
			      <span>${varPage } <span class="sr-only">(current)</span></span>
			    </li>
				</c:when>
				<c:otherwise>
				<li><a href="javascript:checkPageIndex('${varPage }')">${varPage }</a></li>
				</c:otherwise>
				</c:choose>
			    </c:forEach>
			    
			    <c:choose>
				<c:when test="${pageIndex == pageCount || fn:length(list) lt 1}">
				<li class="disabled">
			      <span>
			        <span aria-hidden="true">&raquo;</span>
			      </span>
			    </li>
				</c:when>
				<c:otherwise>
				<li>
			      <a href="javascript:checkNext()" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
				</c:otherwise>
				</c:choose>
			  </ul>
			</nav>
			<form id="pageQuery" action="${pageContext.request.contextPath}/register/list2" method="post">
			  <input type="hidden" id="strPageIndex" name="strPageIndex" value="${pageIndex}" />
			  <input type="hidden" id="strPageSize" name="strPageSize" value="${pageSize}" />
			</form>
			<script type="text/javascript">
				function checkPrevious(){
					$("#strPageIndex").val(parseInt($("#strPageIndex").val()) - 1);
					checkForm(); 
				}
				function checkPageIndex(pageIndex){
					$("#strPageIndex").val(parseInt(pageIndex));
					checkForm(); 
				}
				function checkNext(){
					$("#strPageIndex").val(parseInt($("#strPageIndex").val()) + 1);
					checkForm(); 
				}
				function checkForm(){
					$("#pageQuery").submit(); 
				}
			</script>
		  </div>
          
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/static/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${pageContext.request.contextPath}/static/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/static/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>