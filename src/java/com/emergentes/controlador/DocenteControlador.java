/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.dao.DocenteDAO;
import com.emergentes.dao.DocenteDAOimpl;
import com.emergentes.modelo.Docente;
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
@WebServlet(name = "DocenteControlador", urlPatterns = {"/DocenteControlador"})
public class DocenteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Docente doc = new Docente();
            int id_docente;
            DocenteDAO dao = new DocenteDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("docente", doc);
                    request.getRequestDispatcher("frmdocente.jsp").forward(request, response);
                    break;
                case "edit":
                    id_docente = Integer.parseInt(request.getParameter("id_docente"));
                    doc = dao.getById(id_docente);
                    request.setAttribute("docente", doc);
                    request.getRequestDispatcher("frmdocente.jsp").forward(request, response);
                    break;
                case "delete":
                    id_docente = Integer.parseInt(request.getParameter("id_docente"));
                    dao.delete(id_docente);
                    response.sendRedirect("DocenteControlador");
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Docente> lista = dao.getAll();
                    request.setAttribute("docentes", lista);
                    request.getRequestDispatcher("docentes.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_docente = Integer.parseInt(request.getParameter("id_docente"));
        int ci = Integer.parseInt(request.getParameter("ci"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String pass = request.getParameter("pass");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        String correo = request.getParameter("correo");

        Docente doc = new Docente();
        
        doc.setId_docente(id_docente);
        doc.setCi(ci);
        doc.setNombres(nombres);
        doc.setApellidos(apellidos);
        doc.setPass(pass);
        doc.setTelefono(telefono);
        doc.setCorreo(correo);

        DocenteDAO dao = new DocenteDAOimpl();
        if (id_docente == 0) {
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
        response.sendRedirect("DocenteControlador");
    }

}
