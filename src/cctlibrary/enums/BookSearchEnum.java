/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.enums;

/**
 *
 * @author rodrigo
 * Enum Books search Options
 */
public enum BookSearchEnum {
    AUTHOR_NAME {
        @Override
        public String toString() {
        
            return "AUTHOR NAME";
        }        
    },
    TITLE {
        @Override
        public String toString() {
        
            return "TITLE";
        }        
    };
    // Metodo que recupera una opcion de busqueda especifica en funcion a su posicion en el array
    public static BookSearchEnum getOption(int option){
        
        BookSearchEnum[] bookSearchEnum = BookSearchEnum.values();
        
        return bookSearchEnum[option];
    }
    
    // Metodo que retorna la lista completa de opciones de filtro
    public static String listAllOptions(){
        
        String menu = "";
        
        int num = 1; //start at 1 because starting at 0 makes no sense to humans :)
        //loop through all values in the enum
        for(BookSearchEnum e: values()){            
            menu = menu + "\n" + num + ")\t" + e.toString();
            num++;
        }        
        return menu;
                
    }
    
    
}
