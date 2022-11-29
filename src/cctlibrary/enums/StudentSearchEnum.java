/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.enums;

/**
 *
 * @author rodrigo
 * Enum Students search Options
 */
public enum StudentSearchEnum {
    NAME {
        @Override
        public String toString() {
        
            return "NAME";
        }        
    },
    ID {
        @Override
        public String toString() {
        
            return "ID";
        }        
    };
    // Metodo que recupera una opcion de busqueda especifica en funcion a su posicion en el array
    public static StudentSearchEnum getOption(int option){
        
        StudentSearchEnum[] searchOption = StudentSearchEnum.values();
        
        return searchOption[option];
    }
    
    // Metodo que retorna la lista completa de opciones de filtro
    public static String listAllOptions(){
        
        String menu = "";
        
        int num = 1; //start at 1 because starting at 0 makes no sense to humans :)
        //loop through all values in the enum
        for(StudentSearchEnum e: values()){            
            menu = menu + "\n" + num + ")\t" + e.toString();
            num++;
        }        
        return menu;
                
    }
    
    
}
