<#import "parts/common.ftlh" as c>

<@c.page>
<head>
    <title>Login</title>
</head>
<body>
<form action="login" method="post">
    <div><label>Имя пользователя : <input type="text" name="username"/> </label></div>
    <div><label>Пароль : <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Войти"></div>
</form>
<a href="/registration">Add new user</a>
</body>
</@c.page>