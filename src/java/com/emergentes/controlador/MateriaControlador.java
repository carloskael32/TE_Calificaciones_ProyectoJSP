/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.dao.MateriaDAO;
import com.emergentes.dao.MateriaDAOimpl;
import com.emergentes.modelo.Materia;
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
@WebServlet(name = "MateriaControlador", urlPatterns = {"/MateriaControlador"})
public class MateriaControlador extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try {
            Materia mat = new Materia();
            int id_materia;
            MateriaDAO dao = new MateriaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("materia", mat);
                    request.getRequestDispatcher("frmmateria.jsp").forward(request, response);
                    break;
                case "edit":
                    id_materia = Integer.parseInt(request.getParameter("id_materia"));
                    mat = dao.getById(id_materia);
                    request.setAttribute("materia", mat);
                    request.getRequestDispatcher("frmmateria.jsp").forward(request, response);
                    break;
                case "delete":
                    id_materia = Integer.parseInt(request.getParameter("id_materia"));
                    dao.delete(id_materia);
                    response.sendRedirect("MateriaControlador");
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Materia> lista = dao.getAll();
                    request.setAttribute("materias", lista);
                    request.getRequestDispatcher("materias.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        
    }

    
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_materia = Integer.parseInt(request.getParameter("id_materia"));
        String materia = request.getParameter("materia");


        Materia mat = new Materia();
        
        mat.setId_materia(id_materia);
        mat.setMateria(materia);

       MateriaDAO dao = new MateriaDAOimpl();
        if (id_materia == 0) {
            try {
                // Nuevo registro
                dao.insert(mat);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            try {
                // Edicion de registro
                dao.update(mat);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("MateriaControlador");
       
    }


}
