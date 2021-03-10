/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.com.bibliotecapart2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author David
 */
public class Biblioteca {
    private String nombreBiblio;
    private ArrayList<Libro>listaLibros = new ArrayList<>();
    private ArrayList<Persona>listaPersonal = new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList();
    private int librosTotal = 0;
    
    public Biblioteca () {
        //Constructor vacío
    }

    public Biblioteca(String nombreBiblio) {
        this.nombreBiblio = nombreBiblio;
    }
    // Constructor copia de Biblioteca
    public Biblioteca(Biblioteca biblio){
        this.setNombreBiblio(biblio.getNombreBiblio());
        this.setListaLibros(biblio.getListaLibros());
        this.setListaPersonal(biblio.getListaPersonal());
        this.setListaUsuarios(biblio.getListaUsuarios());
    }
    // Getters and setters

    public String getNombreBiblio() {
        return nombreBiblio;
    }

    public void setNombreBiblio(String nombreBiblio) {
        this.nombreBiblio = nombreBiblio;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Persona> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "nombreBiblio=" + nombreBiblio + ", listaLibros=" + listaLibros + ", listaPersonal=" + listaPersonal + ", listaUsuarios=" + listaUsuarios + '}';
    }
    
    public void mostrarLibros(){
        //this.listaLibros = new ArrayList<>();
        //Libro.mostrarLista();
        /*this.getlistaLibros().forEach(libro1 -> {
            System.out.println(libro1.toString());
        });*/
        Iterator<Libro> iter = listaLibros.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }
    public void mostrarLibrosDisponibles(){
        int librosDisponibles = 0;
        int librosNd =0;
        for (int i=0; i<this.listaLibros.size(); i++){
            if(this.listaLibros.get(i).getCopiasDisponibles()>0){
                System.out.println(this.listaLibros.get(i).toString());
                librosDisponibles ++;
            }else{
                librosNd ++;
            }
        }
        System.out.println("Hay " + librosDisponibles + " libros disponibles en total.");
        System.out.println("Hay un total de " + librosNd + " libro NO disponibles.");
    }
}
