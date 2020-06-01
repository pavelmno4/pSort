<#import "parts/common.ftlh" as c>

<@c.page>

<div><a href="/registration">Add new user</a></div>

<p>List of users</p>

<table class="table">
    <thead class="thead-light">
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/user/${user.id}">edit</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>