/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.matricula.entity;

/**
 *
 * @author RENATO
 */
public class Asignatura {
    private Integer id_asig;
    private String nombre;
    private Integer obligatoriedad;
    private Integer num_creditos;

    public Asignatura(Integer id_asig, String nombre, Integer obligatoriedad, Integer num_creditos) {
        this.id_asig = id_asig;
        this.nombre = nombre;
        this.obligatoriedad = obligatoriedad;
        this.num_creditos = num_creditos;
    }

    public Integer getId_asig() {
        return id_asig;
    }

    public void setId_asig(Integer id_asig) {
        this.id_asig = id_asig;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getObligatoriedad() {
        return obligatoriedad;
    }

    public void setObligatoriedad(Integer obligatoriedad) {
        this.obligatoriedad = obligatoriedad;
    }

    public Integer getNum_creditos() {
        return num_creditos;
    }

    public void setNum_creditos(Integer num_creditos) {
        this.num_creditos = num_creditos;
    }

  
    
}
