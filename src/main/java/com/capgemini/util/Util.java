package com.capgemini.util;


import org.apache.commons.lang3.StringUtils;

public class Util {

    public static boolean isNumeric(String cad){
        boolean bool = Boolean.TRUE;

        try{
            Integer.valueOf(cad);
        }catch (Exception e){
            bool = Boolean.FALSE;
        }
        return  bool;
    }
    public static boolean isEmpty(String string){

        if(StringUtils.isEmpty(string)) //LIBRERIA StringUtils DE APACHE PARA STRING
            return  true;
        if(string != null && isEmpty(string)){
            return true;
        }
        return false;
    }
    
    public static void main (String []args){
        
        System.out.println(Util.isEmpty(""));

    }

    

}
