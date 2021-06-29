/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Materia;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class MateriaDAOimpl extends ConexionDB implements MateriaDAO {

    @Override
    public void insert(Materia materia) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO materias (materia) values (?)");

            ps.setString(1, materia.getMateria());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Materia materia) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE materias SET materia=? where id_materia = ?");

            ps.setString(1, materia.getMateria());

            ps.setInt(2, materia.getId_materia());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_materia) throws Exception {
     try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM materias WHERE id_materia = ?");
            ps.setInt(1, id_materia);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Materia getById(int id_materia) throws Exception {
        Materia mat = new Materia();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM materias WHERE id_materia = ?");
            ps.setInt(1, id_materia);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                mat.setId_materia(rs.getInt("id_materia"));
                mat.setMateria(rs.getString("materia"));
                
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return mat;
    }

    @Override
    public List<Materia> getAll() throws Exception {
        
         List<Materia> lista = null;
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM materias");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Materia>();
            while (rs.next()) {
                Materia mat = new Materia();

              mat.setId_materia(rs.getInt("id_materia"));
                mat.setMateria(rs.getString("materia"));

                lista.add(mat);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
