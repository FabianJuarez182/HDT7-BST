/**
 * 
 * Copyright (C), 2022-2023, FabianJuarez
 * FileName: view
 * Author:   Fabián Juárez
 * Date:     08/04/2022
─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
─██████████████─██████████████─██████████████───██████████─██████████████─██████──────────██████────────────██████─██████──██████─██████████████─████████████████───██████████████─██████████████████─
─██░░░░░░░░░░██─██░░░░░░░░░░██─██░░░░░░░░░░██───██░░░░░░██─██░░░░░░░░░░██─██░░██████████──██░░██────────────██░░██─██░░██──██░░██─██░░░░░░░░░░██─██░░░░░░░░░░░░██───██░░░░░░░░░░██─██░░░░░░░░░░░░░░██─
─██░░██████████─██░░██████░░██─██░░██████░░██───████░░████─██░░██████░░██─██░░░░░░░░░░██──██░░██────────────██░░██─██░░██──██░░██─██░░██████░░██─██░░████████░░██───██░░██████████─████████████░░░░██─
─██░░██─────────██░░██──██░░██─██░░██──██░░██─────██░░██───██░░██──██░░██─██░░██████░░██──██░░██────────────██░░██─██░░██──██░░██─██░░██──██░░██─██░░██────██░░██───██░░██─────────────────████░░████─
─██░░██████████─██░░██████░░██─██░░██████░░████───██░░██───██░░██████░░██─██░░██──██░░██──██░░██────────────██░░██─██░░██──██░░██─██░░██████░░██─██░░████████░░██───██░░██████████───────████░░████───
─██░░░░░░░░░░██─██░░░░░░░░░░██─██░░░░░░░░░░░░██───██░░██───██░░░░░░░░░░██─██░░██──██░░██──██░░██────────────██░░██─██░░██──██░░██─██░░░░░░░░░░██─██░░░░░░░░░░░░██───██░░░░░░░░░░██─────████░░████─────
─██░░██████████─██░░██████░░██─██░░████████░░██───██░░██───██░░██████░░██─██░░██──██░░██──██░░██────██████──██░░██─██░░██──██░░██─██░░██████░░██─██░░██████░░████───██░░██████████───████░░████───────
─██░░██─────────██░░██──██░░██─██░░██────██░░██───██░░██───██░░██──██░░██─██░░██──██░░██████░░██────██░░██──██░░██─██░░██──██░░██─██░░██──██░░██─██░░██──██░░██─────██░░██─────────████░░████─────────
─██░░██─────────██░░██──██░░██─██░░████████░░██─████░░████─██░░██──██░░██─██░░██──██░░░░░░░░░░██────██░░██████░░██─██░░██████░░██─██░░██──██░░██─██░░██──██░░██████─██░░██████████─██░░░░████████████─
─██░░██─────────██░░██──██░░██─██░░░░░░░░░░░░██─██░░░░░░██─██░░██──██░░██─██░░██──██████████░░██────██░░░░░░░░░░██─██░░░░░░░░░░██─██░░██──██░░██─██░░██──██░░░░░░██─██░░░░░░░░░░██─██░░░░░░░░░░░░░░██─
─██████─────────██████──██████─████████████████─██████████─██████──██████─██████──────────██████────██████████████─██████████████─██████──██████─██████──██████████─██████████████─██████████████████─
─────────────────────────────────────
 * @author Fabian Juarez
 */
import java.util.Scanner;
public class view {
        //---------------------------PROPIEDADES--------------------------
        private Scanner scan;

        //---------------------------METODOS------------------------------
        public view(){
            scan = new Scanner(System.in); // Scanner
        }    
        /*****************************************************************
     * retorna el valor del elemento seleccionado por el usuario
     * @return numMenu
     */
    public int menu(){ //Menu principal para que el usuario eliga la opcion a realizar
        String salir = "";
        int numMenu = 0;
        String tmpTexto = "";
        boolean isNumeric = false;
        while(!salir.equalsIgnoreCase("si")){
            //Se imprime el menu en pantalla y se le pide al usuario un numero del menu
            System.out.println("\n************************* Escoja la opcion que desea utilizar ************************************\n");
            System.out.println("1. agregar");
            System.out.println("2. editar (si no se encuentra se agregara)");
            System.out.println("3. eliminar");
            System.out.println("4. ver traduccion");
            System.out.println("5. salir");
            System.out.println("\n************ Por, favor elija la opcion que desea ejecutar **********\n");
            tmpTexto = scan.nextLine();

            // Se verifica que el numero que dio el usuario fue valido
            isNumeric = tmpTexto.chars().allMatch( Character::isDigit );
            if (isNumeric && !tmpTexto.isEmpty()){
                numMenu = Integer.parseInt(tmpTexto);
                salir = "si";
            }
            while (tmpTexto.isEmpty()||!isNumeric || numMenu < 1 || numMenu > 5) {
                System.out.println("ERROR, ingresar una opcion de menu mayor que 0" + " o menor que 5");
                tmpTexto = scan.nextLine();
                isNumeric = tmpTexto.chars().allMatch( Character::isDigit );
                numMenu = 0;
                if (isNumeric&&!tmpTexto.isEmpty()){
                    numMenu = Integer.parseInt(tmpTexto);
                    salir = "si";
                    }
                }
            }
        return numMenu;
    }

    public void salir(){
        System.out.println(" ------------ Gracias por utilizar nuestro programa ------------ \n"); // Mensaje que se mostrara al cerrar el programa
        System.exit(0);
        scan.close();
    }

    
    /** 
     * @param mensaje
     */
    public void mensaje(String mensaje){
        System.out.println(mensaje);
    }
}
