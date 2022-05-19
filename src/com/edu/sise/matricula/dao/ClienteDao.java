/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.matricula.dao;

import com.edu.sise.matricula.entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author user
 */
public class ClienteDao {
 //atributos
   private Connection cn = null;
    private Statement st = null; //nos permite ejecutar sentencias SQL contra BD
    private ResultSet rs = null; //nos permite tener una tabla virtual
    private PreparedStatement ps = null;
    
    //constructor
    //constructor por defecto o sin parametros
    public ClienteDao(){
        //permite establecer la conexion a BD por medio de mi clase Conexion.java
        //sucede cuando creemos un nuevo objeto de la clase ClienteDao
        cn = new Conexion().getCn();
    }


    public List<Cliente> obtenerTodos(){
        
        //crear el sentencia SQL que quiero ejecutar
        String sql ="select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        
        try {
            //establezco la conexión con el state....
            //st = cn.createStatement();
            ps = cn.prepareStatement(sql);
            //rs = st.executeQuery(sql);
            rs = ps.executeQuery();
            //llenar la lista
            while(rs.next()){  //condición para determinar si existe un siguiente dato
                lista.add(new Cliente(
                        rs.getInt("id_cli"), 
                        rs.getString("dni"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getInt("edad")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("ClienteDao: " + ex.getMessage());
        }
        return lista;
    }
    
    public List<Cliente> busqueda(String nombres){
        
        //crear el sentencia SQL que quiero ejecutar
        String sql =" select * from cliente\n" +
                    " where nombres like '%"+nombres+"%';";
        List<Cliente> lista = new ArrayList<>();
        
        try {
            //código para ejecutar la sentencia con la bd
            
            //establezco la conexión con el state....
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            //llenar la lista
            while(rs.next()){  //condición para determinar si existe un siguiente dato
                lista.add(new Cliente(
                        rs.getInt("id_cli"), 
                        rs.getString("dni"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getInt("edad")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("ClienteDao: " + ex.getMessage());
        }
        return lista;
    }
    //tipo de dato boolean tiene dos valor posibles: true o false
    public boolean agregarCliente(Cliente o){
        //String sql = "insert into cliente(nombre) values('"+o.getNombre()+"')";
        String sql = "insert into cliente(dni,nombres,apellidos,edad) values(?,?,?,?)";
        int c =-1;
        
        try {
            //st = cn.createStatement();
            ps = cn.prepareStatement(sql);
            ps.setString(1, o.getDni());
            ps.setString(2, o.getNombres());
            ps.setString(3, o.getApellidos());
            ps.setInt(4, o.getEdad());
            //c = st.executeUpdate(sql);
            c = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("LibroDao: " + e.getMessage());
        }
        
        return (c>0);
    }
    
    //tipo de dato boolean tiene dos valor posibles: true o false
    public boolean modificarCliente(Cliente o){
        String sql="update Cliente set dni = ?,"+
                "nombres = ?,"+
                "apellidos = ?,"+
                "edad = ?"+
                " where  Id_cli =?";
        //representar la cantidad de registros afectados
        int c =-1;
        
        try {
            //st = cn.createStatement();
            ps = cn.prepareStatement(sql);
            ps.setString(1, o.getDni());
            ps.setString(2, o.getNombres());
            ps.setString(3, o.getApellidos());
            ps.setInt(4, o.getEdad());  
            ps.setInt(5, o.getId_cli());
            
            //c = st.executeUpdate(sql);
            c = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ClienteDao: " + e.getMessage());
        }
        
        return (c>0);
    }
    
    //tipo de dato boolean tiene dos valor posibles: true o false
    public boolean eliminarCliente(Integer id){
        String sql = "delete from cliente where id_cli = "+id;
        //representar la cantidad de registros afectados
        int c =-1;
        
        try {
            st = cn.createStatement();
            c = st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("ClienteDao: " + e.getMessage());
        }
        
        return (c>0);
    }
    
    
}





