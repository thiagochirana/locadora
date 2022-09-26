/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neuron.utils;

import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author thiag
 */
public class Email {
    private final String emailNeutron = "machinesdotcom@gmail.com";
    private final String senhaNeutron = "pdjbpljhunhmtoee";
    
    public void sendToken(){
        SimpleEmail email = new SimpleEmail();
        email.setSSLOnConnect(true);
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(emailNeutron,senhaNeutron));
        
        
        try {
            email.setFrom(emailNeutron);
            email.setSubject("Seu Token de Recuperação de Senha");
            email.setMsg("Teste de email");
            email.addTo(emailNeutron);
            email.send();   
            
        } catch (EmailException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    
}
