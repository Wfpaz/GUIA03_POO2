/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.control;

import com.sv.udb.modelo.Persona;
import com.sv.udb.recursos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author walte
 */
public class PersonaCtrl {
    public List<Persona> consTodo()
    {
       List<Persona> resp = new ArrayList();
       Connection cn = new conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT CODI_PERS, NOMB_PERS, APEL_PERS, MAIL_PERS FROM pers");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Persona(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }
        catch(SQLException err)
        {
            System.out.println(err.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
} 
}
