/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.dao.NotaDAO;
import com.emergentes.dao.NotaDAOimpl;
import com.emergentes.modelo.Nota;
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
@WebServlet(name = "NotaControlador", urlPatterns = {"/NotaControlador"})
public class NotaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Nota not = new Nota();
            int id_nota;
            NotaDAO dao = new NotaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("nota", not);
                    request.getRequestDispatcher("frmnota.jsp").forward(request, response);
                    break;
                case "edit":
                    id_nota = Integer.parseInt(request.getParameter("id_nota"));
                    not = dao.getById(id_nota);
                    request.setAttribute("nota", not);
                    request.getRequestDispatcher("frmnota.jsp").forward(request, response);
                    break;
                case "delete":
                    id_nota = Integer.parseInt(request.getParameter("id_nota"));
                    dao.delete(id_nota);
                    response.sendRedirect("NotaControlador");
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Nota> lista = dao.getAll();
                    request.setAttribute("notas", lista);
                    request.getRequestDispatcher("notas.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_nota = Integer.parseInt(request.getParameter("id_nota"));

        int id_docente = Integer.parseInt(request.getParameter("id_docente"));
        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
        int id_materia = Integer.parseInt(request.getParameter("id_materia"));
        int nota_1 = Integer.parseInt(request.getParameter("nota_1"));
        int nota_2 = Integer.parseInt(request.getParameter("nota_2"));
        int nota_3 = Integer.parseInt(request.getParameter("nota_3"));
        int nota_4 = Integer.parseInt(request.getParameter("nota_4"));
        int nota_final = Integer.parseInt(request.getParameter("nota_final"));

        Nota not = new Nota();

        not.setId_nota(id_nota);
        not.setId_docente(id_docente);
        not.setId_estudiante(id_estudiante);
        not.setId_materia(id_materia);
        not.setNota_1(nota_1);
        not.setNota_2(nota_2);
        not.setNota_3(nota_3);
        not.setNota_4(nota_4);
        not.setNota_final(nota_final);

        NotaDAO dao = new NotaDAOimpl();
        if (id_nota == 0) {
            try {
                // Nuevo registro
                dao.insert(not);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            try {
                // Edicion de registro
                dao.update(not);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("NotaControlador");
    }

}
