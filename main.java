/**
 *
 * Copyright (C), 2022-2023, FabianJuarez
 * FileName: main
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
        String  palabrasTraducidaIngles;
        String  palabrasTraducidaFrances;
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
                    array = new String[3];
                    mivista.mensaje("Ingrese las palabras en este orden: ingles,espaniol,frances: Ejempo(|house,casa,loger|)");
                    palabras = scan.nextLine();
                    array = palabras.split(",");
                    palabra = new association<String, String>(array[2].trim(),array[1].trim());
                    palabra2 = new association<String, String>(array[0].trim(),array[1].trim());
                    treeFrench.deleteKey(palabra);
                    treeEnglish.deleteKey(palabra2);
                    // print inorder traversal of the BST
                    System.out.println("**************************Impresion de las palabras en Frances en orden**************************");
                    treeFrench.inorder();
                    System.out.println("**************************Impresion de las palabras en Ingles en orden**************************");
                    treeEnglish.inorder();
                break;
                case 4:
                while(obj2.hasNextLine()){
                    palabrasTraducir = obj2.nextLine();
                    ArrayPalabras = palabrasTraducir.split("\\s+");
                    for(int i=0;i<ArrayPalabras.length;i++){
                        ArrayPalabras[i] = ArrayPalabras[i].replaceAll("\\.", "");
                        ArrayPalabras[i] = ArrayPalabras[i].replaceAll("\\,", "");
                        palabrasTraducidaFrances = treeFrench.translateKey(ArrayPalabras[i]);
                        palabrasTraducidaIngles = treeEnglish.translateKey(ArrayPalabras[i]);
                        if(!ArrayPalabras[i].equals(palabrasTraducidaFrances) && ArrayPalabras[i].equals(palabrasTraducidaIngles))
                            palabrasImprimir = palabrasImprimir + palabrasTraducidaFrances + " ";
                        else if(ArrayPalabras[i].equals(palabrasTraducidaFrances)&& !ArrayPalabras[i].equals(palabrasTraducidaIngles)){
                            palabrasImprimir = palabrasImprimir + palabrasTraducidaIngles + " ";
                        }
                        else{
                            palabrasImprimir = palabrasImprimir + "*" + ArrayPalabras[i]+ "*" + " ";
                        }
                    }
                    System.out.print("Texto traducido: " + palabrasImprimir + "." + "\n\n");
                }
                break;
                case 5:
                mivista.salir();
                break;
            }
        }
    }
}
