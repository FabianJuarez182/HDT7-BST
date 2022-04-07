/**
 *
 * Copyright (C), 2022-2023, FabianJuarez
 * FileName: main
 * Author:   Fabián Juárez
 * Date:     06/04/2022
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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class main {
    /**
    * @param args
    * @throws FileNotFoundException
    */
    public static void main(String[] args) throws FileNotFoundException{
        //Atributos
        int numMenu;
        File doc = new File("diccionario.txt");
        File traducir = new File("texto.txt");
        view mivista = new view();
        Scanner obj = new Scanner(doc);
        Scanner obj2 = new Scanner(traducir);
        Scanner scan = new Scanner(System.in);
        BinarySearchTree treeFrench = new BinarySearchTree();
        BinarySearchTree treeEnglish = new BinarySearchTree();
        String palabras = new String();
        String palabrasTraducir = new String();
        String palabrasImprimir = new String();
        String[] array;
        String[] ArrayPalabras;
        association<String, String> palabra;
        association<String, String> palabra2;

        while (obj.hasNextLine()){
            array = new String[3];
            palabras = obj.nextLine();
            array = palabras.split(",");
            palabra = new association<String, String>(array[2].trim(),array[1].trim());
            palabra2 = new association<String, String>(array[0].trim(),array[1].trim());
            treeFrench.insert(palabra);
            treeEnglish.insert(palabra2);
        }
        // print inorder traversal of the BST
        treeFrench.inorder();
        System.out.println("*****************************************************");
        treeEnglish.inorder();
        while(obj2.hasNextLine()){
            palabrasTraducir = obj2.nextLine();
            ArrayPalabras = palabrasTraducir.split("\\s+");
            for(int i=0;i<ArrayPalabras.length;i++)
                palabrasImprimir = palabrasImprimir + ArrayPalabras[i] + " ";
            System.out.print("Texto sin traducir: " + palabrasImprimir + "\n\n");
        }

        numMenu = -1;
        while(numMenu != 5){ //Despliega el menu principal
            numMenu = mivista.menu();
            switch (numMenu) {
                case 1:
                    array = new String[3];
                    mivista.mensaje("Ingrese las palabras en este orden: ingles,espaniol,frances: Ejempo(|house,casa,loger|)");
                    palabras = scan.nextLine();
                    array = palabras.split(",");
                    palabra = new association<String, String>(array[2].trim(),array[1].trim());
                    palabra2 = new association<String, String>(array[0].trim(),array[1].trim());
                    treeFrench.insert(palabra);
                    treeEnglish.insert(palabra2);
                            // print inorder traversal of the BST
                    System.out.println("**************************Impresion de las palabras en Frances en orden**************************");
                    treeFrench.inorder();
                    System.out.println("**************************Impresion de las palabras en Ingles en orden**************************");
                    treeEnglish.inorder();
                break;
                case 2:
                    array = new String[3];
                    mivista.mensaje("Ingrese las palabras en este orden: ingles,espaniol,frances: Ejempo(|house,casa,loger|)");
                    palabras = scan.nextLine();
                    array = palabras.split(",");
                    palabra = new association<String, String>(array[2].trim(),array[1].trim());
                    palabra2 = new association<String, String>(array[0].trim(),array[1].trim());
                    treeFrench.insert(palabra);
                    treeEnglish.insert(palabra2);
                        // print inorder traversal of the BST
                    System.out.println("**************************Impresion de las palabras en Frances en orden**************************");
                    treeFrench.inorder();
                    System.out.println("**************************Impresion de las palabras en Ingles en orden**************************");
                    treeEnglish.inorder();
                break;
                case 3:

                break;
                case 4:

                break;
                case 5:
                mivista.salir();
                break;
            }
        }
    }
}
