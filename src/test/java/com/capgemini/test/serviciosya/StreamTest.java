package com.capgemini.test.serviciosya;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    public static void main(String [] args){

        List<Simpson> simpsons = new ArrayList<Simpson>();

        simpsons.add(new Simpson("Homer","Simpson",34));
        simpsons.add(new Simpson("Marge","Simpson",30));
        simpsons.add(new Simpson("Lisa","Simpson",14));
        simpsons.add(new Simpson("Bart","Simpson",12));
        simpsons.add(new Simpson("Maggie","Simoson",1));

        List<Simpson> filtrados = Simpson.filtrarPorEdad(18,1,simpsons);

        for (Simpson item : filtrados){
            System.out.println(item.getName());
        }
    }


}
class Simpson{

    private  String name;
    private  String  lastName;
    private  Integer edad;
    public Simpson(){

    }
    public Simpson(String name, String lastName, Integer edad){
        this.name = name;
        this.edad = edad;
        this.lastName = lastName;
    }

    public  static  List <Simpson> filtrarPorEdad(Integer edad,int m, List<Simpson> simpsons){

        List<Simpson> resul = new ArrayList<>();
        if(m>0) {
            for (Simpson s : simpsons) {
                if (s.getEdad() > edad)
                    resul.add(s);
            }
        }
            else
            {
                for (Simpson s : simpsons) {
                    if (s.getEdad() < edad)
                        resul.add(s);
                }
            }

        return  resul;
    }


    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
