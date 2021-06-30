<%
     if (session.getAttribute("login") != "OK"){
        response.sendRedirect("login.jsp");
    }
%>
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

        <title>Lista de Notas</title>
        
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="notas" />
            </jsp:include>
        
    </head>
    <body>
        <div class="container">
            <h1 align="center">Notas</h1>
      
            <br>
            <a href="NotaControlador?action=add" class="btn btn-primary btn-sm"><i class="fas fa-plus-circle"></i> Nuevo </a>
            <table class="table table-striped">
                <tr>
                    <th>Id_nota</th>
                    <th>Ci_docente</th>
                    <th>Ci_estudiante</th>
                    <th>Id_materia</th>
                    <th>1er Examen</th>
                    <th>2er Examen</th>
                    <th>3er Examen</th>
                    <th>4er Examen</th>
                    <th>Nota Final</th>
                    
                    <th colspan="2"></th>
                 
                </tr>
                <c:forEach var="item" items="${notas}">
                    <tr>
                        <td>${item.id_nota}</td>
                        <td>${item.id_docente}</td>
                        <td>${item.id_estudiante}</td>
                        <td>${item.materia}</td>
                        <td>${item.nota_1}</td>
                        <td>${item.nota_2}</td>
                        <td>${item.nota_3}</td>
                        <td>${item.nota_4}</td>
                        <td>${item.nota_final}</td>
                        
                    
                        <td><a href="NotaControlador?action=edit&id_nota=${item.id_nota}"><i class="fas fa-edit"></i></a></td>
                        <td><a href="NotaControlador?action=delete&id_nota=${item.id_nota}" onclick="return(confirm('Esta seguro ???'))">
                                <i class="fas fa-trash-alt"></i>
                            </a>
                        </td>
                    </tr>                    
                </c:forEach>
            </table>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>
