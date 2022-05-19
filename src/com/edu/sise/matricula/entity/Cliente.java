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
public class Cliente {
    public Integer id_cli;
    public String dni;
    public String nombres;
    public String apellidos;
    public Integer edad;

    public Cliente(Integer id_cli, String dni, String nombres, String apellidos, Integer edad) {
        this.id_cli = id_cli;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Integer getId_cli() {
        return id_cli;
    }

    public void setId_cli(Integer id_cli) {
        this.id_cli = id_cli;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    

    

    
    
}
