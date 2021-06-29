/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Docente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class DocenteDAOimpl extends ConexionDB implements DocenteDAO {

    @Override
    public void insert(Docente docente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO docentes (ci,tipo_user,nombres,apellidos,pass,telefono,correo) values (?,?,?,?,?,?,?)");
            
            
            ps.setInt(1, docente.getCi());
            ps.setString(2, docente.getTipo_user());
            ps.setString(3, docente.getNombres());
            ps.setString(4, docente.getApellidos());
            ps.setString(5, docente.getPass());
            ps.setInt(6, docente.getTelefono());
            ps.setString(7, docente.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Docente docente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE docentes SET ci= ?, nombres=?, apellidos=?, pass=?, telefono=?, correo=? where id_docente = ?");

            ps.setInt(1, docente.getCi());

            ps.setString(2, docente.getNombres());
            ps.setString(3, docente.getApellidos());
            ps.setString(4, docente.getPass());
            ps.setInt(5, docente.getTelefono());
            ps.setString(6, docente.getCorreo());

            ps.setInt(7, docente.getId_docente());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_docente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM docentes WHERE id_docente = ?");
            ps.setInt(1, id_docente);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Docente getById(int id_docente) throws Exception {
        Docente doc = new Docente();
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM docentes WHERE id_docente = ?");
            ps.setInt(1, id_docente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                doc.setId_docente(rs.getInt("id_docente"));
                doc.setCi(rs.getInt("ci"));
                doc.setTipo_user(rs.getString("tipo_user"));
                doc.setNombres(rs.getString("nombres"));
                doc.setApellidos(rs.getString("apellidos"));
                doc.setPass(rs.getString("pass"));
                doc.setTelefono(rs.getInt("telefono"));
                doc.setCorreo(rs.getString("correo"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return doc;
    }

    @Override
    public List<Docente> getAll() throws Exception {
        List<Docente> lista = null;
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM docentes");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Docente>();
            while (rs.next()) {
                Docente doc = new Docente();

                doc.setId_docente(rs.getInt("id_docente"));
                doc.setCi(rs.getInt("ci"));
                doc.setTipo_user(rs.getString("tipo_user"));
                doc.setNombres(rs.getString("nombres"));
                doc.setApellidos(rs.getString("apellidos"));
                doc.setPass(rs.getString("pass"));
                doc.setTelefono(rs.getInt("telefono"));
                doc.setCorreo(rs.getString("correo"));

                lista.add(doc);
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
