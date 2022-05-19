/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.matricula.entity;

/**
 *
 * @author user
 */
public class Empleado {
    public Integer id_emp;
    public String dni;
    public String nombres;
    public String apellidos;
    public double sueldo;

    public Empleado(Integer id_emp, String dni, String nombres, String apellidos, double sueldo) {
        this.id_emp = id_emp;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
    }

    public Integer getId_emp() {
        return id_emp;
    }

    public void setId_emp(Integer id_emp) {
        this.id_emp = id_emp;
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

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
}
