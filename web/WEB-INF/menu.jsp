<%
    String opcion =  request.getParameter("opcion");
%>
            <ul class="nav nav-tabs">
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
            </ul>