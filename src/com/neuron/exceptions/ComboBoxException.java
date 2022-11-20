/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neuron.exceptions;

/**
 *
 * @author thiag
 */
public class ComboBoxException extends Exception{
    public ComboBoxException() {

    }

    public ComboBoxException(String message) {
        super(message);
    }

    public ComboBoxException(Throwable cause) {
        super(cause);
    }

    public ComboBoxException(String message, Throwable cause) {
        super(message, cause);
    }
}
