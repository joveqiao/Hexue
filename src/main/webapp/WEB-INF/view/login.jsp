﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>时光博客管理后台——系统登录</title>
<link href="<%=request.getContextPath() %>/resources/css/css.css"
	rel="stylesheet" type="text/css" />
<link rel="shortcut icon"
	href="<%=request.getContextPath() %>/resources/img/favicon.ico" />
<script src="<%=request.getContextPath() %>/resources/js/mysite.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/common/jquery.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/resources/common/formvalidator/formValidator-4.1.3.js"
	type="text/javascript" charset="UTF-8"></script>
<script
	src="<%=request.getContextPath() %>/resources/common/formvalidator/formValidatorRegex.js"
	type="text/javascript" charset="UTF-8"></script>
<script language="javascript"
	src="<%=request.getContextPath() %>/resources/common/formvalidator/DateTimeMask.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/resources/common/artDialog/jquery.artDialog.js?skin=default"></script>
<script language="javascript"
	src="<%=request.getContextPath() %>/resources/js/formval.js"
	type="text/javascript"></script>
<style type="text/css">
body {
	background:
		url('<%=request.getContextPath() %>/resources/images/viitobg.jpg')
		no-repeat fixed center top;
}
</style>
</head>

<body>
	<div class="viito_top">
		<div class="viito_title">
			<div class="welcome">
				<span>时光博客系统管理后台</span>
			</div>
			<div class="return">
				<ul>
					<li><a href="">网站首页</a></li>
					<li><a href="">帮助中心</a></li>
					<li><a href="">新浪微博</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="loginbg">
		<div class="loginFra">

			<div class="login">
				<div class="logo">
					<img
						src="<%=request.getContextPath() %>/resources/images/TimeBlogLogo1.gif" />
				</div>
				<div class="logins">
					<div class="iframe"></div>
					<div class="logincon">
						<div class="login_content">
							<form id="form1" method="post"
								action="<%=request.getContextPath() %>/site/login">
								<ul>
									<li><span>用户登录<var>UserLogin</var></span></li>
									<li><input style="width: 260px;" class="input"
										name="userName" id="userName" type="text" value="手机/邮箱" /></li>
									<li style="padding-top: 5px;"><input
										style="width: 260px; display: none;" class="input"
										type="password" value="" name="userPwd" id="userPwd" /> <input
										style="width: 260px;" class="input" type="text" value="请输入密码"
										name="userPwd_text" id="userPwd_text" /></li>
									<li style="padding-top: 5px;"><input value="忽略大小写"
										id="ymz" name="yzm" class="input"
										style="width: 120px; float: left;" /><img alt="请在旁边输入验证码信息"
										id="verifyCodeImg" onclick="changeVerifyCode();"
										style="cursor: pointer; vertical-align: middle; height: 38px; float: left; margin-left: 20px;"
										src="<%=request.getContextPath() %>/site/verifyImage" /></li>
									<li style="height: 70px; padding-top: 20px;"><input
										type="submit" value="" name="logins" class="submitbtn" />&nbsp;
										<label><input type="checkbox"
											style="vertical-align: middle" />记住账号</label>&nbsp;&nbsp; <a href="">忘记密码？</a></li>
								</ul>
								<script language="javascript">
								$("input").focus(function(){
									$(this).removeClass("input");
								    $(this).addClass("inputfocus");
								}).blur(function(){
								    $(this).removeClass("inputfocus");
								    $(this).addClass("input");
								});
								$("#userName").focus(function(){
									if($(this).val() == "手机/邮箱")$(this).val("");
						        }).blur(function(){
						        	if($(this).val() == "")$(this).val("手机/邮箱");
						        });
								$("#ymz").focus(function(){
									if($(this).val() == "忽略大小写")$(this).val("");
						        }).blur(function(){
						        	if($(this).val() == "")$(this).val("忽略大小写");
						        });
								//密码提示部分
								$("#userPwd").blur(function(){
									if($(this).val()==""){
									    $(this).hide();
									    $('#userPwd_text').show();
									    $('#userPwd_text').val("请输入密码");
									}
								});
								$("#userPwd_text").focus(function(){
									$(this).removeClass("inputfocus");
								    $(this).addClass("input");
									if($(this).val()!="请输入密码")$(this).val("请输入密码");
								    $(this).hide();
								    $('#userPwd').show();
								    $('#userPwd').val("");
								    $('#userPwd').focus();
								});
							</script>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="footer">
		<div class="footer1">
			<ul>
				<li><a href="">关于我们</a></li>
				<li><a href="">加盟条件</a></li>
				<li><a href="">官方微博</a></li>
				<li><a href="">客户服务</a></li>
				<li><a href="">商务合作</a></li>
				<li><a href="">隐私政策</a></li>
				<li>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;时光科技公司版权所有@2013
					蜀ICP备XXXXXXX号-1</li>
			</ul>
		</div>
	</div>
</body>

</html>
