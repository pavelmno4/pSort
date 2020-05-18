<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>pSort</title>
    <link rel="stylesheet" href="/static/style.css" >

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col">
            <table class="table-bordered">
                <thead></thead>
                <tbody>
                <#list participants as participant>
                <tr>
                    <td><b>${participant.lastName!""} ${participant.firstName!""}</b><p>${participant.team!""}</p></td>
                </tr>
                <#else >
                Список пуст
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col">

        </div>
        <div class="col">

        </div>
    </div>
</div>
</body>
