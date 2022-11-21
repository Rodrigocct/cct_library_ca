/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary;

import cctlibrary.data.Books;
import cctlibrary.entities.Book;
import cctlibrary.enums.BookSearchEnum;
import cctlibrary.utils.InputUtilities;
import cctlibrary.utils.MySearchingUtils;
import cctlibrary.utils.MySortingUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rodrigo
 */
public class Main {

    private Books books;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        loadDatabase();
        init();
    }

    public void init() {

        // Clase utilizada para controlar y validar el input del usuario.
        InputUtilities myInput = new InputUtilities();

        // variable para leer la opcion seleccionada por el usuario.
        int listOption;
        //variable para controlar el bucle while, que no finaliza si el usuario no seleciona la opcion 9) EXIT
        boolean exitOption = false;
        while (!exitOption) {
            try {

                Scanner s = new Scanner(System.in);
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("****************** MENU SYSTEM ******************");
                System.out.println("1) Search for a specific book by title and/or author name.");
                System.out.println("2) List all books by title and/or author name alphabetical order");
                System.out.println("3) LIST ALL GROUPS, SHOWING THE COACH AND THE NUMBER OF SWIMMERS IN THE GROUP");
                System.out.println("4) LIST GROUPS OF A PARTICULAR TYPE");
                System.out.println("5) LIST GROUPS BASED ON THE DAY THEY TRAIN");
                System.out.println("6) LIST ALL THE SWIMMERS IN A PARTICULAR GROUP");
                System.out.println("7) LIST THE SWIMMERS COACHED BY A PARTICULAR COACH");
                System.out.println("8) LIST ALL SWIMMERS IN THE CLUB");
                System.out.println("9) EXIT");
                System.out.println("*************************************************");
                System.out.print("Input option number --> ");
                // Se espera que el usuario ingrese su opcion y que el valor ingresado sea numerico
                // Si no es numerico, salta al catch, imprime el mensaje y vuelve a solicitar
                listOption = s.nextInt();

                switch (listOption) {
                    case 1:
                        System.out.println("------------------------------------------");
                        System.out.println("Search a book by title and/or author name.");
                        System.out.println("------------------------------------------");

                        // Para la busqueda, primero se imprime las opciones
                        System.out.println(BookSearchEnum.listAllOptions());
                        // se espera que el usuario seleccione su opcion
                        int searchOption = myInput.getUserInt("Input search option --> ", 1, BookSearchEnum.values().length);
                        switch (searchOption) {
                            case 1:
                                String authorname = myInput.getUserText("Input Author name --> ");
                                int linearSearchBook = new MySearchingUtils().linearSearchBookByAuthor(books.getListBooks(), authorname);
                                if (linearSearchBook > -1) {
                                    System.out.println("Book match with --> " + books.getListBooks().get(linearSearchBook).toString());
                                } else {
                                    System.out.println("No Book match for author --> " + authorname);
                                }
                                break;
                            case 2:
                                String title = myInput.getUserText("Input title --> ");
                                ArrayList<Book> booksByTitle = new MySearchingUtils().linearSearchBookByTitle(books.getListBooks(), title);
                                if (!booksByTitle.isEmpty()) {
                                    System.out.println("Book(s) match(s) for title --> " + title);
                                    booksByTitle.forEach((b) -> {
                                        System.out.println(b);
                                    });
                                } else {
                                    System.out.println("No Book match for title --> " + title);
                                }
                                break;
                            default:
                                // Si la opcion seleccionada no corresponde a ninguna de la lista
                                System.out.println("Input option incorrect");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("List all books by title and/or author name alphabetical order");
                        System.out.println("-------------------------------------------------------------");
                        Book[] list;
                        list = books.getListBooks().toArray(new Book[books.getListBooks().size()]);
                        MySortingUtils ms = new MySortingUtils();
                        
                        // Para la busqueda, primero se imprime las opciones
                        System.out.println(BookSearchEnum.listAllOptions());
                        // se espera que el usuario seleccione su opcion
                        int sortOption = myInput.getUserInt("Input sorting option --> ", 1, BookSearchEnum.values().length);
                        switch (sortOption) {
                            case 1:
                                 ms.bubbleSortByAuthor(list);
                                break;
                            case 2:
                                 ms.bubbleSortByTitle(list);
                                break;
                            default:
                                // Si la opcion seleccionada no corresponde a ninguna de la lista 
                                System.out.println("Input option incorrect");
                                break;
                        }
                        for (int i = 0; i<list.length; i++) {
                            System.out.println(list[i].toString());
                        }
                        break;

                    case 3:
                        System.out.println("\t##############################");
                        System.out.println("\t######SWIMMERS GROUPS#########");
                        System.out.println("\t##############################");

                        break;

                    case 4:
                        System.out.println("\t##############################");
                        System.out.println("\t####### GROUPS BY TYPE #######");
                        System.out.println("\t##############################");

                        break;

                    case 5:
                        System.out.println("\t##############################");
                        System.out.println("\t#####GROUPS BY DAY TRAIN######");
                        System.out.println("\t##############################");

                        break;

                    case 6:
                        System.out.println("\t##############################");
                        System.out.println("\t######SWIMMERS BY GROUP#######");
                        System.out.println("\t##############################");
                        // se espera el usuario ingrese un grupo en particular puede ser el nombre exacto o un extracto del nombre
                        String group = myInput.getUserText("Enter group name: ");

                        break;

                    case 7:
                        System.out.println("\t##############################");
                        System.out.println("\t#####SWIMMERS COACHED BY######");
                        System.out.println("\t##############################");
                        // De igual forma que el caso 6, se ingresa el nombre completo o un extracto del coach
                        // Y se retorna todos lo coach que coinciden con el texto ingresado, sin importar que se escriba en MAYUS o MINUS
                        String coach = myInput.getUserText("Enter coach name: ");

                        break;
                    case 8:
                        System.out.println("\t##############################");
                        System.out.println("\t######### SWIMMERS ###########");
                        System.out.println("\t##############################");

                        break;

                    case 9:
                        // El usuario ingresa la opcion 6 y esto hace finalizar el bucle while al setear exitOpcion = true
                        System.out.println("EXIT!! GOOD BYE.");
                        exitOption = true;
                        break;

                    default:
                        // Si la opcion seleccionada no corresponde a ninguna de la lista Ej. El usuario ingresa 9
                        System.out.println("SELECTED OPTION DON'T EXISTS");
                        break;
                }

            } catch (InputMismatchException ime) {
                // Si la opcion ingresada por el usuario no es un numero, 
                // llega a este punto, se imprime el mensaje y vuelve a mostrar la lista de opciones
                System.out.println("*** SELECTED OPTION IS INCORRECT ***");
            }
        }
    }

    public void loadDatabase() {
        books = new Books();
        books.openFile();
        books.loadData();
    }

}
