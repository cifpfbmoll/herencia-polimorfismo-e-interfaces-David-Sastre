/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.com.bibliotecapart2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author David
 */
public abstract class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    public static Scanner lector = new Scanner(System.in);
    
    //Constructor Vacio
    public Persona (){
    }
    // Constructor con parámetros
    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }
    // Constructor Copia
    public Persona (Persona pax){
        this.setNombre(pax.getNombre());
        this.setApellido1(pax.getApellido1());
        this.setApellido2(pax.getApellido2());
        this.setEdad(pax.getEdad());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + '}';
    }
    
    /**
     *
     */
    public void solicitarDatosPersona(){
        System.out.println("Dime tu nombre:");
        this.setNombre(lector.nextLine());
        System.out.println("Primer apellido:");
        this.setApellido1(lector.nextLine());
        System.out.println("Segundo apellido:");
        this.setApellido2(lector.nextLine());
        System.out.println("Edad:");
        this.setEdad(lector.nextInt());
        lector.nextLine();
    }
    public static void eliminarPersona(ArrayList<Persona>listaPersonal){
        System.out.println("Escribe el nombre del trabajador que deseas eliminar: ");
        String nombre = lector.nextLine();
        System.out.println("Primer apellido:");
        String apellido1 = lector.nextLine();
        System.out.println("Segundo apellido:");
        String apellido2 = lector.nextLine();
        int i;
        boolean personalEncontrado = false;
        for (i=0; i<listaPersonal.size(); i++){
            if((listaPersonal.get(i).getNombre().equals(nombre)) &&
            ((listaPersonal.get(i).getApellido1().equals(apellido1)) &&
            (listaPersonal.get(i).getApellido2().equals(apellido2)))){
                listaPersonal.remove(i);
                personalEncontrado = true;
                System.out.println("Se va a proceder a la eliminación de: "+nombre + apellido1 + apellido2);
                System.out.println("El trabajador se ha borrado correctamente.");
            }
        if (!personalEncontrado){
                System.out.println("No se ha encontrado al bibliotecario, vuelve a escribir sus datos.");
            }
        }
    }
    public static void eliminarUsuario(ArrayList<Usuario>listaUsuario){
        System.out.println("Escribe el nombre del usuario que deseas eliminar: ");
        String nombre = lector.nextLine();
        System.out.println("Primer apellido:");
        String apellido1 = lector.nextLine();
        System.out.println("Segundo apellido:");
        String apellido2 = lector.nextLine();
        int i;
        boolean usuarioEncontrado = false;
        for (i=0; i<listaUsuario.size(); i++){
            if((listaUsuario.get(i).getNombre().equals(nombre)) &&
            ((listaUsuario.get(i).getApellido1().equals(apellido1)) &&
            (listaUsuario.get(i).getApellido2().equals(apellido2)))){
                listaUsuario.remove(i);
                usuarioEncontrado = true;
                System.out.println("Se va a proceder a la eliminación de: "+nombre + apellido1 + apellido2);
                System.out.println("El usuario se ha borrado correctamente.");
            }
        if (!usuarioEncontrado){
                System.out.println("No se ha encontrado al usuario, vuelve a escribir sus datos.");
            }
        }
    }
    public static void mostrarPersonal(ArrayList<Persona>listaPersonal){
        Iterator<Persona> iter = listaPersonal.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }
    public abstract void cambiarContraseña();
    
}