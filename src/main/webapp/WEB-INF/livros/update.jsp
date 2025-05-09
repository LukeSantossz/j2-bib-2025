<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Editar Livro</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Editar Livro</h1>
            <form action="/livros/update" method="post">
                <input type="hidden" name="id" value="${livro.id}" />
                <div>
                    <label class="form-label">Título</label>
                    <input type="text" class="form-control" name="titulo" value="${livro.titulo}" />
                </div>
                <div>
                    <label class="form-label">Gênero</label>
                    <select class="form-select" name="id_genero">
                        <c:forEach var="g" items="${generos}">
                            <option ${livro.genero.id == g.id ? "selected" : ""} value="${g.id}">${g.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label class="form-label">Autores</label>
                    <c:forEach var="a" items="${autores}">
                        <div class="form-check">
                            <input ${livro.autores.contains(a) ? "checked" : ""} type="checkbox" name="autores" value="${a.id}" class="form-check-input" />
                            <label class="form-check-label">${a.nome}</label>
                        </div>
                    </c:forEach>
                </div>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>