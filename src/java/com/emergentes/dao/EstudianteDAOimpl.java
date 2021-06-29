/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Docente;
import com.emergentes.modelo.Estudiante;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class EstudianteDAOimpl extends ConexionDB implements EstudianteDAO {

    @Override
    public void insert(Estudiante estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO estudiantes (ci,id_docente,nombres,apellidos,telefono,correo) values (?,?,?,?,?,?)");
       
            ps.setInt(1, estudiante.getCi());
            ps.setInt(2, estudiante.getId_docente());
            ps.setString(3, estudiante.getNombres());
            ps.setString(4, estudiante.getApellidos());
            ps.setInt(5, estudiante.getTelefono());
            ps.setString(6, estudiante.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Estudiante estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE estudiantes SET ci=?,id_docente=?, nombres=?,apellidos=?, telefono=?, correo=? where id_estudiante = ?");

            ps.setInt(1, estudiante.getCi());
            ps.setInt(2, estudiante.getId_docente());
            ps.setString(3, estudiante.getNombres());
            ps.setString(4, estudiante.getApellidos());
            ps.setInt(5, estudiante.getTelefono());
            ps.setString(6, estudiante.getCorreo());
            ps.setInt(7, estudiante.getId_estudiante());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM estudiantes WHERE id_estudiante = ?");
            ps.setInt(1, id_estudiante);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Estudiante getById(int id_estudiante) throws Exception {
        Estudiante est = new Estudiante();
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes WHERE id_estudiante = ?");
            ps.setInt(1, id_estudiante);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                est.setId_estudiante(rs.getInt("id_estudiante"));
                est.setCi(rs.getInt("ci"));
                est.setId_docente(rs.getInt("id_docente"));
                est.setNombres(rs.getString("nombres"));
                est.setApellidos(rs.getString("apellidos"));
                est.setTelefono(rs.getInt("telefono"));
                est.setCorreo(rs.getString("correo"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Estudiante> getAll() throws Exception {
        List<Estudiante> lista = null;
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Estudiante>();
            while (rs.next()) {
                Estudiante est = new Estudiante();

                est.setId_estudiante(rs.getInt("id_estudiante"));
                est.setCi(rs.getInt("ci"));
                est.setId_docente(rs.getInt("id_docente"));
                est.setNombres(rs.getString("nombres"));
                est.setApellidos(rs.getString("apellidos"));
                est.setTelefono(rs.getInt("telefono"));
                est.setCorreo(rs.getString("correo"));

                lista.add(est);
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
