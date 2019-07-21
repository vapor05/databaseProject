/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.databaseproject;

import java.util.Objects;

/**
 *
 * @author NicholasBocchini
 */
public class RowValue {
    private Object value;
    private String type;
    private boolean primaryKeyInd;
    
    public RowValue(Object inputValue, String inputType, boolean inputPrimaryKeyInd)
    {
        value = inputValue;
        type = inputType;
        primaryKeyInd = inputPrimaryKeyInd;
    }
    
    public String getType()
    {
        return type;
    }
    
    public boolean isPrimaryKey()
    {
        return primaryKeyInd;
    }
    
    public String getString()
    {
        return (String) value;
    }
    
    public int getInt()
    {
        return (int) value;
    }
    
    public float getFloat()
    {
        return (float) value;
    }
    
    public boolean getBoolean()
    {
        return (boolean) value;
    }
    
    public Object getValue()
    {
        switch (type.toLowerCase()) {
            case "string":
                return getString();
            case "int":
                return getInt();
            case "float":
                return getFloat();
            case "boolean":
                return getBoolean();
            default:
                break;
        }
        return getString();
    }
    
    
    @Override
    public boolean equals(Object inputValue)
    {
        boolean sameValue;
        boolean sameType;
        boolean sameKeyInd;
        
        if(inputValue instanceof String)
            return value.equals(inputValue);
        else if(inputValue instanceof Integer)
            return value.equals(inputValue);
        else if(inputValue instanceof Float)
            return value.equals(inputValue);
        else if(inputValue instanceof Boolean)
            return value.equals(inputValue);
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.value);
        hash = 83 * hash + Objects.hashCode(this.type);
        hash = 83 * hash + (this.primaryKeyInd ? 1 : 0);
        return hash;
    }
}
