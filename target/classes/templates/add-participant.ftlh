<#import "parts/common.ftlh" as c>

<@c.page>
<div>
    <form method="post">
        <span>Фамилия</span>
        <input type="text" name="lastName" />
        <span>Имя</span>
        <input type="text" name="firstName" />
        <span>Возраст</span>
        <input type="number" name="age" />
        <span>Пол</span>
        <select name="sex">
            <option value="MAN">М</option>
            <option value="WOMAN">Ж</option>
        </select>
        <span>Команда</span>
        <input type="text" name="team" />
        <span>Вес</span>
        <input type="number" name="weight" >
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>
</@c.page>