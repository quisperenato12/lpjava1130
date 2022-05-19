/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.matricula.logic;

import com.edu.sise.matricula.dao.ClienteDao;
import com.edu.sise.matricula.dao.ClienteDao;
import com.edu.sise.matricula.entity.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author RENATO
 */
public class ClienteLogic {
    List<Cliente> lista;
    
    public ClienteLogic(){
        lista = new ArrayList<>();
    }
        
    public DefaultTableModel getModelo(){
         DefaultTableModel modelo = new DefaultTableModel();
         
         //crear las columnas
          modelo.addColumn("ID");
         modelo.addColumn("DNI");
         modelo.addColumn("NOMBRES");
         modelo.addColumn("APELLIDOS");
         modelo.addColumn("EDAD");
         
//         cargarData(); //obtener desde base de datos
        lista = new ClienteDao().obtenerTodos();
         
         //llenar las filas
         
         for(Cliente obj : lista){
             Object data[] ={
                 obj.getId_cli(),
                 obj.getDni(),
                 obj.getNombres(),
                 obj.getApellidos(),
                 obj.getEdad()          
             };
             
             modelo.addRow(data);
         }
         
         return modelo;
         
    }
    public DefaultTableModel getModelo(String nombres){
         DefaultTableModel modelo = new DefaultTableModel();
         
         //crear las columnas
         modelo.addColumn("ID");
         modelo.addColumn("DNI");
         modelo.addColumn("NOMBRES");
         modelo.addColumn("APELLIDOS");
         modelo.addColumn("EDAD");
         
//         cargarData(); //obtener desde base de datos
        lista = new ClienteDao().busqueda(nombres);
         
         //llenar las filas
         
         for(Cliente obj : lista){
             Object data[] ={
                 obj.getId_cli(),
                 obj.getDni(),
                 obj.getNombres(),
                 obj.getApellidos(),
                 obj.getEdad()          
             };
             
             modelo.addRow(data);
         }
         
         return modelo;
         
    }
    
    public void imprimir(JTable tabla){
        tabla.setModel(getModelo());
    }
    
    public void imprimir(JTable tabla, String nombres){
    tabla.setModel(getModelo(nombres));
    }
  
    public boolean agregarCliente(Cliente o){
        return new ClienteDao().agregarCliente(o);
    }
    
    public boolean modificarCliente(Cliente o){
        return new ClienteDao().modificarCliente(o);
    }
    
    public boolean eliminarCliente(Integer id){
        return new ClienteDao().eliminarCliente(id);
    }
    
    public void llenarCboClientes(JComboBox cbo){
        DefaultComboBoxModel  modelo = new DefaultComboBoxModel();
        lista = new ClienteDao().obtenerTodos();
        for(Cliente obj : lista){
            modelo.addElement(obj);
        }
        
        cbo.setModel(modelo);
    }
    
    public void seleccionarCboClientes(JComboBox cbo, Integer id){
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)cbo.getModel();
        
        for(int i=0; i<modelo.getSize();i++){
            if(((Cliente)modelo.getElementAt(i)).getId_cli()==id)
                modelo.setSelectedItem((Cliente)modelo.getElementAt(i));
        }
    }
        public void generarReporte(){
        JasperReport reporte;
        
        //Necesitamos el Jasper
        String ruta = "D:\\COMPUTACION E INFORM. CICLO3\\LENG DE PROG JAVA\\reportes_1130\\rpt_clientes_1130.jasper";
        
        try {
            reporte = (JasperReport)JRLoader.loadObjectFromFile(ruta);
            Map<String, Object> parametros = new HashMap<String, Object>();           
            parametros.put("ruc","2020202020");
            parametros.put("razon_social","SISE SAC");
            parametros.put("direccion","SANTA BEATRIZ");
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte,parametros,
                    new JRBeanCollectionDataSource(new ClienteDao().obtenerTodos()));
            JasperViewer jViewer = new JasperViewer(jprint,false);
            jViewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jViewer.setVisible(true);
                    } catch (Exception e) {
            System.out.println("Error JR: " + e.getMessage());
                    }
        }
    
    
}
