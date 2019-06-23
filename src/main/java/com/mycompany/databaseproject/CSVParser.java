/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.databaseproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author NicholasBocchini
 */
public class CSVParser {
    
    private File sourceFile;
    private String sourceDelimiter;
    private File headerFile;
    private String[] headerColumns;
    private Scanner sourceScan;
    private boolean hasHeaderRow;
    private int processedRows;
    
    public CSVParser(String sourcePath, String sourceDelim, String headerPath) throws FileNotFoundException
    {
        hasHeaderRow = true;
        processedRows = 0;
        sourceDelimiter = sourceDelim;
        
        headerFile = new File(headerPath);
        Scanner headerScan = new Scanner(new BufferedReader(new FileReader(headerFile)));
        headerScan.useDelimiter(Pattern.compile(","));
        
        ArrayList<String> headerColumnList = new ArrayList<>();
        while(headerScan.hasNext())
        {
            headerColumnList.add(headerScan.next());
        }
        headerColumns = headerColumnList.toArray(new String[headerColumnList.size()]);
        
        headerScan.close();
        
        sourceFile = new File(sourcePath);
        sourceScan = new Scanner(new BufferedReader(new FileReader(sourceFile)));
    }
    
    public void closeSource()
    {
        sourceScan.close();
    }
    
    public boolean hasNextLine()
    {
        return sourceScan.hasNextLine();
    }
    
    public ArrayList<HashMap<String, String>> nextRow()
    {
        Scanner line = new Scanner(sourceScan.nextLine());
        line.useDelimiter(Pattern.compile(sourceDelimiter));
        
        ArrayList<HashMap<String, String>> row = new ArrayList<>();
        for (String headerColumn : headerColumns) {
            HashMap<String, String> rowValue = new HashMap<>();
            rowValue.put((String) headerColumn, line.next());
            row.add(rowValue);
        }
        line.close();
        
        processedRows++;

        return row;
    }
    
    public void updateHasHeaderRow(boolean hasHeadRow)
    {
        hasHeaderRow = hasHeadRow;
    }
    
    public boolean isHeaderRow()
    {
        return hasHeaderRow && processedRows == 0;
    }
    
    public String[] getRowArray()
    {
        ArrayList<String> columnList = new ArrayList<>();
        
        while(sourceScan.hasNext())
        {
            columnList.add(sourceScan.next());
        }
        return (String[]) columnList.toArray();
    }
    
    public int getColumnNumber()
    {
        return headerColumns.length;
    }
    
    public int getProcessedRows()
    {
        return processedRows;
    }
    
    public String[] getHeader()
    {
        return headerColumns;
    }
    
    public void moveLine()
    {
        sourceScan.nextLine();
    }
    
}
