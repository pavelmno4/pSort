<#import "parts/common.ftlh" as c>

<@c.page>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Фамилия:</label>
            <div class="col-sm-4">
                <input type="text" name="lastName" class="form-control" placeholder="Фамилия"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя:</label>
            <div class="col-sm-4">
                <input type="text" name="firstName" class="form-control" placeholder="Имя"/>
            </div>
        </div>
        <div>
            <label class="label mr-5">Пол:</label>
            <select class="mdb-select ml-5" name="sex">
                <option value="MAN">М</option>
                <option value="WOMAN">Ж</option>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Возраст:</label>
            <div class="col-sm-4">
                <input type="text" name="age" class="form-control" placeholder="12"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Вес:</label>
            <div class="col-sm-4">
                <input type="text" name="weight" class="form-control" placeholder="42"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Команда:</label>
            <div class="col-sm-4">
                <input type="text" name="team" class="form-control" placeholder="Спарта"/>
            </div>
        </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Добавить</button>
    </form>
</@c.page>