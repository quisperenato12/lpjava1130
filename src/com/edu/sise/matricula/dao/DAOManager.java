/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.matricula.dao;

/**
 *
 * @author RENATO
 */
public class DAOManager {
    
    //crear mis atributos para Singleton
    private static final DAOManager instancia = new DAOManager();
    
    public static DAOManager getInstancia(){
        return instancia;
    }
    
    //fin de mi Singleton
    
    //iniciar con Factory
    //matricular a mis clases (DAO)
    private CarreraDao carreraDao;
    private DepartamentoDao departamentoDao;
    private ProvinciaDao provinciaDao;
    private TutorDao tutorDao;
    private ProfesorDao profeDao;
    private AsignaturaDao asigDao;
    
    public CarreraDao getCarreraDao(){
        if(carreraDao==null)
            carreraDao= new CarreraDao();
        return carreraDao;
    }
    
    public DepartamentoDao getDepartamentoDao(){
        if(departamentoDao==null)
            departamentoDao= new DepartamentoDao();
        return departamentoDao;
    }
    
    public ProvinciaDao getProvinciaDao(){
        if(provinciaDao==null)
            provinciaDao= new ProvinciaDao();
        return provinciaDao;
    }
    
    public TutorDao getTutorDao(){
        if(tutorDao==null)
            tutorDao= new TutorDao();
        return tutorDao;
    }
    
    public ProfesorDao getProfesorDao(){
        if(profeDao==null)
            profeDao= new ProfesorDao();
        return profeDao;
    }
    
    public AsignaturaDao getAsignaturaDao(){
        if(asigDao==null)
            asigDao= new AsignaturaDao();
        return asigDao;
    }
}
