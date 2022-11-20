/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.exceptions;


public class ImagemException extends Exception{
    public ImagemException() {

    }

    public ImagemException(String message) {
        super(message);
    }

    public ImagemException(Throwable cause) {
        super(cause);
    }

    public ImagemException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
