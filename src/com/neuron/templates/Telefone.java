/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;


public class Telefone {
    int DDD;
    int DDI;
    int numero;

    public Telefone(int DDD, int DDI, int numero) {
        this.DDD = DDD;
        this.DDI = DDI;
        this.numero = numero;
    }

    public Telefone() {
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public int getDDI() {
        return DDI;
    }

    public void setDDI(int DDI) {
        this.DDI = DDI;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return DDI + ";" + DDD + ";" + numero;
    }
    
    
}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo