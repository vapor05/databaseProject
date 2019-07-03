/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.databaseproject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author NicholasBocchini
 */
public class CSVParserTest {
    /**
     * Test of closeSource method, of class CSVParser.
     * @throws java.io.FileNotFoundException
     */
    
    @Test
    public void testCloseSource() throws FileNotFoundException {
        System.out.println("closeSource");
        CSVParser read;
        read = new CSVParser("/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple.csv",
                             ",",
                             "/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple_header.txt");
        read.closeSource();
    }

    /**
     * Test of hasNextLine method, of class CSVParser.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testHasNextLine() throws FileNotFoundException {
        System.out.println("hasNextLine");
        CSVParser read;
        read = new CSVParser("/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple.csv",
                             ",",
                             "/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple_header.txt");
        boolean expResult = true;
        boolean result = read.hasNextLine();
        assertEquals(expResult, result);
        read.closeSource();
    }

    /**
     * Test of nextRow method, of class CSVParser.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testNextRow() throws FileNotFoundException {
        System.out.println("nextRow");
        CSVParser read;
        read = new CSVParser("/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple.csv",
                             ",",
                             "/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple_header.txt");
        ArrayList<HashMap<String, String>> expResult = new ArrayList<>();
        
        HashMap<String,String> map1 = new HashMap<>();
        map1.put("column1","1");
        
        HashMap<String,String> map2 = new HashMap<>();
        map2.put("column2","one");

        HashMap<String,String> map3 = new HashMap<>();
        map3.put("column3","test1");
        
        HashMap<String,String> map4 = new HashMap<>();
        map4.put("column4","1/1/2010");
        
        expResult.add(map1);
        expResult.add(map2);
        expResult.add(map3);
        expResult.add(map4);
        
        ArrayList<HashMap<String, String>> result = read.nextRow();
        assertEquals(expResult, result);
        
        read.closeSource();
    }

    /**
     * Test of isHeaderRow method, of class CSVParser.
     * @throws java.io.FileNotFoundException
     */
    @Test
    @Disabled("skip for now")
    public void testIsHeaderRowTrue() throws FileNotFoundException {
        System.out.println("isHeaderRow-True");
        CSVParser read;
        read = new CSVParser("/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple.csv",
                             ",",
                             "/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple_header.txt");
        boolean expResult = true;
        boolean result = read.isHeaderRow();
        assertEquals(expResult, result);
        read.closeSource();
    }

    /**
     * Test of getColumnNumber method, of class CSVParser.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetColumnNumber() throws FileNotFoundException {
        System.out.println("getColumnNumber");
        CSVParser read;
        read = new CSVParser("/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple.csv",
                             ",",
                             "/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple_header.txt");
        int expResult = 4;
        int result = read.getColumnNumber();
        assertEquals(expResult, result);

        read.closeSource();
    }

    /**
     * Test of getProcessedRows method, of class CSVParser.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetProcessedRows() throws FileNotFoundException {
        System.out.println("getProcessedRows");
        CSVParser read;
        read = new CSVParser("/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple.csv",
                             ",",
                             "/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple_header.txt");
        int expResult = 2;
        read.nextRow();
        read.nextRow();
        int result = read.getProcessedRows();
        assertEquals(expResult, result);
        read.closeSource();
    }

    /**
     * Test of getHeader method, of class CSVParser.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetHeader() throws FileNotFoundException {
        System.out.println("getHeader");
        CSVParser read;
        read = new CSVParser("/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple.csv",
                             ",",
                             "/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple_header.txt");
        String[] expResult = {"column1", "column2", "column3", "column4"};
        String[] result = read.getHeader();
        assertArrayEquals(expResult, result);
        read.closeSource();
    }

    /**
     * Test of moveLine method, of class CSVParser.
     * @throws java.io.FileNotFoundException
     */
    @org.junit.jupiter.api.Test
    public void testMoveLine() throws FileNotFoundException {
        System.out.println("moveLine");
        CSVParser read;
        read = new CSVParser("/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple.csv",
                             ",",
                             "/Users/NicholasBocchini/Development/databaseProject/src/test/resources/simple_header.txt");
        read.moveLine();
        ArrayList<HashMap<String, String>> expResult = new ArrayList<>();
        
        HashMap<String,String> map1 = new HashMap<>();
        map1.put("column1","2");
        
        HashMap<String,String> map2 = new HashMap<>();
        map2.put("column2","two");

        HashMap<String,String> map3 = new HashMap<>();
        map3.put("column3","test2");
        
        HashMap<String,String> map4 = new HashMap<>();
        map4.put("column4","1/2/2010");
        
        expResult.add(map1);
        expResult.add(map2);
        expResult.add(map3);
        expResult.add(map4);
        ArrayList<HashMap<String, String>> result = read.nextRow();
        assertEquals(expResult, result);
        
        read.closeSource();
    }
    
}
