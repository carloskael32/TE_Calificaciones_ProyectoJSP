/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Nota;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class NotaDAOimpl extends ConexionDB implements NotaDAO {
    
    @Override
    public void insert(Nota nota) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO notas (id_docente,id_estudiante,id_materia,nota_1,nota_2,nota_3,nota_4,nota_final) values (?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, nota.getId_docente());
            ps.setInt(2, nota.getId_estudiante());
            ps.setInt(3, nota.getId_materia());
            ps.setInt(4, nota.getNota_1());
            ps.setInt(5, nota.getNota_2());
            ps.setInt(6, nota.getNota_3());
            ps.setInt(7, nota.getNota_4());
            ps.setInt(8, nota.getNota_final());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
    @Override
    public void update(Nota nota) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE notas SET id_docente=?,id_estudiante=?,id_materia=?,nota_1=?,nota_2=?,nota_3=?,nota_4=?,nota_final=? where id_nota = ?");
            
            ps.setInt(1, nota.getId_docente());
            ps.setInt(2, nota.getId_estudiante());
            ps.setInt(3, nota.getId_materia());
            ps.setInt(4, nota.getNota_1());
            ps.setInt(5, nota.getNota_2());
            ps.setInt(6, nota.getNota_3());
            ps.setInt(7, nota.getNota_4());
            ps.setInt(8, nota.getNota_final());
            
            ps.setInt(9, nota.getId_nota());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
    @Override
    public void delete(int id_nota) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM notas WHERE id_nota = ?");
            ps.setInt(1, id_nota);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
    @Override
    public Nota getById(int id_nota) throws Exception {
        Nota not = new Nota();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM notas WHERE id_nota = ?");
            ps.setInt(1, id_nota);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                not.setId_nota(rs.getInt("id_nota"));
                not.setId_docente(rs.getInt("id_docente"));
                not.setId_estudiante(rs.getInt("id_estudiante"));
                not.setId_materia(rs.getInt("id_materia"));
                not.setNota_1(rs.getInt("nota_1"));
                not.setNota_2(rs.getInt("nota_2"));
                not.setNota_3(rs.getInt("nota_3"));
                not.setNota_4(rs.getInt("nota_4"));
                not.setNota_final(rs.getInt("nota_final"));
                
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return not;
    }
    
    @Override
    public List<Nota> getAll() throws Exception {
        List<Nota> lista = null;
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM notas");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Nota>();
            while (rs.next()) {
                Nota not = new Nota();

                not.setId_nota(rs.getInt("id_nota"));
                not.setId_docente(rs.getInt("id_docente"));
                not.setId_estudiante(rs.getInt("id_estudiante"));
                not.setId_materia(rs.getInt("id_materia"));
                not.setNota_1(rs.getInt("nota_1"));
                not.setNota_2(rs.getInt("nota_2"));
                not.setNota_3(rs.getInt("nota_3"));
                not.setNota_4(rs.getInt("nota_4"));
                not.setNota_final(rs.getInt("nota_final"));

                lista.add(not);
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
