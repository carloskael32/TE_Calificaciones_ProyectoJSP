<%
    String opcion =  request.getParameter("opcion");
%>
            <ul class="nav justify-content-end  bg-light">
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("Docentes") ?  "active" : "") %>" href="DocenteControlador">Docentes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("Estudantes") ?  "active" : "") %>" href="EstudianteControlador">Estudantes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("Materias") ?  "active" : "") %>" href="MateriaControlador">Materias</a>
                </li>
                
                 <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("Notas") ?  "active" : "") %>" href="NotaControlador">Notas</a>
                </li>
                
                  <li class="nav-item">
                     <a href="Logout" class="btn btn-outline-danger"> Cerrar sesión</a>
                </li>
            </ul>