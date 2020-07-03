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
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/static/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/signin.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/ie-emulation-modes-warning.js"></script>
    <script src="${pageContext.request.contextPath}/static/jquery.min.js"></script>
    <script type="text/javascript">
		// 显示信息
		function showMsg(msg){
			//$("#signinForm").append('<div class="alert alert-danger" role="alert"><strong>用户名不能为空</strong></div>');
			$("#strongMsg").text(msg);
			//$("#divMsg").attr("style","display:block;");
			//$("#divMsg").css("display","block");
			$("#divMsg").show();
		}
		
		function hideMsg(){
			$("#strongMsg").text("");
			$("#divMsg").hide();
		}
		
		function isEmpty(str){
			if(str != null && str != ""){
				return false;
			}
			return true;
		}
		
		// 验证用户名	JSON讲解[{id:"1",name:"综管部"},{id:"2",name:"药品部"}]
		function checkUsername(){
			var un = $("#username").val();
    		if(isEmpty(un))
    		{
    			showMsg("用户名不能为空");
    		}
    		else
    		{
    			hideMsg();
    			$.post({
        			url:"${pageContext.request.contextPath}/doctor/checkUsername",
        			data:{"username":un},
        			success:function(data){
        				if(data=="true")
        				{
        					// 用户名存在
        				}
        				else if(data=="false")
        				{
            				showMsg("用户名不存在");
        				}else
        				{
        					showMsg("系统繁忙");
        				}
        			}
        		})
    		}
    	}
		
		// 验证密码
		function checkPassword(){
    		if(isEmpty($("#password").val())){
    			showMsg("密码不能为空");
    		}else{
    			hideMsg();
    		}
    	}
    </script>
  </head>
  <body>
    <div class="container">
      <form id="signinForm" class="form-signin" action="${pageContext.request.contextPath}/doctor/login" method="post" >
        <h2 class="form-signin-heading">医院信息系统(v522)</h2>
        <label for="inputEmail" class="sr-only">账号</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="账号" required autofocus onblur="checkUsername()">
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="密码" required onblur="checkPassword()">
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="登录">
        <div id="divMsg" class="alert alert-danger" role="alert" style="display: none;">
          <strong id="strongMsg"></strong>
        </div>
        <c:if test="${msg == 0}">
		<div class="alert alert-danger" role="alert">
          <strong>用户名或密码不能为空</strong>
        </div>
		</c:if>
        <c:if test="${msg == 1}">
		<div class="alert alert-danger" role="alert">
          <strong>用户名或密码错误</strong>
        </div>
		</c:if>
      </form>
    </div>
    <script src="${pageContext.request.contextPath}/static/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>