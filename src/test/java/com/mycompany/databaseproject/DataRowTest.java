/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.databaseproject;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author NicholasBocchini
 */
public class DataRowTest {
    /**
     * Test of getColumnValues method, of class DataRow.
     */
    
    @Test
    public void testGetColumnValues()
    {
        ArrayList<HashMap<String, RowValue>> testRow = new ArrayList<>();
        HashMap<String, RowValue> map1 = new HashMap();
        RowValue row1 = new RowValue(1, "int", true);
        map1.put("col1", row1);
        
        HashMap<String, RowValue> map2 = new HashMap();
        RowValue row2 = new RowValue("test", "string", false);
        map2.put("col2", row2);
        
        HashMap<String, RowValue> map3 = new HashMap();
        RowValue row3 = new RowValue(1.1f, "float", false);
        map3.put("col3", row3);
        
        HashMap<String, RowValue> map4 = new HashMap();
        RowValue row4 = new RowValue(true, "boolean", false);
        map4.put("col4", row4);
        
        DataRow testDataRow = new DataRow(testRow);
        
        ArrayList<Object> result = testDataRow.getColumnValues("col1");
        System.out.println(testDataRow.dataRow.get().get("col1").getValue());
        System.out.println(row1);
        System.out.println(row1.getValue());
        System.out.println(testDataRow);
        System.out.println(result);
        ArrayList<Object> expResult = new ArrayList<Object>();
        expResult.add(1);
        expResult.add("test");
        expResult.add(1.1f);
        expResult.add(true);
        
        assertEquals(expResult, result);
    }
}
