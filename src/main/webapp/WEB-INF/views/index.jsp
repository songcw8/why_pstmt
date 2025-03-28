<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>반갑습니다.</title>
</head>
<body>
    <% String message = (String) request.getAttribute("message"); %>
    <%
        if(message == null){
    %>
        <h1>로그인 하세요</h1>
    <form action method="post">
        <label>
            유저이름: <input type="text" name="username">
        </label>
        <label>
            비밀번호: <input type="password" name="password">
        </label>
        <button>가입</button>
    </form>
    <%
        } else {
    %>
        <h1><%= request.getAttribute("message")%></h1>
    <%
        }
    %>
    <h1></h1>
    <header>
        <nav>
            <ul>
                <li>
                    <a href="join">가입</a>
                </li>
            </ul>
        </nav>
    </header>
</body>
</html>
