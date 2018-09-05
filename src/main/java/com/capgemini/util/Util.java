package com.capgemini.util;

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

}
