/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neuron.exceptions;

/**
 *
 * @author thiag
 */
public class TipoCombustivelException extends Exception{
    public TipoCombustivelException() {

    }

    public TipoCombustivelException(String message) {
        super(message);
    }

    public TipoCombustivelException(Throwable cause) {
        super(cause);
    }

    public TipoCombustivelException(String message, Throwable cause) {
        super(message, cause);
    }
}
