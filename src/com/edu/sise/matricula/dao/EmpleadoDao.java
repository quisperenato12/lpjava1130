/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.matricula.dao;

import com.edu.sise.matricula.entity.Departamento;
import com.edu.sise.matricula.entity.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class EmpleadoDao {
    private Connection cn = null;
    private Statement st = null; //nos permite ejecutar sentencias SQL contra BD
    private ResultSet rs = null; //nos permite tener una tabla virtual
    
    //constructor
    //constructor por defecto o sin parametros
    public EmpleadoDao(){
        //permite establecer la conexion a BD por medio de mi clase Conexion.java
        //sucede cuando creemos un nuevo objeto de la clase DepartamentoDao
        cn = new Conexion().getCn();
    }


    public List<Empleado> obtenerTodos(){
        
        //crear el sentencia SQL que quiero ejecutar
        String sql ="select * from empleados";
        List<Empleado> lista = new ArrayList<>();
        
        try {
            //código para ejecutar la sentencia con la bd
            
            //establezco la conexión con el state....
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            //llenar la lista
         while(rs.next()){  //condición para determinar si existe un siguiente dato
        lista.add(new Empleado(rs.getInt("id_emp"),rs.getString("dni"), rs.getString("nombres"),rs.getString("apellidos"),rs.getDouble("sueldo")));
            }
        } catch (SQLException ex) {
            System.out.println("EmpleadoDao: " + ex.getMessage());
        }
        return lista;
    }

//tipo de dato boolean tiene dos valores posibles:true o false    
public boolean agregarEmpleado(Empleado o){
    String sql ="insert into empleados(dni,nombres,apellidos,sueldo) values ('"+o.getDni()+o.getNombres()+o.getApellidos()+o.getSueldo()+"')";

    //representar la cantidad de registros afectados
    int c=-1;
    try{
        
    
    st = cn.createStatement();
    c = st.executeUpdate(sql);
    } catch (Exception e){
        System.out.println("EmpleadoDao : " +e.getMessage());
    }
    return (c>0);
}    

public boolean modificarEmpleado (Empleado o){
    //representar la cantidad de registros afectados
        String sql="update empleados set dni = '"+o.getDni()+"',"+
                "nombres = '"+o.getNombres()+"',"+
                "apellidos = '"+o.getApellidos()+"',"+
                "sueldo = " +o.getSueldo()+" "+
                "where id_emp ="+o.getId_emp();
     
    int c=-1;
    try{
        
    
    st = cn.createStatement();
    c = st.executeUpdate(sql);
    } catch (Exception e){
        System.out.println("EmpleadoDao: " +e.getMessage());
    }
    return (c>0);
}    

public boolean eliminarEmpleado(Integer id){
String sql="delete from empleados where id_emp = "+id;    

int c=-1;
try{
    st=cn.createStatement();
    c=st.executeUpdate(sql);
}catch(Exception e){
    System.out.println("EmpleadoDao: "+e.getMessage());
    
}

return(c>0);
}

}
