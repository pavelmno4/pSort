<#import "parts/common.ftlh" as c>

<@c.page>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Выйти"/>
    </form>
</div>
<div>Список участников</div>
    {{#participants}}
    <div>
        <span>{{lastName}}</span>
        <span>{{firstName}}</span>
        <span>{{age}}</span>
        <span>{{sex}}</span>
        <span>{{team}}</span>
        <span>{{weight}}</span>
    </div>
    {{/participants}}
</@c.page>