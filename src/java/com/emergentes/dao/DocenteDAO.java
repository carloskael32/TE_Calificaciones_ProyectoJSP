/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Docente;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface DocenteDAO {
    
      public void insert(Docente docente) throws Exception;
    public void update(Docente docente) throws Exception;
    public void delete(int id_docente) throws Exception;
    public Docente getById(int id_docente) throws Exception;
    public List<Docente> getAll() throws Exception;
    
    
}

 