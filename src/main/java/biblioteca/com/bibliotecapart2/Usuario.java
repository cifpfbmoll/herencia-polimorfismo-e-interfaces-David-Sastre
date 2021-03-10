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
public class Usuario extends Persona{
    // Atributos de Usuario, aparte de los de Persona
    private int telefono;
    private String direccion;
    private int codigoPostal;
    private String correo;
    private ArrayList<Reserva> listaReservas;
    private int librosReservados;
    // Constructor vacío

    public Usuario() {
        this.listaReservas = new ArrayList<Reserva>();
    }
    
    // Constructor con todos los parámetros, incluidos los de Persona

    public Usuario(int telefono, String direccion, int codigoPostal, String correo, String nombre, String apellido1, String apellido2, int edad, ArrayList<Reserva> listaReservas) {
        super(nombre, apellido1, apellido2, edad);
        this.listaReservas = new ArrayList();
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setCodigoPostal(codigoPostal);
        this.setCorreo(correo);
        this.setListaReservas(listaReservas);
        this.setLibrosReservados(librosReservados);
        
    }
    
    

    public Usuario(Usuario copiaUsuario){
       this.listaReservas = new ArrayList();
       this.setTelefono(copiaUsuario.getTelefono());
       this.setDireccion(copiaUsuario.getDireccion());
       this.setCodigoPostal(copiaUsuario.getCodigoPostal());
       this.setCorreo(copiaUsuario.getCorreo());
       this.setListaReservas(copiaUsuario.getListaReservas());
       this.setLibrosReservados(copiaUsuario.getLibrosReservados());
    }
    
    // Getters / Setters
    
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public int getLibrosReservados() {
        return librosReservados;
    }

    public void setLibrosReservados(int librosReservados) {
        this.librosReservados = librosReservados;
    }
    
    
    // To String
    
    @Override
    public String toString() {
        return super.toString() + "Usuario{" + "telefono=" + telefono + ", direccion=" + direccion + ", codigoPostal=" + codigoPostal + ", correo=" + correo + ", Reservas=" + listaReservas + '}';
    
    }
    
    // MÉTODOS

    
    @Override
    public void solicitarDatosPersona() {
        super.solicitarDatosPersona();
        System.out.println("Pon tu número de teléfono:");
        this.setTelefono(lector.nextInt());
        lector.nextLine();
        System.out.println("Pon tu dirección:");
        this.setDireccion(lector.nextLine());
        System.out.println("Pon el número postal:");
        this.setCodigoPostal(lector.nextInt());
        lector.nextLine();
        System.out.println("Pon tu correo electrónico:");
        this.setCorreo(lector.nextLine());
        
    }
    public static int identificacionUsuario(Biblioteca biblio){
        int validacion = 0;
        boolean identificacion = false;
        int i = 0;
        System.out.println("Teléfono Usuario:");
        int telefono = lector.nextInt();
        lector.nextLine();
        
        System.out.println("Correo Usuario:");
        String correo = lector.nextLine();
        
        while(i<biblio.getListaUsuarios().size() && !identificacion){
            if(biblio.getListaUsuarios().get(i) instanceof Usuario){
                if(((Usuario)biblio.getListaUsuarios().get(i)).getTelefono()==telefono
                    && ((Usuario)biblio.getListaUsuarios().get(i)).getCorreo().equals(correo)){
                    System.out.println("Se ha iniciado sesión correctamente.");
                    identificacion = true;
                    validacion=1;
                    return validacion; 
                }
            }
            i++;
        }
        if(!identificacion){
            System.out.println("No se ha encontrado ningun Usuario con esos datos, por favor, indíque de nuevo los datos.");
            validacion = 0;
            return validacion;
        }
        return validacion;
    }

    public static void mostrarUsuarios(ArrayList<Usuario> listaUsuarios){
        System.out.println("Estos son los usuarios que hay:");
        for(int i=0; i<listaUsuarios.size(); i++){
            System.out.println(listaUsuarios.get(i));
        }
    }  

    public void mostrarLibrosReservados(){
        for(int i=0; i<this.getListaReservas().size(); i++){
            this.getListaReservas().get(i).mostrarReservaChula();
        }
    }
    public void cambiarContraseña() {
        int opcion = 0;
        System.out.println("Procedemos a actualizar sus datos, que desea cambiar?");
        System.out.println("                 1.Teléfono"                       );
        System.out.println("                 2.Correo"                         );
        opcion = lector.nextInt();
        lector.nextLine();
        
        switch (opcion) {
            case 1:
                System.out.println("Escriba su nuevo teléfono:");
                this.setTelefono(lector.nextInt());
                lector.nextLine();
                System.out.println("El teléfono se ha actualizado a: " + getTelefono());
                break;
            case 2:
                System.out.println("Escriba su nuevo correo:");
                this.setCorreo(lector.nextLine());
                System.out.println("El correo se ha actualizado a: " + getCorreo());
                break;
            default:
                System.out.println("La opción introducida no es correcta, intentelo de nuevo.");
                opcion = lector.nextInt();
                lector.nextLine();
                break;
        }
    }
}
