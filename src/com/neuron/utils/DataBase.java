/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.neuron.utils;

/**
 *
 * @author thiag
 */
public enum DataBase {
    MARCA("./src/com/neuron/database/dbMarca.txt"),
    MODELO("./src/com/neuron/database/dbModelo.txt"),
    VEICULO("./src/com/neuron/database/dbVeiculo.txt");
    
    private String desc;
    
    DataBase(String desc){
        this.desc = desc;
    }
    
    public String getPathDB(){
        return desc;
    }
}
