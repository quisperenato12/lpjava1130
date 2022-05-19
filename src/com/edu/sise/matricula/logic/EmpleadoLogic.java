/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.matricula.logic;


import com.edu.sise.matricula.dao.EmpleadoDao;
import com.edu.sise.matricula.entity.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class EmpleadoLogic {
    
    List<Empleado> lista;
    public EmpleadoLogic(){
        lista = new ArrayList<>();
    }
    
    //public void cargarData(){
        // lista.add(new Departamento(100,"LIMA"));
      //   lista.add(new Departamento(200,"LA LIBERTAD"));
        // lista.add(new Departamento(300,"TUMBES"));
         //lista.add(new Departamento(400,"PIURA"));

        
   // }
    
    public DefaultTableModel getModelo(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        //crear las columnas
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("NOMBRES");
        modelo.addColumn("APELLIDOS");
        modelo.addColumn("SUELDO");
        
     //   cargarData(); //obtenre datos desde base de datos
     lista = new EmpleadoDao().obtenerTodos();
        
        //llenar las filas
        
        for (Empleado obj : lista){
            
            Object data [] ={
                obj.getId_emp(),
                obj.getDni(),
                obj.getNombres(),
                obj.getApellidos(),
                obj.getSueldo()
            };
            
            modelo.addRow(data);
        }
        return modelo;
    }
    public void imprimir(JTable tabla){
        tabla.setModel(getModelo());
    }
    
    public boolean agregarEmpleado(Empleado o){
        return new EmpleadoDao().agregarEmpleado(o);
    }
    
    public boolean modificarEmpleado(Empleado o){
        return new EmpleadoDao().modificarEmpleado(o);
    }
    
    public boolean eliminarEmpleado(Integer id){
        return new EmpleadoDao().eliminarEmpleado(id);
    }
}
