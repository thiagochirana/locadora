/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.exceptions;


public class DataBaseException extends Exception{
    public DataBaseException() {

    }

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(Throwable cause) {
        super(cause);
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
