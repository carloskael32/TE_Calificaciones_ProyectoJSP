/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import java.util.List;



/**
 *
 * @author Carlos
 */
public interface EstudianteDAO {
    
    public void insert(Estudiante estudiante) throws Exception;
    public void update(Estudiante estudiante) throws Exception;
    public void delete(int id_estudiante) throws Exception;
    public Estudiante getById(int id_estudiante) throws Exception;
    public List<Estudiante> getAll() throws Exception;
    
    
}
