<#import "parts/common.ftlh" as c>

<@c.page>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Выйти"/>
    </form>
</div>
<table border="1">
    <caption>Список участников</caption>
    <tr>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Возраст</th>
        <th>Пол</th>
        <th>Команда</th>
        <th>Вес</th>
    </tr>
<#list participants as participant>
    <tr>
        <td>${participant.lastName!""}</td>
        <td>${participant.firstName!""}</td>
        <td>${participant.age!""}</td>
        <td>${participant.sex!""}</td>
        <td>${participant.team!""}</td>
        <td>${participant.weight!""}</td>
    </tr>
    <#else>
    Список участников пуст
</#list>
</table>
</@c.page>