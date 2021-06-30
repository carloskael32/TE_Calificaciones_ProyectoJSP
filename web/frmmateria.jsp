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

        <title>Estudiantes</title>
        
           <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="#" />
            </jsp:include>
    </head>
    <body>
        <div class="container col-5">
            <h1 align="center">Formulario de Materias</h1>

            <br>
            <form action="MateriaControlador" method="post" >

                <input type="hidden" class="form-control" name="id_materia" value="${materia.id_materia}">


                <div class="form-group">
                    <label for="" class="form-label">Materia</label>
                    <input type="text" class="form-control" name="materia" value="${materia.materia}" placeholder="Ingrese una Materia">                    
                </div>

                <br>
                <button type="submit" class="btn btn-success">Guardar</button>
                <a href="MateriaControlador" class="btn btn-primary "> Atras</a>
            </form>
                         
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>
