package com.capgemini.test;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestListCollection {

    @Test
    public void testSize(){

        //Arrange
        List <String> list = new ArrayList <> ();
        list.add("PRIMER ELEMENTO");
        list.add("SEGUNDO ELEMENTO");
        list.add("TERCER ELEMENTO");

        //Act
        int i = 3;
        int j = list.size();

        //Assert
        Assert.assertEquals(i,j);
    }
    @Test
    public void testIsEmpty(){

        //Arrange
        List <String> list = new ArrayList <> ();

        //Act
        int i = 0;
        int j = list.size();

        //Assert
        Assert.assertEquals(i,j);
    }


}
