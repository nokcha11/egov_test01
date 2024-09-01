<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/egovframework/login.css"/>
<title>Insert title here</title>
<script type="text/javascript">
	function fn_createAccount(){
		var frm = $("#frm");
		frm.attr("action","/join.do");
		frm.submit();
	}
</script>
</head>
<body>
<form id="frm" name="frm">

	<table>
	    <tr>
	        <td><h2>로그인</h2></td>
	    </tr>
	    <tr>
	        <td><input type="text" placeholder="ID"></td>
	    </tr>
	    <tr>
	        <td><input type="password" placeholder=Password></td>
	    </tr>
	    <tr>
	       <td><input type="checkbox"> 로그인 정보 저장</td>
	    </tr>
	   <tr>
	        <td><input type="submit" value="Sign in" class="btn" onclick="alert('로그인 성공!')"></td>
	    </tr>
	    <tr>
	        <td class="join"><a href="javascript:fn_createAccount();">회원가입</a></td>
	    </tr>
	</table>
</form>
</body>
</html>