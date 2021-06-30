/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.modelo;

/**
 *
 * @author Carlos
 */
public class Nota {
    
    private int id_nota;
    private int id_docente;
    private int id_estudiante;
    private int id_materia;
    private int nota_1;
    private int nota_2;
    private int nota_3;
    private int nota_4;
    private int nota_final;
    private String materia;

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getNota_1() {
        return nota_1;
    }

    public void setNota_1(int nota_1) {
        this.nota_1 = nota_1;
    }

    public int getNota_2() {
        return nota_2;
    }

    public void setNota_2(int nota_2) {
        this.nota_2 = nota_2;
    }

    public int getNota_3() {
        return nota_3;
    }

    public void setNota_3(int nota_3) {
        this.nota_3 = nota_3;
    }

    public int getNota_4() {
        return nota_4;
    }

    public void setNota_4(int nota_4) {
        this.nota_4 = nota_4;
    }

    public int getNota_final() {
        return nota_final;
    }

    public void setNota_final(int nota_final) {
        this.nota_final = nota_final;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Nota{" + "id_nota=" + id_nota + ", id_docente=" + id_docente + ", id_estudiante=" + id_estudiante + ", id_materia=" + id_materia + ", nota_1=" + nota_1 + ", nota_2=" + nota_2 + ", nota_3=" + nota_3 + ", nota_4=" + nota_4 + ", nota_final=" + nota_final + ", materia=" + materia + '}';
    }

    
   
    

   
}
