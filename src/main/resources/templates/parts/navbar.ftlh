<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">На главную</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <!-- Обработка этого пункта меню в разработке -->
                <a class="nav-link" href="/">Скачать положение</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="/add-participant">Добавить участника</a>
            </li>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/participant-list">Список участинков</a>
            </li>
            </#if>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">Пользователи</a>
            </li>
            </#if>
            <li class="nav-item">
                <!-- Обработка этого пункта меню в разработке -->
                <a class="nav-link" href="/">Контакты</a>
            </li>
        </ul>

    <div class="navbar-text mr-3"><#if user??>${name}</#if></div>
        <@l.logout />
    </div>
</nav>