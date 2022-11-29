/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;

public class Cor {
    
    String nomeCor;
    int r;
    int g;
    int b;
    int alpha;

    public Cor() {
    }

    public Cor(String nomeCor, int r, int g, int b, int alpha) {
        this.nomeCor = nomeCor;
        this.r = r;
        this.g = g;
        this.b = b;
        this.alpha = alpha;
    }

    
    
    public String getNomeCor() {
        return nomeCor;
    }

    public void setNomeCor(String nomeCor) {
        this.nomeCor = nomeCor;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    @Override
    public String toString() {
        return nomeCor + ";" + r + ";" + g + ";" + b + ";" + alpha;
    }
    
    
    
    
}
