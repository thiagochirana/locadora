/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Logs {
    public static void logger(String msg,String nomeClasse){
        Date data = new Date();
        String saidaLog = "";
        SimpleDateFormat datahora = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        
        saidaLog += datahora.format(data) + " :: "+nomeClasse+" : "+msg;
        System.out.println(saidaLog);
    }
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
