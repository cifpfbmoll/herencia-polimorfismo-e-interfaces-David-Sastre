/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.com.bibliotecapart2;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Bibliotecario extends Persona{
    //Atributos bibliotecario, + los de persona.
    private String puestoTrabajo;
    private String NIF;
    private String contraseña;
    
    // Constructor vacío
    public Bibliotecario() {
    }
    // Constructor con todos los parámetros.
    public Bibliotecario(String puestoTrabajo, String NIF, String contraseña) {
        this.puestoTrabajo = puestoTrabajo;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }
    public Bibliotecario(Bibliotecario b1) {
        this.setPuestoTrabajo(b1.getPuestoTrabajo());
        this.setNIF(b1.getNIF());
        this.setContraseña(b1.getContraseña());
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    //Métodos
    @Override
    public void solicitarDatosPersona(){
        super.solicitarDatosPersona(); 
        System.out.println("Cuál es su puesto de trabajo?");
        this.setPuestoTrabajo(lector.nextLine());
        System.out.println("Indique su NIF:");
        this.setNIF(lector.nextLine());
        System.out.println("Escriba su contraseña:");
        this.setContraseña(lector.nextLine());
    }
        public static int identificacionBibliotecario(Biblioteca biblio) {
        int validacion = 0;
        boolean identificacion = false;
        int i= 0;
        System.out.println("Indique su NIF: ");
        String NIF = lector.nextLine();
        System.out.println("Contraseña: ");
        String contraseña = lector.nextLine();
        while(i<biblio.getListaPersonal().size() && !identificacion){
            if(biblio.getListaPersonal().get(i) instanceof Bibliotecario){
                if(((Bibliotecario)biblio.getListaPersonal().get(i)).getContraseña().equals(contraseña) 
                    && ((Bibliotecario)biblio   .getListaPersonal().get(i)).getNIF().equals(NIF)){
                    System.out.println("Ha iniciado sesión Correctamente");
                    identificacion = true;
                    validacion = 1;
                    return validacion;
                }
            }
            i++;
        }
        if(!identificacion){
            System.out.println("No hay ningún Bibliotecario con esos datos, porfavor vuelvalo a intentar");
            validacion = 1;
        }
        return validacion;
    }
    
    public static void mostrarPersonal(ArrayList<Persona> listaPersonal){
        System.out.println("Lista de Bibliotecarios:");
        for(int i=0;i<listaPersonal.size(); i++){
            System.out.println(listaPersonal.get(i));
        }
    }
    public void cambiarContraseña(){
        System.out.println("Vamos a proceder al cambio de su contraseña");
        System.out.println("Su contraseña actual és: " + getContraseña());
        System.out.println("Escriba su nueva contraseña:");
        this.setContraseña(lector.nextLine());
        System.out.println("CLa contraseña se ha cambiado correctamente.");
    }
}
