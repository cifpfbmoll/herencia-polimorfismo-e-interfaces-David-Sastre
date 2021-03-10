/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.com.bibliotecapart2;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author David
 */
public class Main {
    public static  Scanner lector = new Scanner (System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Biblioteca biblio = crearBiblioteca();

        Usuario Usu = new Usuario();
        System.out.println("El primer paso es crear un Administrador.");
        crearAdministrador(biblio);
        iniciarSesion(biblio, Usu);   
    }
    
    public static Biblioteca crearBiblioteca(){
        System.out.println("===================================================");
        System.out.println("        BIENVENIDO AL GESTOR DE BIBLIOTECAS ");
        System.out.println("===================================================");
        System.out.println("Indique el nombre de la biblioteca:");
        String nombreBiblio = lector.nextLine();
        Biblioteca biblio = new Biblioteca(nombreBiblio);  
        return biblio;
    }

    private static void crearAdministrador(Biblioteca biblio) {
        Bibliotecario B1 = new Bibliotecario();
        B1.solicitarDatosPersona();
        biblio.getListaPersonal().add(B1);
    }

    private static void iniciarSesion(Biblioteca biblio, Usuario Usu) {
        int opcion = 0;
        int validacion = 0;
        System.out.println("==================================================================");
        System.out.println("                Bienvenido a " + biblio.getNombreBiblio());
        System.out.println("==================================================================");
        System.out.println("                Seleccione cómo desea iniciar sesión: ");
        System.out.println("                        1. Administrador"                            );
        System.out.println("                        2. Usuario"                                  );
        System.out.println("==================================================================");
        System.out.println("Seleccione una opción del [1-2]:");
        opcion = lector.nextInt();
        lector.nextLine();
        switch (opcion) {
            case 1:
                validacion = Bibliotecario.identificacionBibliotecario(biblio);
                if(validacion == 0){
                    System.out.println("Este bibliotecario no está registrado.");
                    iniciarSesion(biblio, Usu);
                }
                menuAdministrador(biblio, Usu);
                break;
            case 2:
                validacion = Usuario.identificacionUsuario(biblio);
                if(validacion == 0){
                    System.out.println("Usuario no registrado.");
                    iniciarSesion(biblio, Usu);
                }
                menuUsuario(biblio, Usu);
                break;
            default:
                System.out.println("Indique una opción entre el [1-2]:");
                opcion = lector.nextInt();
                break;
        }
    }
    /**
     *
     * @param biblio
     * @param Usu
     */
    public static void menuAdministrador(Biblioteca biblio, Usuario Usu){
        int opcion = 0;
        System.out.println("=====================================");
        System.out.println("BIENVENIDO " + Usu.getNombre() + Usu.getApellido1());
        System.out.println("=====================================");
        System.out.println("1. Gestionar Reservas");
        System.out.println("2. Gestionar Personal");
        System.out.println("3. Gestionar Usuarios");
        System.out.println("4. Cambiar datos");
        System.out.println("5. Volver");
        System.out.println("=====================================");
        System.out.println("Seleccione una opción del [1-5]:");
        opcion = lector.nextInt();
        lector.nextLine();
        switch(opcion) {
            case 1:
                gestorReservas(biblio, Usu);
                break;
            case 2:
                gestorPersonal(biblio, Usu);
                break;
            case 3:
                gestorUsuarios(biblio, Usu);
                break;
            case 4:
                int i = 0;
                boolean encontrado = false;
                System.out.println("Escribe su contraseña:");
                String contraseña = lector.nextLine();
                
                while(!encontrado && i<biblio.getListaPersonal().size()){
                    if(biblio.getListaPersonal().get(i) instanceof Bibliotecario){
                        if(((Bibliotecario)biblio.getListaPersonal().get(i)).getContraseña().equals(contraseña)){
                            encontrado = true;
                            ((Bibliotecario)biblio.getListaPersonal().get(i)).cambiarContraseña();
                        }
                    }
                    i++;
                }
                if(!encontrado){
                    System.out.println("Contraseña Incorrecta");
                }
                break;
            case 5:
                iniciarSesion(biblio, Usu);
                break;
            default:
                System.out.println("Seleccione una opción del [1-5]");
                opcion = lector.nextInt();
                break;
        }  
    }
    public static void menuUsuario(Biblioteca biblio, Usuario Usu){
        int opcion = 0;
        boolean menuUsuario = false;
        while(!menuUsuario){
            System.out.println("==================================");
            System.out.println("HAS ACCEDIDO COMO USUARIO");
            System.out.println("==================================");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Mostrar los libros disponibles");
            System.out.println("3. Buscar libro por su ISBN");
            System.out.println("4. Buscar libro por su título");
            System.out.println("5. Mostrar libros reservados");
            System.out.println("6. Cambiar el teléfono o el correo");
            System.out.println("7. Salir");
            System.out.println("======================================================");
            System.out.println("Seleccione una opción del [1-7]:");
            opcion = lector.nextInt();
            lector.nextLine();
        
            switch (opcion) {
                case 1:
                    biblio.mostrarLibros();
                    break;
                case 2:
                    biblio.mostrarLibrosDisponibles();
                    break;
                case 3:
                    Libro.buscarLibroISBN(biblio.getListaLibros());
                    break;
                case 4:
                    Libro.buscarLibroTitulo(biblio.getListaLibros());
                    break;
                case 5:
                    Usu.mostrarLibrosReservados();
                    break;
                case 6:
                    int i = 0;
                    boolean encontrado = false;
                    
                    System.out.println("Escribe tu teléfono registrado:");
                    int telefono = lector.nextInt();
                    lector.nextLine();
                    
                    while(!encontrado && i<biblio.getListaUsuarios().size()){
                        if(biblio.getListaUsuarios().get(i) instanceof Usuario){
                            if(((Usuario)biblio.getListaUsuarios().get(i)).getTelefono()==telefono){
                                encontrado = true;
                                ((Usuario)biblio.getListaUsuarios().get(i)).cambiarContraseña();
                            }
                        }
                    }
                    if(!encontrado){
                        System.out.println("El teléfono introducido no es correcto.");
                    }
                    break;
                case 7:
                    iniciarSesion(biblio, Usu);
                    break;
                default:
                    System.out.println("La oopción escogida no es correcta, intentelo de nuevo.");
                    opcion = lector.nextInt();
                    break;
            }
        }
    }
    public static void gestorReservas(Biblioteca biblio, Usuario Usu){
        int opcion = 0;
        boolean gestorReservas = false;
        while (!gestorReservas){
            System.out.println("==============================");
            System.out.println("Bienvenido al gestor de Reservas");
            System.out.println("==============================");
            System.out.println("¿Qué acción deseas realizar?");
            System.out.println("1. Añadir Libro.");
            System.out.println("2. Eliminar Libro.");
            System.out.println("3. Buscar Libro por ISBN.");
            System.out.println("4. Buscar Libro por título.");
            System.out.println("5. Lista de Libros");
            System.out.println("6. Lista de Libros Disponibles");
            System.out.println("7. Reservar Libros");
            System.out.println("8. Devolver Libro");
            System.out.println("9. Mostrar las reservas del Usuario");
            System.out.println("10. Salir");
            opcion = lector.nextInt();
            lector.nextLine();
            switch (opcion){
                case 1: 
                    Libro.añadirLibro(biblio.getListaLibros());
                    break;
                case 2:
                    Libro.eliminarLibro(biblio.getListaLibros());
                    break;
                case 3:
                    Libro.buscarLibroISBN(biblio.getListaLibros());
                    break;
                case 4:
                    Libro.buscarLibroTitulo(biblio.getListaLibros());
                    break;
                case 5:
                    biblio.mostrarLibros();
                    break;
                case 6:
                    biblio.mostrarLibrosDisponibles();
                    break;
                case 7:
                    Reserva.reservarLibro(biblio.getListaLibros(), biblio.getListaUsuarios());
                    break;
                case 8:
                    Reserva.devolverLibro(biblio.getListaLibros(), biblio.getListaUsuarios());
                    break;
                case 9:
                    Usu.mostrarLibrosReservados();
                    break;
                case 10:
                    menuAdministrador(biblio, Usu);
                default:
                    System.out.println("Pon una opción correcta:");
                    opcion = lector.nextInt();
                    lector.nextLine();
                    break;                   
                }    
            }
    }
    public static void gestorPersonal(Biblioteca biblio, Usuario Usu){
        int opcion =0;
        boolean gestorPersonal = false;
        while (!gestorPersonal){
            System.out.println("================================");
            System.out.println("Bienvenido al gestor de Personal");
            System.out.println("================================");
            System.out.println("¿Qué acción deseas realizar?");
            System.out.println("1. Añadir Trabajador.");
            System.out.println("2. Eliminar Trabajador.");
            System.out.println("3. Ver Personal.");
            System.out.println("4. Volver.");
            opcion = lector.nextInt();
            lector.nextLine();
            switch(opcion){
                case 1:
                    Bibliotecario B1 = new Bibliotecario();
                    B1.solicitarDatosPersona();
                    biblio.getListaPersonal().add(B1);
                    break;
                case 2:
                    Persona.eliminarPersona(biblio.getListaPersonal());
                    break;
                case 3:
                    Persona.mostrarPersonal(biblio.getListaPersonal());
                    break;
                case 4:
                    System.out.println("======================================");
                    System.out.println("GRACIAS POR USAR EL GESTOR DE PERSONAL");
                    System.out.println("======================================");
                    menuAdministrador(biblio, Usu);
                    break;
                }
        }
    }
    public static void gestorUsuarios(Biblioteca biblio, Usuario Usu){
        int opcion = 0;
        boolean gestorUsuarios = false;
        while(!gestorUsuarios){
            System.out.println("================================");
            System.out.println("BIENVENIDO AL GESTOR DE USUARIO");
            System.out.println("================================");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Encontrar y eliminar usuario");
            System.out.println("3. Reservar libros");
            System.out.println("4. Mostrar todos los usuarios de la biblioteca");
            System.out.println("5. Volver");
            opcion = lector.nextInt();
            lector.nextLine();
            switch (opcion) {
                case 1:
                    Usu.solicitarDatosPersona();
                    biblio.getListaPersonal().add(Usu);
                    break;
                case 2:
                    Persona.eliminarUsuario(biblio.getListaUsuarios());
                    break;
                case 3:
                    Reserva.reservarLibro(biblio.getListaLibros(), biblio.getListaUsuarios());
                    break;
                case 4:
                    Usuario.mostrarUsuarios(biblio.getListaUsuarios());
                    break;
                case 5:
                    System.out.println("======================================");
                    System.out.println("GRACIAS POR USAR EL GESTOR DE USUARIO");
                    System.out.println("======================================");
                    menuAdministrador(biblio, Usu);
                    break;
                default:
                    System.out.println("Indica una opción entre el [1-5]");
                    opcion = lector.nextInt();
                    lector.nextLine();
                    break;
            }
        }
    }
}
