<#import "parts/common.ftlh" as c>

<@c.page>
<b>User editor</b>
<form action="/user" method="post">
    <input type="text" name="username" value="${user.username}">
    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
    </div>
</#list>
<input type="hidden" name="userId" value="${user.id}">
<input type="hidden" name="_csrf" value="${_csrf.token}">
<div class="form-group row">
    <label class="col-sm-2 col-form-label">Пароль:</label>
    <div class="col-sm-4">
        <input type="password" name="password" class="form-control" placeholder="Пароль"/>
    </div>
</div>
<button class="btn btn-primary" type="submit">Save</button>
</form>

</@c.page>