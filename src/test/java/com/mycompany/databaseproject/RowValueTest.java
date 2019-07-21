/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.databaseproject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
/**
 *
 * @author NicholasBocchini
 */
public class RowValueTest {
    
    @Test
    public void testGetType()
    {
        System.out.println("Test getType()");
        RowValue row = new RowValue(1, "int", true);
        String expResult = "int";
        
        String result = row.getType();
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetValue()
    {
        System.out.println("Test getValue()");
        RowValue row1 = new RowValue(1, "int", true);
        RowValue row2 = new RowValue("test", "string", false);
        RowValue row3 = new RowValue(1.1f, "float", false);
        RowValue row4 = new RowValue(true, "boolean", false);
        
        ArrayList<Object> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add("test");
        expResult.add(1.1f);
        expResult.add(true);
        
        ArrayList<Object> result = new ArrayList();
        result.add(row1.getValue());
        result.add(row2.getValue());
        result.add(row3.getValue());
        result.add(row4.getValue());
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals()
    {
        System.out.println("Test equals()");
        RowValue row1 = new RowValue(1, "int", true);
        RowValue row2 = new RowValue("test", "string", false);
        RowValue row3 = new RowValue(1.1f, "float", false);
        RowValue row4 = new RowValue(true, "boolean", false);
        
        boolean[] result = new boolean[4];
        result[0] = row1.equals(1);
        result[1] = row2.equals("test");
        result[2] = row3.equals(1.1f);
        result[3] = row4.equals(true);
        
        boolean[] expResult = {true, true, true, true};
        
        assertEquals(Arrays.toString(result), Arrays.toString(expResult));
    }
}
