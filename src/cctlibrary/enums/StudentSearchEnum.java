/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.enums;

/**
 *
 * @author rodrigo & anastasiia
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
    // thismethod that retrieves a specific lookup option in function of its position in the array
    public static StudentSearchEnum getOption(int option){
        
        StudentSearchEnum[] searchOption = StudentSearchEnum.values();
        
        return searchOption[option];
    }
    
    // Method that returns the full list of filter options
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
