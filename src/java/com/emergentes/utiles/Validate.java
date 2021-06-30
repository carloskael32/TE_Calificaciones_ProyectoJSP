/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class Validate extends ConexionDB {
     Connection con = this.conectar();
    PreparedStatement pr;
    
    public boolean checkUser(String ci, String password)
    {
        boolean resultado = false;
        try {
            String sql = "select * from docentes where ci=? and pass=?";
            
            pr = con.prepareStatement(sql);
            pr.setString(1,ci);
            pr.setString(2,password);
            ResultSet rs =  pr.executeQuery();
            resultado = rs.next();
        } catch (SQLException ex) {
            System.out.println(""
                    + "Error al autenticar");
        }
        return resultado;
    }
    
}
