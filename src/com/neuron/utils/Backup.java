/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.utils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.neuron.templates.DataBase;


public class Backup {
    
    public static void Database() throws Exception{
        File orig = new File(DataBase.MARCA.getPathDB());
        File dest = new File(DataBase.BKPMARCA.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("dbMarca.txt backup realizado", Backup.class.getName());
        
        orig = new File(DataBase.IDMARCA.getPathDB());
        dest = new File(DataBase.BKPIDMARCA.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("IdControleMarca.txt backup realizado", Backup.class.getName());
        
        orig = new File(DataBase.MODELO.getPathDB());
        dest = new File(DataBase.BKPMODELO.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("dbModelo.txt backup realizado", Backup.class.getName());
        
        orig = new File(DataBase.IDMODELO.getPathDB());
        dest = new File(DataBase.BKPIDMODELO.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("IdControleModelo.txt backup realizado", Backup.class.getName());
        
        orig = new File(DataBase.VEICULO.getPathDB());
        dest = new File(DataBase.BKPVEICULO.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("dbVeiculo.txt backup realizado", Backup.class.getName());
        
        orig = new File(DataBase.IDVEICULO.getPathDB());
        dest = new File(DataBase.BKPIDVEICULO.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("IdControleVeiculo.txt backup realizado", Backup.class.getName());
        
        FileWriter file = new FileWriter(DataBase.BACKUP.getPathDB()+"log.txt");
        BufferedWriter log = new BufferedWriter(file);
        String hora = "Data e hora do backup realizado: "+datahora();
        log.write(hora);
        log.close();
    }
    
    public static void Restaurar() throws Exception{
        File orig = new File(DataBase.BKPMARCA.getPathDB());
        File dest = new File(DataBase.MARCA.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("dbMarca.txt restaurado", Backup.class.getName());

        orig = new File(DataBase.BKPIDMARCA.getPathDB());
        dest = new File(DataBase.IDMARCA.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("IdControleMarca.txt restaurado", Backup.class.getName());
        
        orig = new File(DataBase.BKPMODELO.getPathDB());
        dest = new File(DataBase.MODELO.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("dbModelo.txt restaurado", Backup.class.getName());

        orig = new File(DataBase.BKPIDMARCA.getPathDB());
        dest = new File(DataBase.IDMODELO.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("IdControleModelo.txt restaurado", Backup.class.getName());

        orig = new File(DataBase.BKPVEICULO.getPathDB());
        dest = new File(DataBase.VEICULO.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("dbVeiculo.txt restaurado", Backup.class.getName());

        orig = new File(DataBase.BKPIDMARCA.getPathDB());
        dest = new File(DataBase.IDVEICULO.getPathDB());
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Logs.logger("IdControleVeiculo.txt restaurado", Backup.class.getName());
        
        FileWriter file = new FileWriter(DataBase.BACKUP.getPathDB()+"log.txt");
        BufferedWriter log = new BufferedWriter(file);
        String hora = "Data e hora da restauracao realizada: " + datahora();
        log.write(hora);
        log.close();
    }
    
    /*public static void Marca() throws Exception{
    File orig = new File(DataBase.MARCA.getPathDB());
    File dest = new File(DataBase.BACKUP.getPathDB());
    Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    Logs.logger("dbMarca.txt backup realizado", Backup.class.getName());
    
    orig = new File(DataBase.IDMARCA.getPathDB());
    Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    Logs.logger("IdControleMarca.txt backup realizado", Backup.class.getName());
    
    FileWriter file = new FileWriter(DataBase.BACKUP.getPathDB());
    BufferedWriter log = new BufferedWriter(file);
    String hora = "Data e hora do backup da Marca e ID realizados: " + datahora();
    log.write(hora);
    log.close();
    }
    
    public static void RestaurarMarca() throws Exception{
    File dest = new File(DataBase.RESTORE.getPathDB());
    File orig = new File(DataBase.BACKUP.getPathDB()+"dbMarca.txt");
    Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    Logs.logger("dbMarca.txt restaurado", Backup.class.getName());
    
    orig = new File(DataBase.IDMARCA.getPathDB());
    Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    Logs.logger("IdControleMarca.txt restaurado", Backup.class.getName());
    
    FileWriter file = new FileWriter(DataBase.BACKUP.getPathDB());
    BufferedWriter log = new BufferedWriter(file);
    String hora = "Data e hora da restauracao de Marca e ID realizados: " + datahora();
    log.write(hora);
    log.close();
    }
    
    public static void Modelo() throws Exception{
    File dest = new File(DataBase.BACKUP.getPathDB());
    File orig = new File(DataBase.MODELO.getPathDB());
    Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    Logs.logger("dbModelo.txt backup realizado", Backup.class.getName());
    
    orig = new File(DataBase.IDMODELO.getPathDB());
    Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    Logs.logger("IdControleModelo.txt backup realizado", Backup.class.getName());
    
    FileWriter file = new FileWriter(DataBase.BACKUP.getPathDB());
    BufferedWriter log = new BufferedWriter(file);
    String hora = "Data e hora do backup do Modelo e ID realizados: " + datahora();
    log.write(hora);
    log.close();
    }
    
    public static void Veiculo() throws Exception{
    File orig = new File(DataBase.VEICULO.getPathDB());
    File dest = new File(DataBase.BACKUP.getPathDB());
    Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    Logs.logger("dbVeiculo.txt backup realizado", Backup.class.getName());
    
    orig = new File(DataBase.IDVEICULO.getPathDB());
    Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    Logs.logger("IdControleVeiculo.txt backup realizado", Backup.class.getName());
    
    FileWriter file = new FileWriter(DataBase.BACKUP.getPathDB());
    BufferedWriter log = new BufferedWriter(file);
    String hora = "Data e hora do backup dos Veiculos e ID realizados: " + datahora();
    log.write(hora);
    log.close();
    }*/
    
    private static String datahora() {
        Date data = new Date();
        SimpleDateFormat horaFormatada = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        return (dataFormatada.format(data) + " as " + horaFormatada.format(data));
    }
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
