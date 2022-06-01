<!DOCTYPE html>
<html>
    <head>
        <title>Exemplo: requisição</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Preencha o formulário seguinte.</div>
        <form action="${pageContext.request.contextPath}/do/projeto">
            <label for="id">Id:</label>
            <input type="text" name="id" id="id" />
            <label for="preco">Preço:</label>
            <input type="text" name="preco" id="preco" />
            <button>Enviar</button>
        </form>
    </body>
</html>