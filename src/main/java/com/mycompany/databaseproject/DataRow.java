/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.databaseproject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author NicholasBocchini
 */
public class DataRow {
    
    public ArrayList<HashMap<String,RowValue>> dataRow;
    private int columnCount;
    
    public DataRow(ArrayList<HashMap<String, RowValue>> inRow)
    {
        dataRow = inRow;
        columnCount = dataRow.size();
    }
    
    public ArrayList<Object> getColumnValues(String... columnNames)
    {
        int nVars = columnNames.length;
        ArrayList<Object> columnValues = new ArrayList<>();
        
        for(int i=0; i < nVars; i++)
        {
            String name = columnNames[i];
            RowValue rowValue;
            for(HashMap<String, RowValue> col : dataRow)
            {
                if(col.containsKey(name))
                {
                    rowValue = (RowValue) col.get(name);
                    columnValues.add(rowValue.getValue());
                    break;
                }
            }
        }
        return columnValues;
    }
}
