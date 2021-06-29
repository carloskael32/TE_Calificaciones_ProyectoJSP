/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Nota;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface NotaDAO {
    public void insert(Nota nota) throws Exception;
    public void update(Nota nota) throws Exception;
    public void delete(int id_nota) throws Exception;
    public Nota getById(int id_nota) throws Exception;
    public List<Nota> getAll() throws Exception;
}
