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

       
        <title>Estudiantes</title>
        
           <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="#" />
            </jsp:include>
    </head>
    <body>
        <div class="container col-5">
            <h1 align="center">Formulario de Estudiantes</h1>

            <br>
            <form action="EstudianteControlador" method="post" >
         
                    <input type="hidden" class="form-control" name="id_estudiante" value="${estudiante.id_estudiante}">
        
     
                <div class="form-group">
                    <label for="" class="form-label">Ci Docente</label>
                    <select name="id_docente" class="form-control">
                        
                        <option value=""> -- Seleccione -- </option>
                        
                       <c:forEach var="item" items="${lista_docentes}">
                           
                            <option value="${item.id_docente}">${item.ci} | ${item.nombres} </option>
         
                        </c:forEach>
                    </select>
                </div>
          
                            

                    
                <div class="form-group">
                    <label for="" class="form-label">Nombres</label>
                    <input type="text" class="form-control" name="nombres" value="${estudiante.nombres}" placeholder="Escriba sus nombres">                    
                </div>

                <div class="form-group">
                    <label for="" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" name="apellidos" value="${estudiante.apellidos}" placeholder="Escriba sus apellidos">                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Nro. Carnet</label>
                    <input type="number" class="form-control" name="ci" value="${estudiante.ci}" placeholder="Escriba su Numero de Carnet">                    
             

                <div class="form-group">
                    <label for="" class="form-label">Telefono</label>
                    <input type="number" class="form-control" name="telefono" value="${estudiante.telefono}" placeholder="Escriba su telefono">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Correo electrónico</label>
                    <input type="email" class="form-control" name="correo" value="${estudiante.correo}" placeholder="Escriba su correo electrónico">                    
                </div>
         
         
                <br>
                  <button type="submit" class="btn btn-success">Guardar</button>
                <a href="EstudianteControlador" class="btn btn-primary "> Atras</a>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>
