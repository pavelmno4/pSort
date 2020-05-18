<#import "parts/common.ftlh" as c>

<@c.page>

<form method="get">
    <label class="label">Пол</label>
    <select class="select" name="sex">
        <option value="">---</option>
        <option value="MAN">М</option>
        <option value="WOMAN">Ж</option>
    </select>

    <label class="label">Возраст</label>
    <select class="select" name="ageInterval">
        <option value="">---</option>
        <option value="8-9">8-9</option>
        <option value="10-11">10-11</option>
        <option value="12-13">12-13</option>
        <option value="14-15">14-15</option>
        <option value="16-17">16-17</option>
    </select>

    <label class="label">Вес</label>
    <select class="select" name="weightCategory">
        <option value="">---</option>
        <option value="1-23">до 23</option>
        <option value="24-25">до 25</option>
        <option value="26-27">до 27</option>
        <option value="28-30">до 30</option>
        <option value="31-34">до 34</option>
        <option value="35-38">до 38</option>
        <option value="39-42">до 42</option>
        <option value="43-46">до 46</option>
        <option value="47-50">до 50</option>
        <option value="51-55">до 55</option>
        <option value="56-60">до 60</option>
        <option value="61-66">до 66</option>
        <option value="67-70">до 70</option>
        <option value="71-76">до 76</option>
        <option value="77-85">до 85</option>
        <option value="85-200">свыше 85</option>
    </select>
    <button class="btn btn-primary m-2" type="submit" formaction="/participant-list">Найти</button>
    <button class="btn btn-info m-2" type="submit" formaction="/table-creator">Создать</button>
</form>

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