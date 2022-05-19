/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.matricula.logic;

import com.edu.sise.matricula.dao.AsignaturaDao;
import com.edu.sise.matricula.dao.DAOManager;
import com.edu.sise.matricula.entity.Asignatura;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class AsignaturaLogic {
    
    List<Asignatura> lista;
    AsignaturaDao dao = DAOManager.getInstancia().getAsignaturaDao();
    
    public AsignaturaLogic(){
        lista = new ArrayList<>();
    }
        
    public DefaultTableModel getModelo(){
         DefaultTableModel modelo = new DefaultTableModel();
         
         //crear las columnas
         modelo.addColumn("ID");
         modelo.addColumn("NOMBRE");
         modelo.addColumn("OBLIGATORIEDAD");
         modelo.addColumn("NUM_CREDITOS");
         
//         cargarData(); //obtener desde base de datos
        lista = dao.obtenerTodos();
         
         //llenar las filas
         
         for(Asignatura obj : lista){
             Object data[] ={
                 obj.getId_asig(),
                 obj.getNombre(),
                 obj.getObligatoriedad(),
                 obj.getNum_creditos()
             };
             
             modelo.addRow(data);
         }
         
         return modelo;
         
    }
    
    public void imprimir(JTable tabla){
        tabla.setModel(getModelo());
    }
    
    public boolean agregarAsignatura(Asignatura o){
        return dao.agregarAsignatura(o);
    }
    
    public boolean modificarAsignatura(Asignatura o){
        return dao.modificarAsignatura(o);
    }
    
    public boolean eliminarAsignatura(Integer id){
        return dao.eliminarAsignatura(id);
    }
    
    public void llenarCboAsignaturas(JComboBox cbo){
        DefaultComboBoxModel  modelo = new DefaultComboBoxModel();
        lista = dao.obtenerTodos();
        for(Asignatura obj : lista){
            modelo.addElement(obj);
        }
        
        cbo.setModel(modelo);
    }
    
    public void seleccionarCboAsignaturas(JComboBox cbo, Integer id){
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)cbo.getModel();
        
        for(int i=0; i<modelo.getSize();i++){
            if(((Asignatura)modelo.getElementAt(i)).getId_asig()==id)
                modelo.setSelectedItem((Asignatura)modelo.getElementAt(i));
        }
    }
}
