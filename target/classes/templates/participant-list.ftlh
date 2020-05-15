<#import "parts/common.ftlh" as c>

<@c.page>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Фамилия</th>
        <th scope="col">Имя</th>
        <th scope="col">Возраст</th>
        <th scope="col">Пол</th>
        <th scope="col">Команда</th>
        <th scope="col">Вес</th>
    </tr>
    </thead>
    <tbody>
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
    </tbody>
</table>
</@c.page>