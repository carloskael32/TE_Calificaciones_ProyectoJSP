/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Materia;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface MateriaDAO {
       public void insert(Materia materia) throws Exception;
    public void update(Materia materia) throws Exception;
    public void delete(int id_materia) throws Exception;
    public Materia getById(int id_materia) throws Exception;
    public List<Materia> getAll() throws Exception;
}
