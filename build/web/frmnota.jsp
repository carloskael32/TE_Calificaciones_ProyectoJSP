<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>Notas</title>

        <jsp:include page="WEB-INF/menu.jsp">
            <jsp:param name="opcion" value="#" />
        </jsp:include>
    </head>
    <body>
        <div class="container col-5">
            <h1 align="center">Formulario de Notas</h1>

            <br>
            <form action="NotaControlador" method="post" >

                <input type="hidden" class="form-control" name="id_nota" value="${nota.id_nota}">


                <div class="form-group">
                    <label for="" class="form-label">Ci Docente</label>
                    <select name="id_docente" class="form-control">

                        <option value=""> -- Seleccione -- </option>

                        <c:forEach var="item" items="${lista_docente}">

                            <option value="${item.id_docente}">${item.ci} | ${item.nombres} </option>

                        </c:forEach>
                    </select>
                </div>



                <div class="form-group">
                    <label for="" class="form-label">Ci Estudiante</label>
                    <select name="id_estudiante" class="form-control">

                        <option value=""> -- Seleccione -- </option>

                        <c:forEach var="item" items="${lista_estudiante}">

                            <option value="${item.id_estudiante}">${item.ci} | ${item.nombres} </option>

                        </c:forEach>
                    </select>
                </div>



                <div class="form-group">
                    <label for="" class="form-label">Ci Materia</label>
                    <select name="id_materia" class="form-control">

                        <option value=""> -- Seleccione -- </option>

                        <c:forEach var="item" items="${lista_materia}">

                            <option value="${item.id_materia}">${item.materia} </option>

                        </c:forEach>
                    </select>
                </div>




                <div class="form-group">
                    <label for="" class="form-label">1er Examen</label>
                    <input type="number" class="form-control" name="nota_1" value="${nota.nota_1}" placeholder="nota 1">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">2er Examen</label>
                    <input type="number" class="form-control" name="nota_2" value="${nota.nota_2}" placeholder="nota 2">                    
                </div>

                <div class="form-group">
                    <label for="" class="form-label">3er Examen</label>
                    <input type="number" class="form-control" name="nota_3" value="${nota.nota_3}" placeholder="nota 3">                    
                </div>


                <div class="form-group">
                    <label for="" class="form-label">Trabajos</label>
                    <input type="number" class="form-control" name="nota_4" value="${nota.nota_4}" placeholder="nota 4">                    
                </div>

                <div class="form-group">
                    <label for="" class="form-label">Nota Final</label>
                    <input type="number" class="form-control" name="nota_final" value="${nota.nota_final}" placeholder="nota final">                    
                </div>

                <br>
                <button type="submit" class="btn btn-success">Guardar</button>
                <a href="NotaControlador" class="btn btn-primary "> Atras</a>
            </form>
        </div>
        <br>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>
