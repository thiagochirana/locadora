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
    IDMARCA("./src/com/neuron/database/idControleMarca.txt"),
    
    MODELO("./src/com/neuron/database/dbModelo.txt"),
    IDMODELO("./src/com/neuron/database/idControleModelo.txt"),
    
    VEICULO("./src/com/neuron/database/dbVeiculo.txt"),
    IDVEICULO("./src/com/neuron/database/idControleVeiculo.txt"),
    
    BKPMARCA("./src/com/neuron/temp/database/dbMarca.txt"),
    BKPIDMARCA("./src/com/neuron/temp/database/idControleMarca.txt"),
    
    BKPMODELO("./src/com/neuron/temp/database/dbModelo.txt"),
    BKPIDMODELO("./src/com/neuron/temp/database/idControleModelo.txt"),
    
    BKPVEICULO("./src/com/neuron/temp/database/dbVeiculo.txt"),
    BKPIDVEICULO("./src/com/neuron/temp/database/idControleVeiculo.txt"),
    
    BACKUP("./src/com/neuron/temp/database/"),
    RESTORE("./src/com/neuron/database/");
    
    
    private String desc;
    
    DataBase(String desc){
        this.desc = desc;
    }
    
    public String getPathDB(){
        return desc;
    }
}
