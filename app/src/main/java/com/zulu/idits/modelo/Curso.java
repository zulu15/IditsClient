package com.zulu.idits.modelo;

/**
 * Created by mparedes on 21/10/16.
 */
public class Curso {
    private int id;
    private String Nombre;
    private String Localidad;
    private int Carga_Horaria;
    private String Contenido;

    public Curso(int id,String nom, String loc, int carga, String contenido){
        this.id = id;
        this.Nombre = nom;
        this.Localidad = loc;
        this.Carga_Horaria = carga;
        this.Contenido = contenido;
    }

    public int retornaId(){ return id;}

    public String retornaNombre(){
        return Nombre;
    }

    public String retornaContenido(){
        return Contenido;
    }

    public String retornaLocalidad(){
        return Localidad;
    }

    public int retornaCargaHoraria(){
        return Carga_Horaria;
    }

    public String toString(){
        return "\n" + id + " " + Nombre + " " + Localidad + Carga_Horaria;
    }

}