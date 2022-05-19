/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.matricula.dao;

import com.edu.sise.matricula.entity.Asignatura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class AsignaturaDao {
    
    //atributos
    private Connection cn = null;
    private Statement st = null; //nos permite ejecutar sentencias SQL contra BD
    private ResultSet rs = null; //nos permite tener una tabla virtual
    private PreparedStatement ps = null;
    
    //constructor
    //constructor por defecto o sin parametros
    public AsignaturaDao(){
        //permite establecer la conexion a BD por medio de mi clase Conexion.java
        //sucede cuando creemos un nuevo objeto de la clase AsignaturaDao
        cn = new Conexion().getCn();
    }
    
    public List<Asignatura> obtenerTodos(){
        
        //crear el sentencia SQL que quiero ejecutar
        String sql ="select * from asignaturas";
        List<Asignatura> lista = new ArrayList<>();
        
        try {
            //código para ejecutar la sentencia con la bd
            
            //establezco la conexión con el state....
            //st = cn.createStatement();
            ps = cn.prepareStatement(sql);
            //rs = st.executeQuery(sql);
            rs = ps.executeQuery();
            //llenar la lista
            while(rs.next()){  //condición para determinar si existe un siguiente dato
                lista.add(new Asignatura(
                        rs.getInt("id_asig"), 
                        rs.getString("nombre"), 
                        rs.getInt("obligatoriedad"), 
                        rs.getInt("num_creditos")));
            }
        } catch (SQLException ex) {
            System.out.println("AsignaturaDao: " + ex.getMessage());
        }
        return lista;
    }
    //tipo de dato boolean tiene dos valor posibles: true o false
    public boolean agregarAsignatura(Asignatura o){
        //String sql = "insert into carreras(nombre) values('"+o.getNombre()+"')";
        String sql = "insert into asignaturas(nombre) values(?)";
        //representar la cantidad de registros afectados
        int c =-1;
        
        try {
            //st = cn.createStatement();
            ps = cn.prepareStatement(sql);
            ps.setString(1, o.getNombre());
            //c = st.executeUpdate(sql);
            c = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("AsignaturaDao: " + e.getMessage());
        }
        
        return (c>0);
    }
    
    //tipo de dato boolean tiene dos valor posibles: true o false
    public boolean modificarAsignatura(Asignatura o){
        //String sql = "update carreras set nombre = '"+o.getNombre()+"' where id_depa = "+o.getId_depa();
        String sql = "update asignaturas set nombre = ? where id_asig = ? ";
        //representar la cantidad de registros afectados
        int c =-1;
        
        try {
            //st = cn.createStatement();
            ps = cn.prepareStatement(sql);
            ps.setString(1, o.getNombre());
            ps.setInt(2, o.getId_asig());
            
            //c = st.executeUpdate(sql);
            c = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("AsignaturaDao: " + e.getMessage());
        }
        
        return (c>0);
    }
    
    //tipo de dato boolean tiene dos valor posibles: true o false
    public boolean eliminarAsignatura(Integer id){
        String sql = "delete from asignaturas where id_asig= ? ";
        //representar la cantidad de registros afectados
        int c =-1;
        
        try {
            //st = cn.createStatement();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            //c = st.executeUpdate(sql);
            c = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("AsignaturaDao: " + e.getMessage());
        }
        
        return (c>0);
    }
    
    
}
