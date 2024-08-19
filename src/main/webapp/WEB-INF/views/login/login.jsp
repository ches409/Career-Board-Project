<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
	<script src="resources/js/login.js"></script>
    <link rel="stylesheet" href="resources/css/login.css">
</head>
<body>
<div id="container">
    <div id="logo">직장IN</div>
    <form action="loginProcess" method="POST" >
        <div class="input-section">
            <label for="user_id" hidden="hidden">아이디</label>
            <input type="text" name="user_id" id="user_id" placeholder="아이디"/>
            <label for="password" hidden="hidden">비밀번호</label>
            <input type="password" name="password" id="password" placeholder="비밀번호"/>
            <div class="options">
                <label>
                    <input type="checkbox" id="saveId">
                    아이디 저장
                </label>
            </div>
        </div>
        <button type="submit" id="login-button">로그인</button>
    </form>

    <div id="help-links">
        <a href="#">아이디 찾기</a>
        <a href="#">비밀번호 찾기</a>
        <a href="#">회원가입</a>
    </div>
</div>
</body>
</html>
