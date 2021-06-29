/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.dao.EstudianteDAO;
import com.emergentes.dao.EstudianteDAOimpl;
import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "EstudianteControlador", urlPatterns = {"/EstudianteControlador"})
public class EstudianteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Estudiante est = new Estudiante();
            int id_estudiante;
            EstudianteDAO dao = new EstudianteDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
                    est = dao.getById(id_estudiante);
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "delete":
                    id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
                    dao.delete(id_estudiante);
                    response.sendRedirect("EstudianteControlador");
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Estudiante> lista = dao.getAll();
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
        int id_docente = Integer.parseInt(request.getParameter("id_docente"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int ci = Integer.parseInt(request.getParameter("ci"));
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        String correo = request.getParameter("correo");

        Estudiante doc = new Estudiante();
        doc.setId_estudiante(id_estudiante);
        doc.setCi(ci);
        doc.setId_docente(id_docente);
        doc.setNombres(nombres);
        doc.setApellidos(apellidos);
        doc.setTelefono(telefono);
        doc.setCorreo(correo);

        EstudianteDAO dao = new EstudianteDAOimpl();
        if (id_estudiante == 0) {
            try {
                // Nuevo registro
                dao.insert(doc);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            try {
                // Edicion de registro
                dao.update(doc);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("EstudianteControlador");
    }

}
