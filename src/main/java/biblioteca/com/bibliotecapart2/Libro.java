/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.com.bibliotecapart2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Libro {
    private int ISBN;
    private String Titulo;
    private String Autor;
    private String Editorial;
    private int Copias;
    private int CopiasDisponibles;
    private static Scanner lector = new Scanner(System.in);
    private static ArrayList<Libro>listaLibros = new ArrayList<Libro>();
    private static int librosTotal = 0;

    public  Libro(){
        librosTotal ++;
    /** Constructor Vacío 
     */
    }
    public Libro (int ISBN, String Título, String Autor, String Editorial, int Copias, int CopiasDisponibles){
        librosTotal ++;
        if (Copias<1){
            System.out.println("El libro debe tener almenos una copia.");
        }else{
            this.ISBN = ISBN;
            this.Titulo = Titulo;
            this.Autor = Autor;
            this.Editorial = Editorial;
            this.Copias = Copias;
            this.CopiasDisponibles = CopiasDisponibles;
        }
    }
    public Libro (Libro libro1){
        librosTotal ++;
        this.setISBN(libro1.getISBN());
        this.setTitulo(libro1.getTitulo());
        this.setAutor(libro1.getAutor());
        this.setEditorial(libro1.getEditorial());
        this.setCopias(libro1.getCopias());
        this.setCopiasDisponibles(libro1.getCopiasDisponibles());
    }
    
    // getters and setters
    public static int getLibrosTotal() {
        return librosTotal;
    }

    public static void setLibrosTotal(int librosTotal) {
        Libro.librosTotal = librosTotal;
    }
    
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public int getCopias() {
        return Copias;
    }

    public void setCopias(int Copias){ 
        this.Copias = Copias;
    }

    public int getCopiasDisponibles() {
        return CopiasDisponibles;
    }

    public void setCopiasDisponibles(int CopiasDisponibles) {
        while(CopiasDisponibles > Copias){
            System.out.println("No puede haber más copias disponibles que copias totales");
            CopiasDisponibles = lector.nextInt();
            lector.nextLine();
        }
        this.CopiasDisponibles = CopiasDisponibles;
    }

    @Override
    public String toString() {
        return "Libro" + "ISBN=" + ISBN + ", Titulo=" + Titulo + ", Autor=" + Autor + ", Editorial=" + Editorial + ", Copias=" + Copias + ", CopiasDisponibles=" + CopiasDisponibles + '}';
    }
    
    public static Libro añadirLibro(ArrayList<Libro>listaLibros){
        Libro libro1 = new Libro();
        System.out.println("Indica el título del libro:");
        libro1.setTitulo(lector.nextLine());
        
        System.out.println("Indica el ISBN del libro");
        libro1.setISBN(lector.nextInt());
        lector.nextLine();
        
        System.out.println("Indica el autor del libro:");
        libro1.setAutor(lector.nextLine());
        
        System.out.println("Indica la editorial del libro:");
        libro1.setEditorial(lector.nextLine());
        
        System.out.println("Indica el número de copias que tiene este libro");
        libro1.setCopias(lector.nextInt());
        lector.nextLine();
        
        System.out.println("Dime el número de copias disponibles que tiene este libro");
        libro1.setCopiasDisponibles(lector.nextInt());
        lector.nextLine(); 
        listaLibros.add(libro1);
        
        return libro1;
    }   
    public static void eliminarLibro(ArrayList<Libro>listaLibros){
        System.out.println("Escribe el ISBN del libro que desea eliminar: ");
        int ISBN = lector.nextInt();
        lector.nextLine();
        int i=0;
        for (i=0; i<listaLibros.size(); i++){
            if(listaLibros.get(i).getISBN()== ISBN){
                listaLibros.remove(i);
                System.out.println("El libro se ha borrado correctamente.");
            }else{
                System.out.println("No se ha encontrado el ISBN: "+ISBN);
            }
        }
    }
    public static void buscarLibroISBN(ArrayList<Libro>listaLibros){
        System.out.println("Escribe el ISBN del libro que desea encontrar: ");
        int ISBN = lector.nextInt();
        lector.nextLine();
        for (int i=0; i<listaLibros.size(); i++){
            if(listaLibros.get(i).getISBN()== ISBN){
                System.out.println(listaLibros.get(i).getISBN());
            }else{   
                System.out.println("No se ha encontrado el ISBN: "+ISBN);
            }
        }
    }
    public static void buscarLibroTitulo(ArrayList<Libro>listaLibros){
        System.out.println("Escribe el título del libro que desea encontrar: ");
        String Titulo = lector.nextLine();
        for (int i=0; i<listaLibros.size(); i++){
            if(listaLibros.get(i).getTitulo().contains(Titulo)){
                System.out.println(listaLibros.get(i).toString());
            }else{
                System.out.println("No se ha encontrado el título que busca");
            }
        }
    }
    
}
